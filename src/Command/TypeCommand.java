package Command;

import Console.Console;
import Filesystem.Directory;
import Filesystem.File;
import Filesystem.FilesystemItem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TypeCommand extends Command {

    public static int requiredArguments = 1;
    private Console console;
    public TypeCommand() {
        console = Command.console;
    }
    @Override
    public void execute() {
        String output = "";
        File file = null;
        for (FilesystemItem filesystemItem: console.getCurrentDrive().getCurrentDirectory().getFilesystemItems()) {
            if (filesystemItem instanceof File && filesystemItem.getName().equals(parameters.get(0))) {
                file = (File) filesystemItem;
            }

        }
        if (file == null) {
            outputWriter.println("The File \"" + currentPath  + parameters.get(0) + "\" doesn't exist!");
            return;
        }
        outputWriter.println(file.getContent());
        outputWriter.println(output);
    }
    @Override
    public int getRequiredArguments() {
        return requiredArguments;
    }
}
