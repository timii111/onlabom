package sample.commands;

import sample.antlrelements.WrongStepError;

public interface Command {

    boolean doIt() throws WrongStepError;

    boolean undoIt() throws WrongStepError;
}
