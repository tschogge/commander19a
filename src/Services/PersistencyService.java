package Services;

import Filesystem.Drive;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PersistencyService {
    private String filename = "filesystem.json";
    private ObjectMapper objectMapper;

    public PersistencyService() {
        objectMapper = new ObjectMapper();
    }
    public ArrayList<Drive> loadDrives() {
        ArrayList<Drive> drivesList = new ArrayList<>();
        try {
            File jsonFile = new File(filename);

            if (jsonFile.exists()) {
                Drive[] drives = objectMapper.readValue(jsonFile, Drive[].class);
                // convert array to arraylist
                for (Drive drive : drives) {
                    drivesList.add(drive);
                }
            } else {
                jsonFile.createNewFile();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return drivesList;
    }
    public void saveDrives(ArrayList<Drive> drives) {
        try {
            File jsonFile = new File(filename);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, drives);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
