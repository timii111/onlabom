package sample.commands;

import sample.controllers.BoardController;

public class GoCommand implements Command{

    private BoardController ctrl;

    public GoCommand(BoardController ctrl){
        this.ctrl = ctrl;
    }

    public void doIt(){
        ctrl.go();
    }

    public void undoIt(){
        ctrl.goBack();
    }

}
