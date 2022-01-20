package Command;

public class CommandFactory {

    public static Command createCommand(String commandName) {
        Command command = null;
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
            case "set color":
                command = new SetColorCommand();
                break;
            case "dir":
                command = new DirCommand();
                break;
            case "type": new TypeCommand();
        }

        return command;
    }
}
