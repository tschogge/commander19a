package Parser;


//Erarbeitet von Tschogge und Lars

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parser {



    public boolean checkEntity(String entityString) {

        return !entityString.equals("");
    }

    public ArrayList<String> parseWhole(String entityString) {
        if (checkEntity(entityString)) {
            return new ArrayList<String>(List.of(entityString.split("\\s+")));
        }
        return null;
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







