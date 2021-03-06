package Command;

import Console.OutputWriter;
import Console.TestOutputWriter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerCommandTest {

    VerCommand verCommand = new VerCommand();

    @Test
    void versionName() {
        assertEquals(System.getProperty("os.name") + " " + System.getProperty("os.arch"), verCommand.versionName());
    }

    @Test
    void versionNumber() {
        assertEquals(verCommand.getVersionNumber(), verCommand.versionNumber());
    }

    @Test
    void userName() {
        assertEquals(System.getProperty("user.name"), verCommand.userName());
    }

    @Test
    void displayAll() {
        OutputWriter outputWriterTest = new TestOutputWriter();
        verCommand.setOutputWriter(outputWriterTest);
        verCommand.execute();
        TestOutputWriter outputWriter = (TestOutputWriter) verCommand.getOutputWriter();
        assertEquals("System is running on:  " + System.getProperty("os.name") + " " + System.getProperty("os.arch") + "\n" +
                "Application-Version: " + verCommand.getCurrentGeneralVersion() + " " + verCommand.getVersionNumber() + "\n" +
                "Benutzer: " + System.getProperty("user.name"), outputWriter.output);
    }
}
