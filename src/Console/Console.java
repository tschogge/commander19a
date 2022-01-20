package Console;
import java.util.Scanner;
public class Console {

    public String readInput(){
        Scanner scanner = new Scanner(System.in);
        String hallo = scanner.nextLine();
        System.out.println(hallo);
        return hallo;
    }

    public void start(){
        readInput();
    }

    public void exit(){

    }
}