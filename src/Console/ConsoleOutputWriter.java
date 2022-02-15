package Console;

import Command.*;

public class ConsoleOutputWriter implements OutputWriter {

    private String colorChosen= ColorCommand.getChosenColor();
    private final String resetValue = ColorCommand.getResetValue();

    @Override
    public void print(String text) {
        colorChosen = ColorCommand.getChosenColor();
        System.out.print(colorChosen + text + resetValue);
    }

    @Override
    public void println(String text) {
        colorChosen = ColorCommand.getChosenColor();
        System.out.println(colorChosen + text + resetValue);
    }
}
