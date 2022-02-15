/**
 * @author: Tschogge, Lars
 * @version: 1.1
 */

package Command;

public class VerCommand extends Command {

    public static int requiredArguments = 0;
    private String versionNumber = "1.2";
    private String currentGeneralVersion = "Beta";

    /**
     * @return String: Der name des Systems
     */
    public String versionName() {
        return System.getProperty("os.name") + " " + System.getProperty("os.arch");
    }

    /**
     * @return String: Die Versions Nummer der Applikation
     */
    public String versionNumber() {
        return versionNumber;
    }

    /**
     * @return String: Den Benutzernamen des Benutzers
     */
    public String userName() {
        return System.getProperty("user.name");
    }

    /**
     * @return String: Alle Angaben über das System
     */
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
