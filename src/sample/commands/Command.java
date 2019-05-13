package sample.commands;

import sample.WrongStepError;

/**
 * parancs interfész, a robot által végzett utasítások objektummá alakításához
 */
public interface Command {
    /**
     * utasítás végrehajtása
     * @throws WrongStepError rossz lépés kezelésére szolgál
     */
    void doIt() throws WrongStepError;

    /**
     * utasítás visszaállítása
     * @throws WrongStepError rossz lépés kezelésére szolgál
     */
    void undoIt() throws WrongStepError;
}
