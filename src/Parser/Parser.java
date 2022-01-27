package Parser;


//Erarbeitet von Tschogge und Lars

import Command.ClsCommand;
import Command.CommandFactory;
import Command.ExitCommand;
import Command.TypeCommand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parser {

    public boolean commandFound(String entitiyString) {
        if (CommandFactory.createCommand(commandOnly(entitiyString)) == null) {
            return false;
        }
        return true;
    }
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
        return false;
    }
    public ArrayList<String> parseWhole(String entityString) {
        return new ArrayList<>(List.of(entityString.split("\\s+")));
    }

    public String commandOnly(String entityString) {
        return parseWhole(entityString).get(0).toLowerCase();
    }

    public ArrayList<String> parseParameter(String entityString) {
        ArrayList<String> transferString = parseWhole(entityString);
        transferString.remove(0);

        return transferString;
    }

}







