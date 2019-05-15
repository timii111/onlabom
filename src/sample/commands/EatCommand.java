package sample.commands;

import sample.controllers.BoardController;
import sample.enums.ColorType;

/**
 * a pályán lévő objektum megevését becsomagoló parancs osztály
 */
public class EatCommand implements Command{

    private BoardController ctrl;
    /** a megevett objektum színe */
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
