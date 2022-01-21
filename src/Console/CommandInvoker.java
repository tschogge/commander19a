package Console;

import Command.Command;
import Command.CommandFactory;
import Parser.Parser;

import java.util.ArrayList;

public class CommandInvoker {

    private Command command;
    private Parser parser;
    private boolean canExecute;

    public CommandInvoker(String userInput) {
        parser = new Parser();
        // validate
        if (!parser.commandFound(userInput)) {
            System.out.println("This Command doesn't exist!");
            canExecute = false;
            return;
        }
        command = CommandFactory.createCommand(parser.commandOnly(userInput));
        if (!parser.enoughArguments(userInput)) {
            System.out.println("This Command requires at least " + command.getRequiredArguments() + " Parameters.");
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
        // call output writer if not validatet correctly (parser)

        // is ok
        command.execute();
    }
}
