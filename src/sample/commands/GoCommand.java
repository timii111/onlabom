package sample.commands;

import sample.WrongStepError;
import sample.controllers.BoardController;

/**
 * a robot lépését becsomagoló parancs osztály
 */
public class GoCommand implements Command {

    private BoardController ctrl;

    public GoCommand(BoardController ctrl){
        this.ctrl = ctrl;
    }

    public void doIt() throws WrongStepError {
        ctrl.go();
    }

    public void undoIt() throws WrongStepError {
        ctrl.goBack();
    }

}
