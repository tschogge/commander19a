package Command;

import Console.ConsoleOutputWriter;
import Console.OutputWriter;

public class CommandFactory {

    public static Command createCommand(String commandName) {
        Command command = null;
        OutputWriter outputWriter = new ConsoleOutputWriter();
        switch (commandName) {
            case "exit":
                command = new ExitCommand();
                command.setOutputWriter(outputWriter);
                break;
            case "cls":
                command = new ClsCommand();
                command.setOutputWriter(outputWriter);
                break;
            case "ver":
                command = new VerCommand();
                command.setOutputWriter(outputWriter);
                break;
            case "color":
                command = new ColorCommand();
                command.setOutputWriter(outputWriter);
                break;
            case "dir":
                command = new DirCommand();
                command.setOutputWriter(outputWriter);
                break;
            case "type":
                command = new TypeCommand();
                command.setOutputWriter(outputWriter);
                break;
            case "mkdir":
                command = new MkdirCommand();
                command.setOutputWriter(outputWriter);
                break;
        }
        return command;
    }
}
