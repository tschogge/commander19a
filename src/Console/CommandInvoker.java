package Console;

import Command.Command;
import Command.CommandFactory;
import Parser.Parser;

public class CommandInvoker {

    private Command command;
    private Parser parser;

    public CommandInvoker(String userInput) {
        parser = new Parser();
        command = CommandFactory.createCommand(parser.commandOnly(userInput));


    }
    public void executeCommand() {

    }
}
