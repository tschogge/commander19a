package Filesystem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
@JsonTypeInfo(use = Id.CLASS,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @Type(value = Directory.class),
        @Type(value = File.class),
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilesystemItem {
    protected String name;
    protected String path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public FilesystemItem(String name, String path) {
        this.name = name;
        this.path = path;
    }
    public FilesystemItem(){

    }
}
