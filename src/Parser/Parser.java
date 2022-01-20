package Parser;


import java.util.ArrayList;

//Erarbeitet von Tschogge und Lars

public class Parser {


    private String entryString;


    public boolean checkEntity(String entityString) {

        return !entityString.equals("");
    }

    public String[] parseCommand(String entityString) {

        if (checkEntity(entityString)) {

            return entityString.split("\\s+");

        }
        return null;

    }

}







