package sample.commands;

import sample.controllers.BoardController;

/**
 * balra fordulást becsomagoló objektum
 */
public class TurnLeftCommand implements Command{

    private BoardController ctrl;

    public TurnLeftCommand(BoardController ctrl){
        this.ctrl = ctrl;
    }

    public void doIt(){
        ctrl.turnLeft();
    }

    public void undoIt(){
        ctrl.turnRight();
    }
}
