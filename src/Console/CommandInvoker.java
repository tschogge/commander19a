package Console;

import Command.Command;
import Command.CommandFactory;
import Parser.Parser;

import java.util.ArrayList;

public class CommandInvoker {

    private Command command;
    private Parser parser;


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
