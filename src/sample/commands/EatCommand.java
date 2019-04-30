package sample.commands;

import sample.controllers.BoardController;
import sample.enums.ColorType;

public class EatCommand implements Command{

    private BoardController ctrl;
    private ColorType keyColor;

    public EatCommand(BoardController ctrl){
        this.ctrl = ctrl;
    }

    public void doIt(){
        keyColor = ctrl.eatObject();
    }

    public void undoIt(){
        ctrl.addEatingObject(keyColor);
    }
}
