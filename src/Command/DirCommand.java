package Command;

import java.io.File;

public class DirCommand extends Command {
    public void DirCommand() {

    }

    public static int requiredArguments = 0;

    @Override
    public void execute() {
        File folder = new File(Command.currentPath);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
    }
    @Override
    public int getRequiredArguments() {
        return requiredArguments;
    }
}
