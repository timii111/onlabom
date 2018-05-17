package sample;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import sample.sample.nyelvBaseVisitor;
import sample.sample.nyelvParser;

public class myVisitor extends nyelvBaseVisitor<Object> {




    private Controller mycontroller;

    public myVisitor(Controller ctrl){

        mycontroller = ctrl;
    }

    @Override
    public Object visitProgram(nyelvParser.ProgramContext ctx) {

        visitChildren(ctx);
        return null;
    }

    @Override
    public Object visitCommandlines(nyelvParser.CommandlinesContext ctx) {
        return null;
    }

    @Override
    public Object visitStructure(nyelvParser.StructureContext ctx) {
        return null;
    }

    @Override
    public Object visitBranch(nyelvParser.BranchContext ctx) {
        return null;
    }

    @Override
    public Object visitElseStatement(nyelvParser.ElseStatementContext ctx) {
        return null;
    }

    @Override
    public Object visitCycle(nyelvParser.CycleContext ctx) {
        return null;
    }

    @Override
    public Object visitEquality(nyelvParser.EqualityContext ctx) {
        return null;
    }

    @Override
    public Object visitCommand(nyelvParser.CommandContext ctx) {
        return null;
    }

    @Override
    public Object visitGoThere(nyelvParser.GoThereContext ctx) {

        mycontroller.goDown();
        return null;
    }

    @Override
    public Object visitPushIt(nyelvParser.PushItContext ctx) {
        return null;
    }

    @Override
    public Object visitEatIt(nyelvParser.EatItContext ctx) {
        return null;
    }

    @Override
    public Object visitGetColor(nyelvParser.GetColorContext ctx) {
        return null;
    }

    @Override
    public Object visitTurnLeft(nyelvParser.TurnLeftContext ctx) {
        return null;
    }

    @Override
    public Object visitTurnRight(nyelvParser.TurnRightContext ctx) {
        return null;
    }

    @Override
    public Object visitColor(nyelvParser.ColorContext ctx) {
        return null;
    }

    @Override
    public Object visit(ParseTree parseTree) {
        return null;
    }

    @Override
    public Object visitChildren(RuleNode ruleNode) {
        return null;
    }

    @Override
    public Object visitTerminal(TerminalNode terminalNode) {
        return null;
    }

    @Override
    public Object visitErrorNode(ErrorNode errorNode) {
        return null;
    }
}
