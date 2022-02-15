package Console;

import Command.Command;
import Command.ExitCommand;
import Filesystem.Drive;
import Filesystem.Filesystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Console {
    private OutputWriter outputWriter;
    private Filesystem filesystem;
    private Drive currentDrive;

    public Console() {
        outputWriter = new ConsoleOutputWriter();
        filesystem = new Filesystem();
        currentDrive = filesystem.getMainDrive();
    }

    public void printStartSpaces() {
        // Da man die Konsole nicht mit einem Command löschen kann muss man dies mit "New Lines" simulieren (siehe clsCommand-Klasse)
        // Damit dies nicht scheisse aussieht am besten in der ganzen App konsistent machen
        String outputString = "";
        for (int i = 0; i < 25; i++) {
            outputString += "\r\n";
        }
        outputWriter.println(outputString);
    }

    public void printPath() {
        outputWriter.print(Command.getCurrentPath() + ">");
    }

    public void managePathInit() {
        Command.currentPath = currentDrive.getRootDirectory().getPath() + currentDrive.getRootDirectory().getName();
    }

    public String readInput() {
        Scanner scanner = new Scanner(System.in);
        String userIput = scanner.nextLine();
        return userIput;
    }

    public void start() {
        managePathInit();
        printStartSpaces();
        CommandInvoker commandInvoker;
        do {
            printPath();
            commandInvoker = new CommandInvoker(readInput());
            commandInvoker.executeCommand();
        } while (ExitCommand.again);
    }


    public OutputWriter getOutputWriter() {
        return outputWriter;
    }

    public void setOutputWriter(OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
    }
}