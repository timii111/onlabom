package sample.commands;

import sample.controllers.BoardController;
import sample.enums.ColorType;

public class PushCommand implements Command{

    private BoardController ctrl;
    private ColorType prev;
    private ColorType next;

    public PushCommand(BoardController ctrl){
        this.ctrl = ctrl;
    }

    public boolean doIt(){
        prev = ctrl.getRobotColor();
        next = ctrl.pushTile();
        return true;
    }

    public boolean undoIt(){
        ctrl.unPushTile(prev);
        return true;
    }
}
