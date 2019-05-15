package sample.commands;

import sample.controllers.BoardController;
import sample.enums.ColorType;

import java.util.*;

/**
 * az if utasítást becsomagoló parancs objektum
 */
public class IfCommand implements Command{

    private BoardController ctrl;
    /** összehasonlításban használt szín */
    private ColorType color;
    /** az if utasítás parancsai */
    private IfCommands commands;
    /** átadott todos referencia, hogy a feldolgozási sorba kerülhessenek a parancsok */
    private Stack<Command> toDos;

    public IfCommand(BoardController ctrl, String color, Stack<Command> toDos){
        this.ctrl = ctrl;
        this.color = ColorType.valueOf(color);
        commands = new IfCommands();
        this.toDos = toDos;
    }

    public void addTrueCommand(Command c){
        commands.addTrueCommand(c);
    }

    public void addFalseCommand(Command c){
        commands.addFalseCommand(c);
    }

    /**
     * kiértékeli az if utasítást az aktuális állapotnak megfelelően
     * a megfelelő utasításokat elhelyezi a tennivalók listájában
     */
    @Override
    public void doIt() {
        if(color == ctrl.getRobotColor()){

            for (Command c: commands.getTrueCommands()) {
                toDos.push(c);
            }
        } else {
            for (Command c: commands.getFalseCommands()) {
                toDos.push(c);
            }
        }
    }

    @Override
    public void undoIt() {

    }

    /**
     * elágazás utasításait tároló osztály.
     * a későbbi felhasználhatóság érdekében tárolja az igaz és hamis ág utasításait is
     */
    public class IfCommands{
        /** igaz ág utasításai */
        Stack<Command> trueBranch;
        /** hamis ág utasításai */
        Stack<Command> falseBranch;

        public IfCommands(){
            trueBranch = new Stack<>();
            falseBranch = new Stack<>();
        }

        /**
         * parancs hozzáadása az igaz ághoz
         * @param c a hozzáadott parancs
         */
        public void addTrueCommand(Command c){
            trueBranch.push(c);
        }

        /**
         * parancs hozzáadása a hamis ághoz
         * @param c a hozzáadott parancs
         */
        public void addFalseCommand(Command c){
            falseBranch.push(c);
        }

        /**
         * visszaadja az igaz ág utasításait. előtte megfordítja a listát, hogy helyes sorrendben kerüljenek feldolgozásra
         * @return a visszaadott parancslista
         */
        public List<Command> getTrueCommands(){
            Collections.reverse(trueBranch);
            return trueBranch;
        }

        /**
         * visszaadja a hamis ág utasításait. előtte megfordítja a listát, hogy helyes sorrendben kerüljenek feldolgozásra
         * @return a visszaadott parancslista
         */
        public List<Command> getFalseCommands(){
            Collections.reverse(falseBranch);
            return falseBranch;
        }
    }
}


