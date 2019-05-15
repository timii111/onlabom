package sample.antlrelements;

import sample.antlrelements.languageelements.MyLanguageBaseVisitor;
import sample.antlrelements.languageelements.MyLanguageParser;

import java.util.ArrayList;
import java.util.List;

/**
 * a játékot irányító nyelv hibakezeléséért felelős visitor
 */
public class MyErrorVisitor extends MyLanguageBaseVisitor<Object> {

    /** függvények nevét tároló lista */
    private List<String> functions;
    /** hibajelző flag */
    private boolean thereWasError = false;
    /** alap függvények nevét tároló lista */
    private List<String> baseFunctions;

    /**
     *konstruktor, inicializálja a listákat
     * hozzáaddja az alap függvények nevét
     */
    public MyErrorVisitor() {

        functions = new ArrayList<>();
        baseFunctions = new ArrayList<>();
        baseFunctions.add("goThere");
        baseFunctions.add("pushIt");
        baseFunctions.add("eatIt");
        baseFunctions.add("getColor");
        baseFunctions.add("turnLeft");
        baseFunctions.add("turnRight");
    }

    /**
     * a program gyökerétől kezdve bejárja a fát
     * visszaadja, hogy volt-e hiba a program futása során
     */
    @Override
    public Object visitProgram(MyLanguageParser.ProgramContext ctx) {

        functions.clear();

        visitChildren(ctx);
        return thereWasError;

    }

    /**
     * függvénydefiniálást ellenőrző függvény
     * bejárja a gyerekeit, majd hozzáadja a nevét a használható függvények listájához
     * ezzel kikerülhető a rekurzív függvény esete
     */
    @Override
    public Object visitFunction_def(MyLanguageParser.Function_defContext ctx) {

        String name = ctx.getChild(1).getText();

        visitChildren(ctx);

        functions.add(name);
        return null;
    }

    /**
     * függvényhívást ellenőrző metódus
     * ha a hívott függvény még nem volt korábban fediniálva, hibát jelez
     */
    @Override
    public Object visitFunction_call(MyLanguageParser.Function_callContext ctx) {

        String name = ctx.getChild(0).getText();

        if(!(functions.contains(name) || baseFunctions.contains(name))) thereWasError = true;

        return null;
    }

}
