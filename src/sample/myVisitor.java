package sample;

import org.antlr.v4.runtime.tree.ErrorNode;
import sample.antlrelements.MyLanguageBaseVisitor;
import sample.antlrelements.MyLanguageParser;
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
    //TODO kell e a gamecontrollerre hivatkozni innen?
    /**
     * az egymásba ágyazott ifek és random else ágak kezelésére szolgál
     */
    private List<Boolean> ifs = new ArrayList<Boolean>();
    /** ifek számát mutatja meg -1 */
    private int countonif;
    /** megmutatja, történt e hiba a feldolgozás során - ha vízre léptünk, ne folytassuk a játékot */
    private boolean thereWasError = false;

    private Stack<Command> toDos;

    private Stack<Command> done;

    private List<Command> tmpQueue;

    private Map<String, List<Command>> functions;

    private boolean inFunc = false;

    public void forward(){
        if(toDos.size() >0) {
            Command tmp = toDos.pop();
            tmp.doIt();
            done.push(tmp);
        }
    }

    public void back(){
        if(done.size() >0){
            Command tmp = done.pop();
            tmp.undoIt();
            toDos.push(tmp);
        }
    }

    public void play(){
        while(toDos.size()>0){
            forward();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                //TODO értelmes hibakezelés
                e.printStackTrace();
            }
        }
    }

    public void clear(){
        toDos.clear();
        done.clear();
        tmpQueue.clear();
    }

    /**
     * konstruktor
     * beállítja a kontroller példányt
     * -1 re inicializálja az ifek számát, hogy tudjuk követni a listát
     * @param ctrl controller példány
     */
    public myVisitor(BoardController ctrl){

        mycontroller = ctrl;
        countonif = -1;

        functions = new HashMap<>();
    }

    /**
     * a program gyökerének bejárására szolgál
     * bejárja a gyerekit
     * meghívja a bejárás ereményét megmutató controller fvt
     * visszaállítja  a hibajelző boolt
     * @param ctx
     * @return
     */
    @Override
    public Object visitProgram(MyLanguageParser.ProgramContext ctx) {

        toDos = new Stack<>();
        done = new Stack<>();

        tmpQueue = new ArrayList<>();
        //TODO queueból átrakni a todo stackbe, megfelelő sorrendben

        visitChildren(ctx);
        for(int i=tmpQueue.size()-1; i>=0;i--){
            toDos.push(tmpQueue.get(i));
        }
        //TODO kezelni a játék végét
        //mycontroller.ended();
        thereWasError = false;
        return null;

    }

    /**
     * bejárja a megfelelő parancssorokat, ha nincs hiba
     * gyerekei parancsok vagy stuktúrák
     * @param ctx
     * @return
     */
    @Override
    public Object visitCommandlines(MyLanguageParser.CommandlinesContext ctx) {

        if(!thereWasError) visitChildren(ctx);
        return null;
    }

    /**
     * bejárja a gyerekeit, ha nincs hiba
     * innen indul a ciklus vagy elágazás
     * @param ctx
     * @return
     */
    @Override
    public Object visitStructure(MyLanguageParser.StructureContext ctx) {

        if(!thereWasError) visitChildren(ctx);
        return null;
    }

    /**
     * elágazást bejáró utasítás, csak akkor fut le, ha nem volt addig hiba
     * megszámoljuk a gyerekeket és meglátogatjuk a másodikat, ami az if feltétele
     * ha igaz a feltétel, az igaz ágat látogatjuk meg
     * ha van else ág, akkor beállítjuk a megfelelő segédváltozókat, jelezve hogy  van egy ifünk és éppen ennek az elsét vizsgáljuk
     * miután meglátogattuk, visszaállítjuk a paramétereket, hogy később más ezt ne használhassa már
     * @param ctx
     * @return
     */
    @Override
    public Object visitBranch(MyLanguageParser.BranchContext ctx) {

        if(!thereWasError){
            boolean b = (Boolean) visit(ctx.getChild(2));
            int i=ctx.getChildCount();

            if(b){ //feltétel igaz
                visit(ctx.getChild(6));
            }else if(i==9){ //feltétel nem igaz, ha van else ág, mehet az
                ifs.add(true);
                countonif++;
                visit(ctx.getChild(8));
                ifs.set(countonif,false);
                countonif--;
            }
        }


        return null;
    }

    /**
     * else ág meglátogatására szolgál
     * csak akkor fut le, ha nincs hiba előtte
     * lefut, ha tartozik hozzá megfelelően if
     * @param ctx
     * @return
     */
    @Override
    public Object visitElseStatement(MyLanguageParser.ElseStatementContext ctx) {
        if(!thereWasError){
            if(countonif > -1 && ifs.get(countonif)){
                visitChildren(ctx);
            }
        }
        return null;
    }

    /**
     * ciklust reprezentáló csomópont futtatására szolgál
     * csak akkor fut le, ha nem volt hiba
     * a kapott paraméterszer futtatjuk a kapott parancsokat repprezentáló gyerekágat
     * @param ctx
     * @return
     */
    @Override
    public Object visitCycle(MyLanguageParser.CycleContext ctx) {
        if(!thereWasError){

                String tmp = ctx.getChild(ctx.getChildCount()-2).toString();
                int db = Integer.parseInt(tmp);
                for(int i=0; i<db;i++) {
                    visitChildren(ctx);
                }
        }

        return null;
    }

    /**
     * egyenlőséget vizgsáló csomópont
     * akkor fut le, ha nem volt hiba
     * összehasonlítja a két gyerekág kimenetét, és visszaadja, hogy egyformák e
     * @param ctx
     * @return
     */
    @Override
    public Object visitEquality(MyLanguageParser.EqualityContext ctx) {

        if(!thereWasError){
            Object o1 = visit(ctx.getChild(0));
            Object o2 = visit(ctx.getChild(2));

            return o1.equals(o2);
        }
        return  null;
    }

    /**
     * parancsot reprezentáló objektum bejárása, ha nem volt hiba
     * továbblép a gyerekekre
     * @param ctx
     * @return
     */
    @Override
    public Object visitCommand(MyLanguageParser.CommandContext ctx) {
        if(!thereWasError){
            visitChildren(ctx);
        }

        return null;
    }

    /**
     * go utasítás feldolgozása
     * csak akkor fut le, ha nem volt hiba
     * a kapott paraméterszer futtatja a robot goját, ha közben érvényes mezőre lép
     * ha rossz helyre lépne, hibát jelez és leáll, beállítja a hibajelző boolt
     * rossz input esetén jelez
     * @param ctx
     * @return
     */
    @Override
    public Object visitGoThere(MyLanguageParser.GoThereContext ctx) {

        if(!thereWasError){
            String tmp = ctx.getChild(2).getText();

                int db = Integer.parseInt(ctx.getChild(2).getText());
                int i=1;

                tmpQueue.add(new GoCommand(mycontroller));
                while (i<db) {
                    if (!inFunc) tmpQueue.add(new GoCommand(mycontroller));
                    i++;
                }
        }
        return new GoCommand(mycontroller);
    }

    /**
     * gombnyomást reprezentáló csomópont bejárása
     * ha nem volt hiba, gombnyomást szimulál a controllerben
     * @param ctx
     * @return
     */
    @Override
    public Object visitPushIt(MyLanguageParser.PushItContext ctx) {

        if(!thereWasError){
            if (!inFunc) tmpQueue.add(new PushCommand(mycontroller));
        }
        return new PushCommand(mycontroller);
    }

    /**
     * objektum megevését reprezentálja
     * ha nem volt hiba
     * a kontrolerbe hív tovább
     * @param ctx
     * @return
     */
    @Override
    public Object visitEatIt(MyLanguageParser.EatItContext ctx) {

        if(!thereWasError){
            if (!inFunc) tmpQueue.add(new EatCommand(mycontroller));
        }
        return new EatCommand(mycontroller);
    }

    /**
     * robot színének visszaadását reprezentálja
     * ha nem volt hiba
     * visszaadja a szín stringesített, kisbetűs változatát
     * @param ctx
     * @return
     */
    @Override
    public Object visitGetColor(MyLanguageParser.GetColorContext ctx) {
        if(!thereWasError){
            return mycontroller.getRobotColor().toString().toLowerCase();
        }
        return null;
    }

    /**
     * balra fordulásért felelős parancsot dolgozza fel
     * ha nem volt hiba
     * a feltételben megadott számszor futtatja le
     * hibás input esetén jelez
     * @param ctx
     * @return
     */
    @Override
    public Object visitTurnLeft(MyLanguageParser.TurnLeftContext ctx) {

        if(!thereWasError) {

                int db = Integer.parseInt(ctx.getChild(2).getText());
                for (int i = 0; i < db; i++) {
                    if (!inFunc) tmpQueue.add(new TurnLeftCommand(mycontroller));
                }

        }

        return new TurnLeftCommand(mycontroller);
    }

    /**
     * jobbra fordulásért felelős parancsot dolgozza fel
     * ha nem volt hiba
     * a feltételben megadott számszor futtatja le
     * hibás input esetén jelez
     * @param ctx
     * @return
     */
    @Override
    public Object visitTurnRight(MyLanguageParser.TurnRightContext ctx) {

        if(!thereWasError){

                int db = Integer.parseInt(ctx.getChild(2).getText());
                for(int i=0; i<db;i++){
                     if (!inFunc) tmpQueue.add(new TurnRightCommand(mycontroller));
                }

        }

        return new TurnRightCommand(mycontroller);
    }

    /**
     * kézi színmegadást ellenőrző csomópont
     * jelenleg csak két színt tud kezelni
     * @param ctx
     * @return
     */
    @Override
    public Object visitColor(MyLanguageParser.ColorContext ctx) {

        if(!thereWasError){
            //TODO értelmesen a színekhez igazítani!!!!!
            if(ctx.YELLOW()!=null) return "yellow";
            else if(ctx.PURPLE()!=null) return "purple";
            else return null;
        }
        return null;
    }

    @Override
    public Object visitFunction_def(MyLanguageParser.Function_defContext ctx){

        inFunc = true;

        String name = ctx.getChild(1).getText();
        functions.put(name, new ArrayList<>());
        for(int i=0; i< ctx.getChild(5).getChildCount(); i++){
            Command tmp = (Command) visit(ctx.getChild(5).getChild(i).getChild(0));
            functions.get(name).add(tmp);
        }

        inFunc = false;

        return null;
    }

    @Override
    public Object visitFunction_call(MyLanguageParser.Function_callContext ctx){

        String name = ctx.getChild(0).getText();

        List<Command> commands = functions.get(name);

        int howmany = Integer.parseInt(ctx.getChild(2).getText());

        for(int i=0;i < howmany;i++){
            for (Command command: commands) {
                tmpQueue.add(command);
            }
        }

        return null;
    }

    /**
     * hibajelzésért felelős csomópont
     * @param errorNode
     * @return
     */
    @Override
    public Object visitErrorNode(ErrorNode errorNode) {
        //mycontroller.erroring();
        //TODO hibakezelés hol és mit?
        return null;
    }

}
