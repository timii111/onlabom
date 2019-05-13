package sample.commands;

import sample.controllers.BoardController;
import sample.enums.ColorType;

public class EatCommand implements Command{

    private BoardController ctrl;
    private ColorType keyColor;

    public EatCommand(BoardController ctrl){
        this.ctrl = ctrl;
    }

    public boolean doIt(){
        keyColor = ctrl.eatObject();

        return true;
    }

    public boolean undoIt(){
        ctrl.addEatingObject(keyColor);
        return true;
    }
}
