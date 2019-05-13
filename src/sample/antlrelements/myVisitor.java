package sample.antlrelements;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import org.antlr.v4.runtime.tree.ErrorNode;
import sample.antlrelements.languageelements.MyLanguageBaseVisitor;
import sample.antlrelements.languageelements.MyLanguageParser;
import sample.commands.*;
import sample.controllers.BoardController;
import sample.models.Coords;

import java.util.*;

/**
 * saját visitor osztály, a generált MyLanguageBaseVisitorból származtatva
 * a felülírt emtódusok segítségével végigjárhatom a generált fát
 */
public class myVisitor extends MyLanguageBaseVisitor<Object> {



    /**
     * saját controller példány
     */
    private BoardController mycontroller;

    private Stack<Command> toDos;

    private Stack<Command> done;

    private List<Command> tmpQueue;

    private Map<String, List<Command>> functions;

    private boolean inFunc = false;

    private boolean inBranch = false;

    private Timeline t;

    public void forward() throws WrongStepError {
        if (toDos.size() > 0) {
            Command tmp = toDos.pop();
            tmp.doIt();
            done.push(tmp);
            //TODO előre léptetésnél is álljon le ha vízbe érek
            //TODO kell a visszatérés akkor a commandoknál és a goknál?
        }
    }

    public void back() throws WrongStepError {
        if (done.size() > 0) {
            Command tmp = done.pop();
            tmp.undoIt();
            toDos.push(tmp);
        }
    }

    public void shouldIStop(){
        if(mycontroller.getActualTileType().equals("WATER")) stop();
    }

    public void stop() {
        if (t != null) t.stop();
        toDos.clear();
        done.clear();
        mycontroller.ended();
    }

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
        t.play();
        t.setOnFinished(e -> play2());
    }

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

    public void clear() {
        toDos.clear();
        done.clear();
        tmpQueue.clear();
    }

    /**
     * konstruktor
     * beállítja a kontroller példányt
     * -1 re inicializálja az ifek számát, hogy tudjuk követni a listát
     *
     * @param ctrl controller példány
     */
    public myVisitor(BoardController ctrl) {

        mycontroller = ctrl;
        functions = new HashMap<>();
    }

    /**
     * a program gyökerének bejárására szolgál
     * bejárja a gyerekit
     * meghívja a bejárás ereményét megmutató controller fvt
     * visszaállítja  a hibajelző boolt
     *
     * @param ctx
     * @return
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
     * bejárja a megfelelő parancssorokat, ha nincs hiba
     * gyerekei parancsok vagy stuktúrák
     *
     * @param ctx
     * @return
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
     * bejárja a gyerekeit, ha nincs hiba
     * innen indul a ciklus vagy elágazás
     *
     * @param ctx
     * @return
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
     * elágazást bejáró utasítás, csak akkor fut le, ha nem volt addig hiba
     * megszámoljuk a gyerekeket és meglátogatjuk a másodikat, ami az if feltétele
     * ha igaz a feltétel, az igaz ágat látogatjuk meg
     * ha van else ág, akkor beállítjuk a megfelelő segédváltozókat, jelezve hogy  van egy ifünk és éppen ennek az elsét vizsgáljuk
     * miután meglátogattuk, visszaállítjuk a paramétereket, hogy később más ezt ne használhassa már
     *
     * @param ctx
     * @return
     */
    @Override
    public Object visitBranch(MyLanguageParser.BranchContext ctx) {

        inBranch = true;
        String color = (String)visit(ctx.getChild(2).getChild(2));

        IfCommand cmd = new IfCommand(mycontroller, color.toUpperCase(), toDos);

        for (int i = 0; i < ctx.getChild(6).getChildCount(); i++) {
            List<Command> tmp = (ArrayList) visit(ctx.getChild(6).getChild(i).getChild(0));
            //TODO itt száll el, az még nem működik, hogy hányszor kerül bele a command a listába
            //TODO lejátszás check
            //for(int j=0;j<Integer.parseInt(ctx.getChild(6).getChild(i).getChild(2).toString());j++){
            for (Command c:tmp){
                cmd.addTrueCommand(c);
            }

            //}

        }
        inBranch = true;
        if (ctx.getChildCount() == 9) { //feltétel nem igaz, ha van else ág, mehet az
            List<Command> list = (ArrayList)visit(ctx.getChild(8));
            for (Command c:list) {
                int i=0;
               // for(int j=0;j<Integer.parseInt(ctx.getChild(6).getChild(i).getChild(2).toString());j++){
                    cmd.addFalseCommand(c);
              //  }
                i++;
            }
        }
        //if(!(inFunc || inBranch))tmpQueue.add(cmd);
        inBranch = false;
        List<Command> commands = new ArrayList<>();
        commands.add(cmd);
        return commands;
    }

    /**
     * else ág meglátogatására szolgál
     * csak akkor fut le, ha nincs hiba előtte
     * lefut, ha tartozik hozzá megfelelően if
     *
     * @param ctx
     * @return
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
     * ciklust reprezentáló csomópont futtatására szolgál
     * csak akkor fut le, ha nem volt hiba
     * a kapott paraméterszer futtatjuk a kapott parancsokat repprezentáló gyerekágat
     *
     * @param ctx
     * @return
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
        //if (!(inFunc || inBranch)) tmpQueue.addAll(commands);
        return commands;
    }

    /**
     * egyenlőséget vizgsáló csomópont
     * akkor fut le, ha nem volt hiba
     * összehasonlítja a két gyerekág kimenetét, és visszaadja, hogy egyformák e
     *
     * @param ctx
     * @return
     */
    @Override
    public Object visitEquality(MyLanguageParser.EqualityContext ctx) {

        Object o1 = visit(ctx.getChild(0));
        Object o2 = visit(ctx.getChild(2));

        return o1.equals(o2);

    }

    /**
     * parancsot reprezentáló objektum bejárása, ha nem volt hiba
     * továbblép a gyerekekre
     *
     * @param ctx
     * @return
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
     * go utasítás feldolgozása
     * csak akkor fut le, ha nem volt hiba
     * a kapott paraméterszer futtatja a robot goját, ha közben érvényes mezőre lép
     * ha rossz helyre lépne, hibát jelez és leáll, beállítja a hibajelző boolt
     * rossz input esetén jelez
     *
     * @param ctx
     * @return
     */
    @Override
    public Object visitGoThere(MyLanguageParser.GoThereContext ctx) {

        List<Command> commands = new ArrayList<>();

        int db = Integer.parseInt(ctx.getChild(2).getText());
        int i = 0;

        Command c = new GoCommand(mycontroller);

        while (i < db) {
          //  if (!(inFunc || inBranch)) tmpQueue.add(c);
            commands.add(c);
            i++;
        }

        return commands;
    }

    /**
     * gombnyomást reprezentáló csomópont bejárása
     * ha nem volt hiba, gombnyomást szimulál a controllerben
     *
     * @param ctx
     * @return
     */
    @Override
    public Object visitPushIt(MyLanguageParser.PushItContext ctx) {

        List<Command> commands = new ArrayList<>();
        Command c = new PushCommand(mycontroller);
        //if (!inFunc && !inBranch) tmpQueue.add(c);
        commands.add(c);

        return commands;
    }

    /**
     * objektum megevését reprezentálja
     * ha nem volt hiba
     * a kontrolerbe hív tovább
     *
     * @param ctx
     * @return
     */
    @Override
    public Object visitEatIt(MyLanguageParser.EatItContext ctx) {

        List<Command> commands = new ArrayList<>();
        Command c = new EatCommand(mycontroller);
       // if (!inFunc && !inBranch) tmpQueue.add(c);
        commands.add(c);

        return commands;
    }

    /**
     * robot színének visszaadását reprezentálja
     * ha nem volt hiba
     * visszaadja a szín stringesített, kisbetűs változatát
     *
     * @param ctx
     * @return
     */
    @Override
    public Object visitGetColor(MyLanguageParser.GetColorContext ctx) {
        return mycontroller.getRobotColor().toString().toLowerCase();
    }

    /**
     * balra fordulásért felelős parancsot dolgozza fel
     * ha nem volt hiba
     * a feltételben megadott számszor futtatja le
     * hibás input esetén jelez
     *
     * @param ctx
     * @return
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
     * jobbra fordulásért felelős parancsot dolgozza fel
     * ha nem volt hiba
     * a feltételben megadott számszor futtatja le
     * hibás input esetén jelez
     *
     * @param ctx
     * @return
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
     * kézi színmegadást ellenőrző csomópont
     * jelenleg csak két színt tud kezelni
     *
     * @param ctx
     * @return
     */
    @Override
    public Object visitColor(MyLanguageParser.ColorContext ctx) {

        return ctx.getText();

    }

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
     *
     * @param errorNode
     * @return
     */
    @Override
    public Object visitErrorNode(ErrorNode errorNode) {
        mycontroller.erroring();

        return null;
    }

}
