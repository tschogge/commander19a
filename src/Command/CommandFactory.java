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
                break;
            case "cls":
                command = new ClsCommand();
                break;
            case "ver":
                command = new VerCommand();
                break;
            case "color":
                command = new ColorCommand();
                break;
            case "dir":
                command = new DirCommand();
                break;
            case "type":
                command = new TypeCommand();
                break;
            case "cd":
                command = new CdCommand();
                break;
            default:
                return command;
        }
        command.setOutputWriter(outputWriter);
        return command;
    }
}
