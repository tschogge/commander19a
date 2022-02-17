package Console;

import org.junit.jupiter.api.*;

public class TestOutputWriter implements OutputWriter{
    public String output;

    public TestOutputWriter() {
        output = "";
    }

    @Test
    public void print(String text) {
        output += text;
    }

    @Test
    public void println(String text) {
        output += text;
    }

    public void flushOutputStream() {
        output = "";
    }
}
