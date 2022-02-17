package Services;

import Filesystem.Directory;
import Filesystem.Drive;
import Filesystem.FilesystemItem;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PersistencyServiceTest {
    @Test
    public void saveAndLoadOnlyDriveTest() {
        // arrange
        ArrayList<Drive> expected;
        ArrayList<Drive> actual;
        PersistencyService persistencyService = new PersistencyService();
        persistencyService.setFilename("filesystemTest.json");

        ArrayList<Drive> drives = new ArrayList<>();
        Drive drive = new Drive();
        drive.setName("12345abcde");
        drives.add(drive);

        expected = drives;
        //act
        persistencyService.saveDrives(expected);
        actual = persistencyService.loadDrives();
        //assert
        assertEquals(expected.get(0).getName(), actual.get(0).getName());
        File file = new File("filesystemTest.json");
        file.delete();
    }
    @Test
    public void saveAndLoadDriveAndRootTest() {
        // arrange
        ArrayList<Drive> expected;
        ArrayList<Drive> actual;
        PersistencyService persistencyService = new PersistencyService();
        persistencyService.setFilename("filesystemTest.json");

        ArrayList<Drive> drives = new ArrayList<>();
        Drive drive = new Drive();
        drive.setName("12345abcde");
        Directory rootDir = new Directory();
        rootDir.setName("sdojsos");
        drive.setRootDirectory(rootDir);
        drives.add(drive);

        expected = drives;
        //act
        persistencyService.saveDrives(expected);
        actual = persistencyService.loadDrives();
        //assert
        assertEquals(expected.get(0).getName(), actual.get(0).getName());
        assertEquals(expected.get(0).getRootDirectory().getName(), actual.get(0).getRootDirectory().getName());
        File file = new File("filesystemTest.json");
        file.delete();
    }
    @Test
    public void saveAndLoadDriveRootAndDirTest() {
        // arrange
        ArrayList<Drive> expected;
        ArrayList<Drive> actual;
        PersistencyService persistencyService = new PersistencyService();
        persistencyService.setFilename("filesystemTest.json");

        ArrayList<Drive> drives = new ArrayList<>();
        Drive drive = new Drive();
        drive.setName("12345abcde");
        Directory rootDir = new Directory();
        rootDir.setFilesystemItems(new ArrayList<>());
        rootDir.setName("sdojsos");
        drive.setRootDirectory(rootDir);
        Directory directory = new Directory();
        directory.setName("dfdf");
        rootDir.getFilesystemItems().add(directory);
        drives.add(drive);

        expected = drives;
        //act
        persistencyService.saveDrives(expected);
        actual = persistencyService.loadDrives();
        //assert
        assertEquals(expected.get(0).getName(), actual.get(0).getName());
        assertEquals(expected.get(0).getRootDirectory().getName(), actual.get(0).getRootDirectory().getName());
        assertEquals(expected.get(0).getRootDirectory().getFilesystemItems().get(0).getName(), actual.get(0).getRootDirectory().getFilesystemItems().get(0).getName());
        File file = new File("filesystemTest.json");
        file.delete();
    }
    @Test
    public void saveAndLoadDriveRootDirAndFileTest() {
        // arrange
        ArrayList<Drive> expected;
        ArrayList<Drive> actual;
        PersistencyService persistencyService = new PersistencyService();
        persistencyService.setFilename("filesystemTest.json");

        ArrayList<Drive> drives = new ArrayList<>();
        Drive drive = new Drive();
        drive.setName("12345abcde");
        Directory rootDir = new Directory();
        rootDir.setFilesystemItems(new ArrayList<>());
        rootDir.setName("sdojsos");
        drive.setRootDirectory(rootDir);
        Directory directory = new Directory();
        directory.setName("dfdf");
        directory.setFilesystemItems(new ArrayList<>());
        directory.setPath("sddsds");
        Filesystem.File filetest = new Filesystem.File();
        filetest.setName("sdsdsdsd");
        filetest.setPath("sdsds");
        filetest.setContent("dsdsd");
        directory.getFilesystemItems().add(filetest);
        rootDir.getFilesystemItems().add(directory);
        drives.add(drive);

        expected = drives;
        //act
        persistencyService.saveDrives(expected);
        actual = persistencyService.loadDrives();
        //assert
        assertEquals(expected.get(0).getName(), actual.get(0).getName());
        assertEquals(expected.get(0).getRootDirectory().getName(), actual.get(0).getRootDirectory().getName());
        assertEquals(expected.get(0).getRootDirectory().getFilesystemItems().get(0).getName(), actual.get(0).getRootDirectory().getFilesystemItems().get(0).getName());
        Directory directoryForTest1 = (Directory) expected.get(0).getRootDirectory().getFilesystemItems().get(0);
        Directory directoryForTest2 = (Directory) actual.get(0).getRootDirectory().getFilesystemItems().get(0);
        assertEquals(directoryForTest1.getFilesystemItems().get(0).getName(), directoryForTest2.getFilesystemItems().get(0).getName());
        File file = new File("filesystemTest.json");
        file.delete();
        //file.delete();
    }
}
