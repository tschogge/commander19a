package Console;
import java.util.Scanner;
public class Console {

//

    public String readInput(){
        Scanner scanner = new Scanner(System.in);
        String userIput = scanner.nextLine();
        return userIput;
    }

    public void start(){
        CommandInvoker commandInvoker;
        do {
            commandInvoker = new CommandInvoker(readInput());
            commandInvoker.executeCommand();
        } while (commandInvoker.again);
    }

    public void exit(){

    }
}