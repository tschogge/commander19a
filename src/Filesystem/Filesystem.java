package Filesystem;

import Services.PersistencyService;

import java.lang.reflect.Array;
import java.util.ArrayList;
public class Filesystem {
    private ArrayList<Drive> drives;
    private PersistencyService persistencyService;

    public Filesystem() {
        persistencyService = new PersistencyService();
        drives = load();
        if (drives.size() == 0) {
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
            drives.add(driveC);
            // --- TESTZWECKE
            Drive drive = getMainDrive();
            File file = new File();
            file.setName("testfile");
            file.setPath(drive.getRootDirectory().getPath() + drive.getRootDirectory().getName());
            file.setContent("Testerus maximus \n LULWWWW \n\n\n HéHéHéHéHüüöä");
            drive.getRootDirectory().getFilesystemItems().add(file);
            // directory
            Directory directory = new Directory();
            directory.setFilesystemItems(new ArrayList<FilesystemItem>());
            directory.setName("kek\\");
            directory.setPath(drive.getRootDirectory().getPath() + drive.getRootDirectory().getName());
            drive.getRootDirectory().getFilesystemItems().add(directory);
            //  directory 2
            Directory directory2 = new Directory();
            directory2.setFilesystemItems(new ArrayList<FilesystemItem>());
            directory2.setName("monsieur\\");
            directory2.setPath(directory.getPath() + directory.getName());
            directory.getFilesystemItems().add(directory2);
            // directory 3
            Directory directory3 = new Directory();
            directory3.setFilesystemItems(new ArrayList<FilesystemItem>());
            directory3.setName("raffmael\\");
            directory3.setPath(directory2.getPath() + directory2.getName());
            directory2.getFilesystemItems().add(directory3);
            // --- TESTZWECKE
            save();
        }

    }

    public void save() {
        persistencyService.saveDrives(this.drives);
    }
    public ArrayList<Drive> load() {
        return persistencyService.loadDrives();
    }
    public Drive getMainDrive() {
        Drive cDrive = new Drive();
        for (Drive drive : this.drives) {
            if (drive.getLabel().equals("C:")) {
                cDrive = drive;
            }
        }
        return cDrive;
    }
}
