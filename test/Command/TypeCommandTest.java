package Command;

import Console.Console;
import Filesystem.Directory;
import Filesystem.Drive;
import Filesystem.File;
import Filesystem.FilesystemItem;
import org.junit.jupiter.api.*;
import Console.OutputWriter;
import Console.TestOutputWriter;

import static Command.Command.currentPath;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class TypeCommandTest {
    @Test
    public void fileExistsTest() {
        // arrange
        OutputWriter outputWriter = new TestOutputWriter();
        Console console = new Console();
        Directory rootDir = new Directory();
        rootDir.setFilesystemItems(new ArrayList<FilesystemItem>());
        rootDir.setName("\\");
        rootDir.setPath("C:");
        Drive driveC = new Drive();
        driveC.setName("base-drive");
        driveC.setLabel("C:");
        driveC.setRootDirectory(rootDir);
        driveC.setCurrentDirectory(null);
        driveC.setSize(-1);
        driveC.setCurrentDirectory(rootDir);
        File file = new File();
        file.setName("testfile");
        file.setPath(driveC.getRootDirectory().getPath() + driveC.getRootDirectory().getName());
        file.setContent("Testerus maximus \n LULWWWW \n\n\n HéHéHéHéHüüöä");
        driveC.getRootDirectory().getFilesystemItems().add(file);
        console.setCurrentDrive(driveC);
        Command typeCommand = new TypeCommand();
        ArrayList<String> parameters = new ArrayList<>();
        parameters.add("testfile");
        typeCommand.setParameters(parameters);
        // set outputwriter
        typeCommand.setOutputWriter(outputWriter);
        // act
        typeCommand.execute();
        TestOutputWriter testOutputWriter = (TestOutputWriter) typeCommand.getOutputWriter();
        // assert
        assertEquals("Testerus maximus \n LULWWWW \n\n\n HéHéHéHéHüüöä", testOutputWriter.output);
    }
    @Test
    public void fileDontExistsTest() {
        // arrange
        OutputWriter outputWriter = new TestOutputWriter();
        Console console = new Console();
        Directory rootDir = new Directory();
        rootDir.setFilesystemItems(new ArrayList<FilesystemItem>());
        rootDir.setName("\\");
        rootDir.setPath("C:");
        Drive driveC = new Drive();
        driveC.setName("base-drive");
        driveC.setLabel("C:");
        driveC.setRootDirectory(rootDir);
        driveC.setCurrentDirectory(null);
        driveC.setSize(-1);
        driveC.setCurrentDirectory(rootDir);
        File file = new File();
        file.setName("nottestfile");
        file.setPath(driveC.getRootDirectory().getPath() + driveC.getRootDirectory().getName());
        file.setContent("Testerus maximus \n LULWWWW \n\n\n HéHéHéHéHüüöä");
        driveC.getRootDirectory().getFilesystemItems().add(file);
        console.setCurrentDrive(driveC);
        Command typeCommand = new TypeCommand();
        ArrayList<String> parameters = new ArrayList<>();
        parameters.add("testfile");
        typeCommand.setParameters(parameters);
        currentPath = driveC.getRootDirectory().getPath() + driveC.getCurrentDirectory().getName();
        // set outputwriter
        typeCommand.setOutputWriter(outputWriter);
        // act
        typeCommand.execute();
        TestOutputWriter testOutputWriter = (TestOutputWriter) typeCommand.getOutputWriter();
        // assert
        assertEquals("The File \"" + currentPath + parameters.get(0) + "\" doesn't exist!", testOutputWriter.output);

    }
}
