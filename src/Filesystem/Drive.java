package Filesystem;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Drive {
    private ArrayList<FilesystemItem> filesystemItems;
    private String name;
    private String label;
    private Directory rootDirectory;
    private Directory currentDirectory;
    private int size;
    public Drive() {

    }

    public ArrayList<FilesystemItem> getFilesystemItems() {
        return filesystemItems;
    }

    public void setFilesystemItems(ArrayList<FilesystemItem> filesystemItems) {
        this.filesystemItems = filesystemItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Directory getRootDirectory() {
        return rootDirectory;
    }

    public void setRootDirectory(Directory rootDirectory) {
        this.rootDirectory = rootDirectory;
    }

    public Directory getCurrentDirectory() {
        return currentDirectory;
    }

    public void setCurrentDirectory(Directory currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
