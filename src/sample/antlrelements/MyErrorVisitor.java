package sample.antlrelements;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import org.antlr.v4.runtime.tree.ErrorNode;
import sample.antlrelements.languageelements.MyLanguageBaseVisitor;
import sample.antlrelements.languageelements.MyLanguageParser;
import sample.commands.*;
import sample.controllers.BoardController;

import java.util.*;

/**
 * saját visitor osztály, a generált MyLanguageBaseVisitorból származtatva
 * a felülírt emtódusok segítségével végigjárhatom a generált fát
 */
public class MyErrorVisitor extends MyLanguageBaseVisitor<Object> {

    private List<String> functions;

    private boolean thereWasError = false;

    private List<String> baseFunctions;

    /**
     * konstruktor
     * beállítja a kontroller példányt
     * -1 re inicializálja az ifek számát, hogy tudjuk követni a listát
     *
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

        functions.clear();

        visitChildren(ctx);
        return thereWasError;

    }


    @Override
    public Object visitFunction_def(MyLanguageParser.Function_defContext ctx) {

        String name = ctx.getChild(1).getText();

        visitChildren(ctx);

        functions.add(name);
        return null;
    }

    @Override
    public Object visitFunction_call(MyLanguageParser.Function_callContext ctx) {

        String name = ctx.getChild(0).getText();

        if(!(functions.contains(name) || baseFunctions.contains(name))) thereWasError = true;

        return null;
    }

}
