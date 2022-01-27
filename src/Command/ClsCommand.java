package Command;

public class ClsCommand extends Command{

    public static int requiredArguments = 0;

    public ClsCommand() {

    }

    @Override
    public void execute() {
        String outputString = "";
        for (int i = 0; i < 25; i++) {
            outputString+= "\r\n";
        }
        System.out.println(outputString);
    }
    @Override
    public int getRequiredArguments() {
        return requiredArguments;
    }
}
