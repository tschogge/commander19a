/**
 * @author: Tschogge, Lars
 * @version: 1.2
 */
package Parser;

import Command.*;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    /**
     * Validiert, ob der eingegebene String gültig ist
     *
     * @param entityString Der ganze Command String
     * @return boolean: True oder False
     */
    public boolean checkEntity(String entityString) {
        return !entityString.equals("");
    }

    /**
     * Überprüft, ob der Command existiert
     *
     * @param entitiyString Der ganze Command String
     * @return boolean: True oder false
     */
    public boolean commandFound(String entitiyString) {
        if (CommandFactory.createCommand(commandOnly(entitiyString)) == null) {
            return false;
        }
        return true;

    }

    /**
     * Überprüft, ob der Benutzer genug Parameter angegeben hat
     *
     * @param entityString Der ganze Command String
     * @return boolean: True oder false
     */
    public boolean enoughArguments(String entityString) {
        // Für jeden Command die required anzahl argumente hinzufügen
        if (commandOnly(entityString).equals("type") && parseParameter(entityString).size() >= TypeCommand.requiredArguments) {
            return true;
        }
        if (commandOnly(entityString).equals("exit") && parseParameter(entityString).size() >= ExitCommand.requiredArguments) {
            return true;
        }
        if (commandOnly(entityString).equals("cls") && parseParameter(entityString).size() >= ClsCommand.requiredArguments) {
            return true;
        }
        if (commandOnly(entityString).equals("color") && parseParameter(entityString).size() >= ColorCommand.requiredArguments) {
            return true;
        }
        if (commandOnly(entityString).equals("dir") && parseParameter(entityString).size() >= DirCommand.requiredArguments) {
            return true;
        }
        if (commandOnly(entityString).equals("cd") && parseParameter(entityString).size() >= CdCommand.requiredArguments) {
            return true;
        }
        return false;
    }

    /**
     * @param entityString Der ganze Command String
     * @return Eine Liste mit dem command und allen Parametern
     */
    public ArrayList<String> parseWhole(String entityString) {
        return new ArrayList<>(List.of(entityString.split("\\s+")));
    }

    /**
     * Gibt den Command zurück
     *
     * @param entityString Der ganze Command String
     * @return String: Den command als String
     */
    public String commandOnly(String entityString) {
        return parseWhole(entityString).get(0).toLowerCase();
    }

    /**
     * Überprüft alle Parameter und gibt sie zurück
     *
     * @param entityString Der ganze Command String
     * @return Array: Alle Parameter des Commands
     */
    public ArrayList<String> parseParameter(String entityString) {
        ArrayList<String> transferString = parseWhole(entityString);
        transferString.remove(0);

        return transferString;
    }

}







