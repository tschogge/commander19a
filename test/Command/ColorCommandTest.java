package Command;

import Console.Console;
import Console.ConsoleOutputWriter;
import Console.OutputWriter;
import Console.TestOutputWriter;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ColorCommandTest {
    ColorCommand colorCommand = new ColorCommand();
    OutputWriter outputWriter = new ConsoleOutputWriter();
    OutputWriter testWriter = new TestOutputWriter();
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    ConsoleOutputWriter consoleOutputWriter = new ConsoleOutputWriter();
    final PrintStream oldStream = System.out;

    @Test
    void changeColorRed() {
        colorCommand.setOutputWriter(outputWriter);
        System.setOut(new PrintStream(outputStream));
        colorCommand.changeColor("red");
        consoleOutputWriter.print("Hermann in Rot");
        System.setOut(oldStream);
        assertEquals(ColorCommand.ANSI_RED + "Hermann in Rot" + ColorCommand.ANSI_RESET, outputStream.toString());
    }

    @Test
    void changeColorBlue() {
        colorCommand.setOutputWriter(outputWriter);
        System.setOut(new PrintStream(outputStream));
        colorCommand.changeColor("blue");
        consoleOutputWriter.print("Hermann in Blau");
        System.setOut(oldStream);
        assertEquals(ColorCommand.ANSI_BLUE + "Hermann in Blau" + ColorCommand.ANSI_RESET, outputStream.toString());
    }

    @Test
    void changeColorInvalid() {
        colorCommand.changeColor("");
        colorCommand.setOutputWriter(outputWriter);
        System.setOut(new PrintStream(outputStream));
        colorCommand.changeColor("err");
        System.setOut(oldStream);
        assertEquals(ColorCommand.ANSI_BLACK + "Your color does not exist" + ColorCommand.ANSI_RESET + System.lineSeparator(), outputStream.toString());
    }
}