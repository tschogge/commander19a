package Filesystem;

public class File extends FilesystemItem{
    private String content;
    private int size;

    public File() {

    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public int getSize() {
        return content.length();
    }

}
