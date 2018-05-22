package sample;


import org.antlr.v4.runtime.tree.ErrorNode;
import sample.sample.nyelvBaseVisitor;
import sample.sample.nyelvParser;

import java.util.ArrayList;
import java.util.List;

public class myVisitor extends nyelvBaseVisitor<Object> {

    private Controller mycontroller;
    private List<Boolean> ifs = new ArrayList<Boolean>();
    private int countonif;

    public myVisitor(Controller ctrl){

        mycontroller = ctrl;
        countonif = -1;
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

    @Override
    public Object visitElseStatement(nyelvParser.ElseStatementContext ctx) {
        if(countonif > -1 && ifs.get(countonif)){
            visitChildren(ctx);
        }
        return null;
    }

    @Override
    public Object visitCycle(nyelvParser.CycleContext ctx) {
        try{
            String tmp = ctx.getChild(ctx.getChildCount()-2).toString();
            int db = Integer.parseInt(tmp);
            for(int i=0; i<db;i++){
                visitChildren(ctx);
            }
        }catch (NumberFormatException e){
            mycontroller.invalidInputSignaling();
        }

        return null;
    }

    @Override
    public Object visitEquality(nyelvParser.EqualityContext ctx) {

        Object o1 = visit(ctx.getChild(0));
        Object o2 = visit(ctx.getChild(2));

        return o1.equals(o2);
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
            int i=0;
            while (i<db && mycontroller.go()) i++;

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
        return mycontroller.getRobotColor().toString().toLowerCase();
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

        //TODO értelmesen a színekhez igazítani
        if(ctx.YELLOW()!=null) return "yellow";
        else return null;
    }

    @Override
    public Object visitErrorNode(ErrorNode errorNode) {
        //TODO ?
        mycontroller.erroring();
        return null;
    }
}
