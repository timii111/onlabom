package sample;

import org.antlr.v4.runtime.tree.ErrorNode;
import sample.antlrelements.MyLanguageBaseVisitor;
import sample.antlrelements.MyLanguageParser;
import sample.controllers.GameSceneController;

import java.util.ArrayList;
import java.util.List;
/**
 * saját visitor osztály, a generált MyLanguageBaseVisitorból származtatva
 * a felülírt emtódusok segítségével végigjárhatom a generált fát
 */
public class ErroringVisitor extends MyLanguageBaseVisitor<Object> {

    /** saját controller példány */
    private GameSceneController mycontroller;
    /**
     * az egymásba ágyazott ifek és random else ágak kezelésére szolgál
     */
    private List<Boolean> ifs = new ArrayList<Boolean>();
    /** ifek számát mutatja meg -1 */
    private int countonif;


    /**
     * konstruktor
     * beállítja a kontroller példányt
     * -1 re inicializálja az ifek számát, hogy tudjuk követni a listát
     * @param ctrl controller példány
     */
    public ErroringVisitor(GameSceneController ctrl){
        mycontroller = ctrl;
        countonif = -1;
    }

    /**
     * a program gyökerének bejárására szolgál
     * bejárja a gyerekit
     * meghívja a bejárás ereményét megmuattó controller fvt
     * visszaállítja  a hibajelző boolt
     * @param ctx
     * @return
     */
    @Override
    public Object visitProgram(MyLanguageParser.ProgramContext ctx) {
        visitChildren(ctx);
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
        visitChildren(ctx);
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
        visitChildren(ctx);
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
        if(countonif > -1 && ifs.get(countonif)){
            visitChildren(ctx);
        }
        //TODO hibát dobni ha nincs if az esle ághoz
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

        try{
            String tmp = ctx.getChild(ctx.getChildCount()-2).toString();
            int db = Integer.parseInt(tmp);

            visitChildren(ctx);
        }catch (NumberFormatException e){
           // mycontroller.invalidInputSignaling();
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

        visitChildren(ctx);

        return null;

    }

    /**
     * parancsot reprezentáló objektum bejárása, ha nem volt hiba
     * továbblép a gyerekekre
     * @param ctx
     * @return
     */
    @Override
    public Object visitCommand(MyLanguageParser.CommandContext ctx) {

        visitChildren(ctx);

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

        String tmp = ctx.getChild(2).getText();
        try{
            int db = Integer.parseInt(ctx.getChild(2).getText());


        }catch(NumberFormatException e){
            //mycontroller.invalidInputSignaling();
        }
        visitChildren(ctx);
        return null;
    }

    /**
     * gombnyomást reprezentáló csomópont bejárása
     * ha nem volt hiba, gombnyomást szimulál a controllerben
     * @param ctx
     * @return
     */
    @Override
    public Object visitPushIt(MyLanguageParser.PushItContext ctx) {

        visitChildren(ctx);
        return null;
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

        visitChildren(ctx);
        return null;
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
        visitChildren(ctx);
        //return mycontroller.getRobotColor().toString().toLowerCase();
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


        String tmp = ctx.getChild(2).getText();
        try{
            int db = Integer.parseInt(ctx.getChild(2).getText());
            //if(db<1) mycontroller.invalidInputSignaling();
        }catch(NumberFormatException e){
            //mycontroller.invalidInputSignaling();
        }
        visitChildren(ctx);
        return null;
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
        visitChildren(ctx);

        String tmp = ctx.getChild(2).getText();
        try{
            int db = Integer.parseInt(ctx.getChild(2).getText());
            //if(db<1) mycontroller.invalidInputSignaling();
        }catch(NumberFormatException e){
            //mycontroller.invalidInputSignaling();
        }

        return null;
    }

    /**
     * kézi színmegadást ellenőrző csomópont
     * jelenleg csak két színt tud kezelni
     * @param ctx
     * @return
     */
    @Override
    public Object visitColor(MyLanguageParser.ColorContext ctx) {
        visitChildren(ctx);
        //TODO értelmesen a színekhez igazítani
        if(ctx.YELLOW()!=null) return "yellow";
        else if(ctx.PURPLE()!=null) return "purple";
        else return null;

    }


    @Override
    public Object visitFunction_def(MyLanguageParser.Function_defContext ctx){

        visitChildren(ctx);
        return null;
        //TODO
    }

    @Override
    public Object visitFunction_call(MyLanguageParser.Function_callContext ctx){
        visitChildren(ctx);

        return null;
        //TODO
    }

    /**
     * hibajelzésért felelős csomópont
     * @param errorNode
     * @return
     */
    @Override
    public Object visitErrorNode(ErrorNode errorNode) {
        mycontroller.erroring();
        return null;
    }

}
