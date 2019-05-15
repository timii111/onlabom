package sample.commands;

import sample.controllers.BoardController;
import sample.enums.ColorType;

/**
 * a gomb megnyomását becsomagoló parancs osztály
 */
public class PushCommand implements Command{

    private BoardController ctrl;
    /** a robot eddigi színe */
    private ColorType prev;
    /** a robot következő színe */
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
