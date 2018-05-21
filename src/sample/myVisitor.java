package sample;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
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
        mycontroller.ended();
        return null;
    }

    @Override
    public Object visitCommandlines(nyelvParser.CommandlinesContext ctx) {

        visitChildren(ctx);
        return null;
    }

    @Override
    public Object visitStructure(nyelvParser.StructureContext ctx) {

        visitChildren(ctx);
        return null;
    }

    @Override
    public Object visitBranch(nyelvParser.BranchContext ctx) {

        visitChildren(ctx);
        return null;
    }

    @Override
    public Object visitElseStatement(nyelvParser.ElseStatementContext ctx) {

        visitChildren(ctx);
        return null;
    }

    @Override
    public Object visitCycle(nyelvParser.CycleContext ctx) {

        visitChildren(ctx);
        return null;
    }

    @Override
    public Object visitEquality(nyelvParser.EqualityContext ctx) {

        visitChildren(ctx);
        return null;
    }

    @Override
    public Object visitCommand(nyelvParser.CommandContext ctx) {

        visitChildren(ctx);
        return null;
    }

    @Override
    public Object visitGoThere(nyelvParser.GoThereContext ctx) {

        String tmp = ctx.getChild(2).getText();
        try{
            int db = Integer.parseInt(ctx.getChild(2).getText());
            for(int i=0; i<db;i++){
                mycontroller.go();
            }
        }catch(NumberFormatException e){
            mycontroller.invalidInputSignaling();
        }


        return null;
    }

    @Override
    public Object visitPushIt(nyelvParser.PushItContext ctx) {
        mycontroller.pushTile();
        return null;
    }

    @Override
    public Object visitEatIt(nyelvParser.EatItContext ctx) {
        mycontroller.eatObject();
        return null;
    }

    @Override
    public Object visitGetColor(nyelvParser.GetColorContext ctx) {
        return mycontroller.getRobotColor();
    }

    @Override
    public Object visitTurnLeft(nyelvParser.TurnLeftContext ctx) {

        String tmp = ctx.getChild(2).getText();
        try{
            int db = Integer.parseInt(ctx.getChild(2).getText());
            for(int i=0; i<db;i++){
                mycontroller.turnLeft();
            }
        }catch(NumberFormatException e){
            mycontroller.invalidInputSignaling();
        }

        return null;
    }

    @Override
    public Object visitTurnRight(nyelvParser.TurnRightContext ctx) {

        String tmp = ctx.getChild(2).getText();
        try{
            int db = Integer.parseInt(ctx.getChild(2).getText());
            for(int i=0; i<db;i++){
                mycontroller.turnRight();
            }
        }catch(NumberFormatException e){
            mycontroller.invalidInputSignaling();
        }

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
    public Object visitTerminal(TerminalNode terminalNode) {

        return null;
    }

    @Override
    public Object visitErrorNode(ErrorNode errorNode) {

        return null;
    }
}
