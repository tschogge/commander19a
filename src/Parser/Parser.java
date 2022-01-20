package Parser;


//Erarbeitet von Tschogge und Lars

public class Parser {


    private String entryString;


    public boolean checkEntity(String entityString) {

        return !entityString.equals("");
    }

    public String[] parseWhole(String entityString) {

        if (checkEntity(entityString)) {

            return entityString.split("\\s+");

        }
        return null;

    }

    public String commandOnly(String entityString){


        return parseWhole(entityString)[0];
    }

    public String[] parseParameter(String entityString){

        String[] transferString = new String[parseWhole(entityString).length - 1];

        for (int i = 1; i < parseWhole(entityString).length; i++) {
            transferString[i - 1] = parseWhole(entityString)[i];
        }

        return transferString;
    }

}







