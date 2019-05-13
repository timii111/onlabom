package sample.commands;

import sample.controllers.BoardController;

public class TurnLeftCommand implements Command{

    private BoardController ctrl;

    public TurnLeftCommand(BoardController ctrl){
        this.ctrl = ctrl;
    }

    public boolean doIt(){
        ctrl.turnLeft();
        return true;
    }

    public boolean undoIt(){
        ctrl.turnRight();
        return true;
    }
}
