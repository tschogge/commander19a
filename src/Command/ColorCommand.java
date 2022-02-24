/**
 * @author: Tschogge, Lars
 * @version: 1.0
 */
package Command;

public class ColorCommand extends Command {
    public static int requiredArguments = 0;

    /**
     * ANSI Code Farben
     * ANSI wird von der InteliJ Console unterstützt
     */

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    //Starts program with default value
    private static String chosenColor = ANSI_BLACK;
    private static String resetValue = ANSI_RESET;

    private String errorMessage = "Your color does not exist";

    /**
     * Färbt den ausgegebenen Text nach der Farbe, die der Benutzer angegeben hat, wenn sie existiert
     *
     * @param entryString Die Farbe, in der der Text angezeigt werden soll
     */
    public void changeColor(String entryString) {
        switch (entryString.toLowerCase()) {
            case "default":
            case "":
                setChosenColor(ANSI_BLACK);
                break;
            case "red":
                setChosenColor(ANSI_RED);
                break;
            case "green":
                setChosenColor(ANSI_GREEN);
                break;
            case "yellow":
                setChosenColor(ANSI_YELLOW);
                break;
            case "blue":
                setChosenColor(ANSI_BLUE);
                break;
            case "purple":
                setChosenColor(ANSI_PURPLE);
                break;
            case "cyan":
                setChosenColor(ANSI_CYAN);
                break;
            case "white":
                setChosenColor(ANSI_WHITE);
                break;
            default:
                outputWriter.println(errorMessage);

        }

    }


    public static String getChosenColor() {
        return chosenColor;
    }

    public static void setChosenColor(String chosenColor) {
        ColorCommand.chosenColor = chosenColor;
    }


    public static String getResetValue() {
        return resetValue;
    }
    @Override
    public int getRequiredArguments() {
        return requiredArguments;
    }

    @Override
    public void execute() {
        if (parameters.size() > 0) {
            changeColor(parameters.get(0));
            return;
        }
        // Wenn keine argumente gegeben wurden
        changeColor("");

    }
}
