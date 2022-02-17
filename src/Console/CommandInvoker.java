package Console;

import Command.Command;
import Command.CommandFactory;
import Parser.Parser;

import java.util.ArrayList;

public class CommandInvoker {

    private Command command;
    private Parser parser;
    private boolean canExecute;
    private OutputWriter outputWriter;
    // manipulate this variable in the exit command class
    public boolean again = true;

    public CommandInvoker(String userInput) {
        outputWriter = new ConsoleOutputWriter();
        parser = new Parser();
        // validate
        if (!parser.commandFound(userInput)) {
            outputWriter.println("This Command doesn't exist!");
            canExecute = false;
            return;
        }
        command = CommandFactory.createCommand(parser.commandOnly(userInput));
        if (!parser.enoughArguments(userInput)) {
            outputWriter.println("This Command requires at least " + command.getRequiredArguments() + " Parameters.");
            canExecute = false;
            return;
        }

        canExecute = true;
        // is ok
        command.setParameters(parser.parseParameter(userInput));

    }

    public void executeCommand() {
        if (!canExecute) {
            return;
        }


        // is ok
        command.execute();
    }
}
