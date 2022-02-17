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
     * Gibt alle Daten des Systems aus
     */
    public void execute() {
        String versionName = versionName();
        String user = userName();
        String versionText = "Application-Version: ";
        String versionDisplayText = "System is running on: ";
        String userText = "Benutzer: ";
        String wholeText = versionDisplayText + " " + versionName + "\n" + versionText + currentGeneralVersion + " " + versionNumber + "\n" + userText + user;
        outputWriter.println(wholeText);
    }

    public String getVersionNumber() {
        return this.versionNumber;
    }

    public String getCurrentGeneralVersion() {
        return currentGeneralVersion;
    }

    int getRequredArguments() {
        return requiredArguments;
    }

}
