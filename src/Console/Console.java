package Console;
import Command.Command;
import Command.ExitCommand;

import java.util.Scanner;
public class Console {


    public void printStartSpaces() {
        // Da man die Konsole nicht mit einem Command löschen kann muss man dies mit "New Lines" simulieren (siehe clsCommand-Klasse)
        // Damit dies nicht scheisse aussieht am besten in der ganzen App konsistent machen
        String outputString = "";
        for (int i = 0; i < 25; i++) {
            outputString+= "\r\n";
        }
        System.out.println(outputString);
    }
    public void printPath() {
        System.out.print(Command.getCurrentPath() + ">");

    }
    public void managePathInit() {
        String currentPath = System.getProperty("user.dir");
        Command.currentPath = currentPath;
    }
    public String readInput(){
        Scanner scanner = new Scanner(System.in);
        String userIput = scanner.nextLine();
        return userIput;
    }

    public void start(){
        managePathInit();
        printStartSpaces();
        CommandInvoker commandInvoker;
        do {
            printPath();
            commandInvoker = new CommandInvoker(readInput());
            commandInvoker.executeCommand();
        } while (ExitCommand.again);
    }

    public void exit(){

    }

}