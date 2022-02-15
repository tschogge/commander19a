package Command;

import Console.Console;
import Console.OutputWriter;
import Filesystem.Filesystem;
import Filesystem.Directory;
import Filesystem.Drive;
import java.util.ArrayList;

public abstract class Command {
    protected ArrayList<String> parameters;
    protected OutputWriter outputWriter;
    public static String currentPath;
    public static Console console;

    public Command() {}
    public void execute() {

    }

    public ArrayList<String> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<String> parameters) {
        this.parameters = parameters;
    }

    public OutputWriter getOutputWriter() {
        return outputWriter;
    }

    public void setOutputWriter(OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
    }

    public static String getCurrentPath() {
        return currentPath;
    }

    public static void setCurrentPath(String currentPath) {
        Command.currentPath = currentPath;
    }

    public int getRequiredArguments() {
       return -1;
    }

}
