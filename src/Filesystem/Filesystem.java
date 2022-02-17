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
