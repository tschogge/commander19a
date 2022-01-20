package Console;

import Command.Command;
import Command.CommandFactory;
import Parser.Parser;

public class CommandInvoker {

    private Command command;
    private Parser parser;
    // manipulate this variable in the exit command class

    public boolean again = true;

    public CommandInvoker(String userInput) {
        parser = new Parser();
        // validate

        // is ok
        command = CommandFactory.createCommand(parser.commandOnly(userInput));
        command.setParameters(parser.parseParameter(userInput));


    }
    public void executeCommand() {
        // call output writer if not validatet correctly (parser)

    }
}
