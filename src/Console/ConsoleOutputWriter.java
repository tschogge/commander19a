package Console;

import Command.Command;
import Command.*;

public class ConsoleOutputWriter implements OutputWriter{

    private static String colorChosen = ColorCommand.getChosenColor();
    private static String resetValue = ColorCommand.getResetValue();


    @Override
    public void print(String text) {
        System.out.print(colorChosen + text + resetValue);
    }

    @Override
    public void println(String text) {
        System.out.println(colorChosen + text + resetValue);
    }
}
