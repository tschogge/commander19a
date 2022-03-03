package Command;

import Console.Console;
import Filesystem.Directory;
import Filesystem.FilesystemItem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class CdCommand extends Command{
    public static int requiredArguments = 1;
    private Console console;

    public CdCommand() {
        console = Command.console;
    }

    @Override
    public void execute() {
        // Backup des currentDirectory
        Directory currentDirectoryBackup = console.getCurrentDrive().getCurrentDirectory();
        // Ein Directory Zurück
        if (parameters.get(0).equals("..")) {
            if (console.getCurrentDrive().getCurrentDirectory().getName().equals("\\")) {
                return;
            }
            String[] splittedPath = currentPath.split("\\\\");
            ArrayList<String> splittedPathSanitized = new ArrayList<>();
            for (String element : splittedPath) {
                if (!element.equals("")) {
                    splittedPathSanitized.add(element);
                }
            }
            splittedPathSanitized.remove(0);
            splittedPathSanitized.remove(splittedPathSanitized.size() - 1);
            console.getCurrentDrive().setCurrentDirectory(console.getCurrentDrive().getRootDirectory());
            Command.currentPath = console.getCurrentDrive().getLabel() + console.getCurrentDrive().getRootDirectory().getName();
            for (String element : splittedPathSanitized) {
                for (FilesystemItem filesystemItem : console.getCurrentDrive().getCurrentDirectory().getFilesystemItems()) {
                    if (element.equals(filesystemItem.getName().replace("\\", "")) && filesystemItem instanceof Directory) {
                        console.getCurrentDrive().setCurrentDirectory((Directory) filesystemItem);
                    }
                }
            }
            for (String element : splittedPathSanitized) {
                Command.currentPath += element + "\\";
            }
            return;
        }
        // absoluter Pfad
        String[] pathInChars = parameters.get(0).split("");
        if (pathInChars[0].equals("\\")) {
            if (pathInChars.length < 2) {
                writeError();
                return;
            }
            String pathBackup = currentPath;
            boolean found = false;
            currentPath = console.getCurrentDrive().getRootDirectory().getPath() + console.getCurrentDrive().getRootDirectory().getName();
            console.getCurrentDrive().setCurrentDirectory(console.getCurrentDrive().getRootDirectory());
            String[] splittedPath = parameters.get(0).replace("\\", "\\\\").split("\\\\");
            ArrayList<String> splittedPathSanitized = new ArrayList<>();
            for (String element : splittedPath) {
                if (!element.equals("")) {
                    splittedPathSanitized.add(element);
                }
            }
            for (String element : splittedPathSanitized) {
                found = false;
                for (FilesystemItem filesystemItem : console.getCurrentDrive().getCurrentDirectory().getFilesystemItems()) {
                    if (element.equals(filesystemItem.getName().replace("\\", "")) && filesystemItem instanceof Directory) {
                        console.getCurrentDrive().setCurrentDirectory((Directory) filesystemItem);
                        found = true;
                    }
                }
                if (!found) {
                    console.getCurrentDrive().setCurrentDirectory(currentDirectoryBackup);
                    currentPath = pathBackup;
                    writeError();
                    break;
                }
            }
            if (found) {
                for (String element : splittedPathSanitized) {
                    Command.currentPath += element + "\\";
                }
            }
            return;
        }
        // relativer Pfad
        String twoBackslashs = parameters.get(0).replace("\\", "\\\\");
        String[] splittedPath = twoBackslashs.split("\\\\");
        ArrayList<String> splittedPathSanitized = new ArrayList<>();
        for (String element : splittedPath) {
            if (!element.equals("")) {
                splittedPathSanitized.add(element);
            }
        }
        boolean found = false;
        for (String element : splittedPathSanitized) {
            found = false;
            for (FilesystemItem filesystemItem : console.getCurrentDrive().getCurrentDirectory().getFilesystemItems()) {
                if (element.equals(filesystemItem.getName().replace("\\", "")) && filesystemItem instanceof Directory) {
                    console.getCurrentDrive().setCurrentDirectory((Directory) filesystemItem);
                    found = true;
                }
            }
            if (!found) {
                console.getCurrentDrive().setCurrentDirectory(currentDirectoryBackup);
                writeError();
                break;
            }
        }
        if (found) {
            for (String element : splittedPathSanitized) {
                Command.currentPath += element + "\\";
            }
        }

    }
    public void writeError() {
        outputWriter.println("This Path doesn't exist.");
    }
    @Override
    public int getRequiredArguments() {
        return requiredArguments;
    }
}
