package Filesystem;

import Services.PersistencyService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
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
            rootDir.setParentDirectory(null);
            Drive driveC = new Drive();
            driveC.setName("base-drive");
            driveC.setLabel("C");
            driveC.setRootDirectory(rootDir);
            driveC.setCurrentDirectory(null);
            driveC.setSize(-1);
            driveC.setFilesystemItems(new ArrayList<FilesystemItem>());
            drives.add(driveC);
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
            if (drive.getLabel().equals("C")) {
                cDrive = drive;
            }
        }
        return cDrive;
    }
}
