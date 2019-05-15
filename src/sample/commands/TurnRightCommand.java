package sample.commands;

import sample.controllers.BoardController;

/**
 * jobbra fordulást becsomagoló parancs objektum
 */
public class TurnRightCommand implements Command{

    private BoardController ctrl;

    public TurnRightCommand(BoardController ctrl){
        this.ctrl = ctrl;
    }

    public void doIt(){
        ctrl.turnRight();
    }

    public void undoIt(){
        ctrl.turnLeft();
    }
}
