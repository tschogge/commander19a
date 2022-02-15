import Console.CommandInvoker;
import Console.Console;
import Filesystem.Directory;
import Filesystem.Drive;
import Filesystem.File;
import Filesystem.FilesystemItem;
import Services.PersistencyService;

import java.nio.file.FileSystem;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // ablauf methode von console aufrufen, siehe architekturbild im teams chat
        Console console = new Console();
        console.start();
        //testSave();


    }
    static public void testSave() {
        // methode zu persistenz-probezwecken
        ArrayList<Drive> drives = new ArrayList<>();
        Drive drive = new Drive();
        Directory dir = new Directory();
        File file = new File();
        file.setContent("Raffi de sack");
        File file2 = new File();
        file2.setContent("Raffi de hund");

        dir.setName("root");
        dir.setPath("dsds");

        ArrayList<FilesystemItem> filesystemItems = new ArrayList<>();
        filesystemItems.add(file);
        filesystemItems.add(file2);
        dir.setFilesystemItems(filesystemItems);
        filesystemItems = new ArrayList<>();
        filesystemItems.add(dir);
        drive.setFilesystemItems(filesystemItems);
        drives.add(drive);

        PersistencyService persistencyService = new PersistencyService();
        persistencyService.saveDrives(drives);
    }
}