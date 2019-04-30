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

    public void doIt(){
        prev = ctrl.getRobotColor();
        next = ctrl.pushTile();
    }

    public void undoIt(){
        ctrl.unPushTile(prev);
    }
}
