package Command;

public class VerCommand extends Command {

    public static int requiredArguments = 0;

    private String versionNumber = "1.2";
    private String currentGeneralVersion = "Beta";

    //Display from OS-System
    //Display Console-App-Version
    //Look if linux easily done

    public String versionName() {
        return System.getProperty("os.name") + " " + System.getProperty("os.arch");
    }

    public String versionNumber() {
        return versionNumber;
    }

    public String userName() {
        return System.getProperty("user.name");
    }

    public String displayAll() {
        String versionName = versionName();
        String user = userName();
        String versionText = "Application-Version: ";
        String versionDisplayText = "System is running on: ";
        String userText = "Benutzer: ";
        return (versionDisplayText + " " + versionName + "\n" + versionText + currentGeneralVersion + " " + versionNumber + "\n" + userText + user);
    }

    public String getVersionNumber() {
        return this.versionNumber;
    }

    public String getCurrentGeneralVersion() {
        return currentGeneralVersion;
    }

}
