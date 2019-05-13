package sample.commands;

import sample.controllers.BoardController;

public class TurnRightCommand implements Command{

    private BoardController ctrl;

    public TurnRightCommand(BoardController ctrl){
        this.ctrl = ctrl;
    }

    public boolean doIt(){
        ctrl.turnRight();
        return true;
    }

    public boolean undoIt(){
        ctrl.turnLeft();
        return true;
    }
}
