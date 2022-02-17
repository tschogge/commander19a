package Console;

public class TestOutputWriter implements OutputWriter{
    public String output;

    public TestOutputWriter() {
        output = "";
    }

    @Override
    public void print(String text) {
        output += text;
    }

    @Override
    public void println(String text) {
        output += text;
    }

    public void flushOutputStream() {
        output = "";
    }
}
