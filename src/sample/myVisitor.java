package sample;


import org.antlr.v4.runtime.tree.ErrorNode;
import sample.antlrelements.MyLanguageBaseVisitor;
import sample.antlrelements.MyLanguageParser;

import java.util.ArrayList;
import java.util.List;

public class myVisitor extends MyLanguageBaseVisitor<Object> {

    private Controller mycontroller;
    private List<Boolean> ifs = new ArrayList<Boolean>();
    private int countonif;

    private boolean thereWasError = false;

    public myVisitor(Controller ctrl){

        mycontroller = ctrl;
        countonif = -1;
    }

    @Override
    public Object visitProgram(MyLanguageParser.ProgramContext ctx) {

        visitChildren(ctx);
        mycontroller.ended();
        thereWasError = false;
        return null;
    }

    @Override
    public Object visitCommandlines(MyLanguageParser.CommandlinesContext ctx) {

        if(!thereWasError) visitChildren(ctx);
        return null;
    }

    @Override
    public Object visitStructure(MyLanguageParser.StructureContext ctx) {

        if(!thereWasError) visitChildren(ctx);
        return null;
    }

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

    @Override
    public Object visitElseStatement(MyLanguageParser.ElseStatementContext ctx) {
        if(!thereWasError){
            if(countonif > -1 && ifs.get(countonif)){
                visitChildren(ctx);
            }
        }

        return null;
    }

    @Override
    public Object visitCycle(MyLanguageParser.CycleContext ctx) {
        if(!thereWasError){
            try{
                String tmp = ctx.getChild(ctx.getChildCount()-2).toString();
                int db = Integer.parseInt(tmp);
                for(int i=0; i<db;i++){
                    visitChildren(ctx);
                }
            }catch (NumberFormatException e){
                mycontroller.invalidInputSignaling();
            }
        }

        return null;
    }

    @Override
    public Object visitEquality(MyLanguageParser.EqualityContext ctx) {

        if(!thereWasError){
            Object o1 = visit(ctx.getChild(0));
            Object o2 = visit(ctx.getChild(2));

            return o1.equals(o2);
        }
        return  null;
    }

    @Override
    public Object visitCommand(MyLanguageParser.CommandContext ctx) {
        if(!thereWasError){
            visitChildren(ctx);
        }

        return null;
    }

    @Override
    public Object visitGoThere(MyLanguageParser.GoThereContext ctx) {

        if(!thereWasError){
            String tmp = ctx.getChild(2).getText();
            try{
                int db = Integer.parseInt(ctx.getChild(2).getText());
                int i=1;
                boolean b = mycontroller.go();
                while (i<db && b) {
                    b = mycontroller.go(); //false esetén hiba van!
                    i++;
                }
                if(!b) thereWasError = true;

            }catch(NumberFormatException e){
                mycontroller.invalidInputSignaling();
            }
        }



        return null;
    }

    @Override
    public Object visitPushIt(MyLanguageParser.PushItContext ctx) {

        if(!thereWasError){
            mycontroller.pushTile();
        }
        return null;
    }

    @Override
    public Object visitEatIt(MyLanguageParser.EatItContext ctx) {

        if(!thereWasError){
            mycontroller.eatObject();
        }

        return null;
    }

    @Override
    public Object visitGetColor(MyLanguageParser.GetColorContext ctx) {
        if(!thereWasError){
            return mycontroller.getRobotColor().toString().toLowerCase();
        }
        return null;
    }

    @Override
    public Object visitTurnLeft(MyLanguageParser.TurnLeftContext ctx) {

        if(!thereWasError){
            String tmp = ctx.getChild(2).getText();
            try{
                int db = Integer.parseInt(ctx.getChild(2).getText());
                for(int i=0; i<db;i++){
                    mycontroller.turnLeft();
                }
            }catch(NumberFormatException e){
                mycontroller.invalidInputSignaling();
            }
        }



        return null;
    }

    @Override
    public Object visitTurnRight(MyLanguageParser.TurnRightContext ctx) {

        if(!thereWasError){
            String tmp = ctx.getChild(2).getText();
            try{
                int db = Integer.parseInt(ctx.getChild(2).getText());
                for(int i=0; i<db;i++){
                    mycontroller.turnRight();
                }
            }catch(NumberFormatException e){
                mycontroller.invalidInputSignaling();
            }
        }

        return null;
    }



    @Override
    public Object visitColor(MyLanguageParser.ColorContext ctx) {

        if(!thereWasError){
            //TODO értelmesen a színekhez igazítani
            if(ctx.YELLOW()!=null) return "yellow";
            else if(ctx.PURPLE()!=null) return "purple";
            else return null;
        }
        return null;
    }

    @Override
    public Object visitErrorNode(ErrorNode errorNode) {
        //TODO ?
        mycontroller.erroring();
        return null;
    }

}
