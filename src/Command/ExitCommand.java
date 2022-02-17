package Command;

public class ExitCommand extends Command {
    public void Exit() {

    }

    public static int requiredArguments = 0;
    // manipulate this variable in the exit command class
    public static boolean again = true;

    @Override
    public void execute() {
        again = false;
    }

    @Override
    public int getRequiredArguments() {
        return requiredArguments;
    }
}
