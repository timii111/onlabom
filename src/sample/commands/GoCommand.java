package sample.commands;

import sample.antlrelements.WrongStepError;
import sample.controllers.BoardController;

public class GoCommand implements Command {

    private BoardController ctrl;

    public GoCommand(BoardController ctrl){
        this.ctrl = ctrl;
    }

    public boolean doIt() throws WrongStepError {
        return ctrl.go();
    }

    public boolean undoIt() throws WrongStepError {
        return ctrl.goBack();
    }

}
