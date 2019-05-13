package sample.commands;

import sample.controllers.BoardController;
import sample.enums.ColorType;

import java.util.*;

public class IfCommand implements Command{

    private BoardController ctrl;

    private ColorType color;

    private IfCommands commands;

    private Stack<Command> toDos;

    public IfCommand(BoardController ctrl, String color, Stack<Command> toDos){
        this.ctrl = ctrl;
        this.color = ColorType.valueOf(color);
        commands = new IfCommands();
        this.toDos = toDos;
    }

    public void addTrueCommand(Command c){
        commands.addTrueCommand(c);
    }

    public void addFalseCommand(Command c){
        commands.addFalseCommand(c);
    }

    @Override
    public boolean doIt() {
        if(color == ctrl.getRobotColor()){

            for (Command c: commands.getTrueCommands()) {
                toDos.push(c);
            }
        } else {
            for (Command c: commands.getFalseCommands()) {
                toDos.push(c);
            }
        }
        return false;
        //TODO
    }

    @Override
    public boolean undoIt() {
        return false;
        //TODO
    }

    public class IfCommands{
        Stack<Command> trueBranch;

        Stack<Command> falseBranch;

        public IfCommands(){
            trueBranch = new Stack<>();
            falseBranch = new Stack<>();
        }

        public void addTrueCommand(Command c){
            trueBranch.push(c);
        }

        public void addFalseCommand(Command c){
            falseBranch.push(c);
        }

        public List<Command> getTrueCommands(){
            Collections.reverse(trueBranch);
            return trueBranch;
        }

        public List<Command> getFalseCommands(){
            Collections.reverse(falseBranch);
            return falseBranch;
        }
    }
}


