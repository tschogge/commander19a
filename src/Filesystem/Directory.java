package Filesystem;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Directory extends FilesystemItem {
    private ArrayList<FilesystemItem> filesystemItems;
    public Directory() {

    }

    public List<FilesystemItem> getFilesystemItems() {
        return filesystemItems;
    }

    public void setFilesystemItems(ArrayList<FilesystemItem> filesystemItems) {
        this.filesystemItems = filesystemItems;
    }
}
