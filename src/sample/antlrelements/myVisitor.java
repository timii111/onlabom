package sample.antlrelements;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import org.antlr.v4.runtime.tree.ErrorNode;
import sample.WrongStepError;
import sample.antlrelements.languageelements.MyLanguageBaseVisitor;
import sample.antlrelements.languageelements.MyLanguageParser;
import sample.commands.*;
import sample.controllers.BoardController;

import java.util.*;

/**
 * saját visitor osztály, a generált MyLanguageBaseVisitorból származtatva
 * a felülírt emtódusok segítségével végigjárhatom a generált fát
 */
public class myVisitor extends MyLanguageBaseVisitor<Object> {

    /** saját controller példány */
    private BoardController mycontroller;
    /** a még hátralévő parancsok tárolására szolgáló verem */
    private Stack<Command> toDos;
    /** a végrehajtott parancsok tárolására szolgáló verem */
    private Stack<Command> done;
    /** parancstároló lista, a tennivalók feltöltéséhez */
    private List<Command> tmpQueue;
    /** a függvényeket és a hozzájuk tartozó utasításokat tartalmazó map */
    private Map<String, List<Command>> functions;
    /** függvényt jelző flag */
    private boolean inFunc = false;
    /** elágazást jelző flag */
    private boolean inBranch = false;
    /** timeline az animációkhoz */
    private Timeline t;

    /**
     * előre léptető függvény
     * kivesz egy parancsot a hátralévőkből, végrehajtja, majd az elkészültek közé teszi
     * hiba esetén leállítja a folyamatot
     */
    public void forward(){
        try{
            if (toDos.size() > 0) {
                Command tmp = toDos.pop();
                tmp.doIt();
                done.push(tmp);
            }
        }catch (WrongStepError e){
            stop();
        }
    }

    /**
     * visszaléptető függvény
     * kivesz egy parancsot a végrehajtottakból, visszaállítja, majd a hátralévők közé teszi
     * hiba esetén leállítja a folyamatot
     */
    public void back(){
        try{
            if (done.size() > 0) {
                Command tmp = done.pop();
                tmp.undoIt();
                toDos.push(tmp);
            }
        }catch (WrongStepError e){
            stop();
        }
    }

    /**
     * vízre lépés esetén megállítja a folyamatot
     */
    public void shouldIStop(){
        if(mycontroller.getActualTileType().equals("WATER")) stop();
    }

    /**
     * leállítja a lejátszási folyamatokat
     * törli a parancs objektumokat
     */
    public void stop() {
        if (t != null) t.stop();
        toDos.clear();
        done.clear();
        mycontroller.ended();
    }

    /**
     * a végrehajtott lépések automatizált lejátszása
     * létrehoz egy animációt a meglévő parancsokból, az első elágazásig
     * másodpercenként lép egyet, ellenőrzi, nem kell-e leállnia
     * a leállás esetén a folytatás függvényt hívja meg
     */
    public void play(){

        t = new Timeline();
        int i = 1;

        while (toDos.size() > 0 && !(toDos.peek() instanceof IfCommand)) {
            Command tmp = toDos.pop();

            KeyFrame kf = new KeyFrame(Duration.seconds(i), e -> {
                try {
                    tmp.doIt();
                } catch (WrongStepError wrongStepError) {
                    stop();
                }
                shouldIStop();
            });

            t.getKeyFrames().add(kf);
            done.push(tmp);
            i++;

        }
        if (t.getKeyFrames().size() == 0) {
            mycontroller.ended();
        }else{
            t.play();
            t.setOnFinished(e -> play2());
        }
    }

    /**
     * lejátszás folytatása
     * ha van még tennivaló, azaz if-hez értünk, kiértékeljük az if-et és újraindítjuk a folyamatot
     * egyébként a folyamat leállítása
     */
    public void play2() {
        if(toDos.size()>0){
            try {
                toDos.pop().doIt();
            } catch (WrongStepError wrongStepError) {
                stop();
            }
            play();
        } else {
            mycontroller.ended();
        }
    }

    /**
     * törli a parancsokat
     */
    public void clear() {
        toDos.clear();
        done.clear();
        tmpQueue.clear();
    }

    /**
     * konstruktor
     * beállítja a kontroller példányt és a map-et
     */
    public myVisitor(BoardController ctrl) {

        mycontroller = ctrl;
        functions = new HashMap<>();
    }

    /**
     * a program gyökerének bejárására szolgál
     * bejárja a gyerekit
     * a parancsok ideiglenes tárolására szolgáló listát átmásolja a tároló verembe
     */
    @Override
    public Object visitProgram(MyLanguageParser.ProgramContext ctx) {

        toDos = new Stack<>();
        done = new Stack<>();

        tmpQueue = new ArrayList<>();

        visitChildren(ctx);
        for (int i = tmpQueue.size() - 1; i >= 0; i--) {
            toDos.push(tmpQueue.get(i));
        }

        return null;

    }

    /**
     * bejárja a parancssor típusú csomópontot
     * bejárja a gyerekeit, összegyűjti a visszaadott parancsokat
     * ha nem függvényben vagy elágazásban vagyunk, akkor hozzáadja a tároló listához őket
     * visszatér a parancsokkal
     */
    @Override
    public Object visitCommandlines(MyLanguageParser.CommandlinesContext ctx) {
        List<Command> commands = new ArrayList<>();
        for (int i=0; i<ctx.getChildCount();i++){
           commands.addAll((ArrayList)visit(ctx.getChild(i)));
        }

        if (!inFunc && !inBranch) tmpQueue.addAll(commands);

        return commands;
    }

    /**
     * struktúrát bejáró metódus
     * bejárja a gyerek csomópontjait, összegyűjti a parancsokat tőlük, majd visszatér a listájukkal
     */
    @Override
    public Object visitStructure(MyLanguageParser.StructureContext ctx) {
        List<Command> commands = new ArrayList<>();
        for (int i=0; i<ctx.getChildCount();i++){
            commands.addAll((ArrayList)visit(ctx.getChild(i)));
        }

        return commands;
    }

    /**
     * beállítja a branch jelző flaget
     * ezt az igaz ág után is megteszi, az egymásba ágyazott if-ek kikerülése érdekében
     * létrehoz egy ifcommandot
     * bejárja az igaz ágas utasításait, hozzáadja a commandhoz a létrejött commandokat
     * ha van hamis ág, azt is bejárja és ugyanígy jár el
     * visszaadja az if commandot listaként
     */
    @Override
    public Object visitBranch(MyLanguageParser.BranchContext ctx) {

        inBranch = true;
        String color = (String)visit(ctx.getChild(2).getChild(2));

        IfCommand cmd = new IfCommand(mycontroller, color.toUpperCase(), toDos);

        for (int i = 0; i < ctx.getChild(6).getChildCount(); i++) {
            List<Command> tmp = (ArrayList) visit(ctx.getChild(6).getChild(i).getChild(0));
            for (Command c:tmp){
                cmd.addTrueCommand(c);
            }
        }
        inBranch = true;
        if (ctx.getChildCount() == 9) { //feltétel nem igaz, ha van else ág, mehet az
            List<Command> list = (ArrayList)visit(ctx.getChild(8));
            for (Command c:list) {
                int i=0;
                cmd.addFalseCommand(c);
                i++;
            }
        }
        inBranch = false;
        List<Command> commands = new ArrayList<>();
        commands.add(cmd);
        return commands;
    }

    /**
     * elágazás hamis ága
     * bejárja a gyerekeit, összegyűjti a létrejött parancsokat, majd visszatér velük
     */
    @Override
    public Object visitElseStatement(MyLanguageParser.ElseStatementContext ctx) {
        List<Command> cmd = new ArrayList<>();
        for (int i = 0; i < ctx.getChild(2).getChildCount(); i++) {
            List<Command> tmp = (ArrayList) visit(ctx.getChild(2).getChild(i).getChild(0));
            cmd.addAll(tmp);
        }

        return cmd;
    }

    /**
     * ciklust bejáró metódus
     * bejárja a gyerekeit, összeállítja a visszatért commandok listáját
     * ezt végül a ciklusszámlálónyiszor fűzi egymás után, és tér vissza ezzel
     */
    @Override
    public Object visitCycle(MyLanguageParser.CycleContext ctx) {
        List<Command> commands = new ArrayList<>();
        String tmp = ctx.getChild(6).toString();
        int db = Integer.parseInt(tmp);
        for (int i = 0; i < db; i++) {
            for (int j=0; j<ctx.getChild(2).getChildCount();j++){
                commands.addAll((ArrayList) visit(ctx.getChild(2).getChild(j).getChild(0)));
            }
        }
        return commands;
    }

    /**
     * egyenlőséget vizgsáló csomópont
     * összehasonlítja a két gyerekág kimenetét, és visszaadja, hogy egyformák e
     */
    @Override
    public Object visitEquality(MyLanguageParser.EqualityContext ctx) {

        Object o1 = visit(ctx.getChild(0));
        Object o2 = visit(ctx.getChild(2));

        return o1.equals(o2);

    }

    /**
     * parancsot bejáró metódus
     * bejárja a gyerekeit, összegyűjti a visszaadott commandokat, majd visszatér velük
     */
    @Override
    public Object visitCommand(MyLanguageParser.CommandContext ctx) {
        List<Command> commands = new ArrayList<>();
        for (int i=0; i<ctx.getChildCount();i++){
            commands.addAll((ArrayList)visit(ctx.getChild(i)));
        }

        return commands;
    }

    /**
     * a kapott számú gocommandot fűz össze, majd tér velük vissza
     */
    @Override
    public Object visitGoThere(MyLanguageParser.GoThereContext ctx) {

        List<Command> commands = new ArrayList<>();

        int db = Integer.parseInt(ctx.getChild(2).getText());
        int i = 0;

        Command c = new GoCommand(mycontroller);

        while (i < db) {
            commands.add(c);
            i++;
        }

        return commands;
    }

    /**
     * visszatér egy gombnyomást hívó commanddal
     */
    @Override
    public Object visitPushIt(MyLanguageParser.PushItContext ctx) {

        List<Command> commands = new ArrayList<>();
        Command c = new PushCommand(mycontroller);
        commands.add(c);

        return commands;
    }

    /**
     * visszatér egy kulcsfelvételt szimbolizáló paranccsal
     */
    @Override
    public Object visitEatIt(MyLanguageParser.EatItContext ctx) {

        List<Command> commands = new ArrayList<>();
        Command c = new EatCommand(mycontroller);
        commands.add(c);

        return commands;
    }

    /**
     * visszaadja a robot színét
     */
    @Override
    public Object visitGetColor(MyLanguageParser.GetColorContext ctx) {
        return mycontroller.getRobotColor().toString().toLowerCase();
    }

    /**
     * visszaad a paraméternyi balra fordító commandot egy listában
     */
    @Override
    public Object visitTurnLeft(MyLanguageParser.TurnLeftContext ctx) {

        List<Command> commands = new ArrayList<>();

        int db = Integer.parseInt(ctx.getChild(2).getText());
        for (int i = 0; i < db; i++) {
            Command c = new TurnLeftCommand(mycontroller);
       //     if (!inFunc && !inBranch) tmpQueue.add(c);
            commands.add(c);
        }
        return commands;
    }

    /**
     * visszaad a paraméternyi jobbra fordító commandot egy listában
     */
    @Override
    public Object visitTurnRight(MyLanguageParser.TurnRightContext ctx) {

        List<Command> commands = new ArrayList<>();

        int db = Integer.parseInt(ctx.getChild(2).getText());
        for (int i = 0; i < db; i++) {
            Command c = new TurnRightCommand(mycontroller);
          /*  if (!inFunc && !inBranch) {
                tmpQueue.add(c);
            }*/
            commands.add(c);
        }

        return commands;
    }

    /**
     * visszaadja a színt
     */
    @Override
    public Object visitColor(MyLanguageParser.ColorContext ctx) {
        return ctx.getText();
    }

    /**
     * függvényt definiáló csomópont
     * az őt alkotó függvényhívások commandjait eltárolja a mapben
     */
    @Override
    public Object visitFunction_def(MyLanguageParser.Function_defContext ctx) {

        inFunc = true;

        String name = ctx.getChild(1).getText();
        functions.put(name, new ArrayList<>());
        for (int i = 0; i < ctx.getChild(5).getChildCount(); i++) {
            List<Command> tmp = (ArrayList) visit(ctx.getChild(5).getChild(i).getChild(0));
            functions.get(name).addAll(tmp);
        }

        inFunc = false;

        return null;
    }

    /**
     * függvényhívást implementáló metódus
     * a függvényt alkotó commandok listáját adja vissza, a paraméterben szereplő számnak megfelelően
     */
    @Override
    public Object visitFunction_call(MyLanguageParser.Function_callContext ctx) {

        String name = ctx.getChild(0).getText();

        List<Command> commands = functions.get(name);

        int howmany = Integer.parseInt(ctx.getChild(2).getText());

        List<Command> list = new ArrayList<>();
        for(int i=0;i<howmany;i++)
            list.addAll(commands);

        return list;
    }

    /**
     * hibajelzésért felelős csomópont
     */
    @Override
    public Object visitErrorNode(ErrorNode errorNode) {
        mycontroller.erroring();

        return null;
    }

}
