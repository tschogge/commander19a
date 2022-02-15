package Command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TypeCommand extends Command {

    public static int requiredArguments = 1;
    private String path;

    public TypeCommand() {
    }

    @Override
    public void execute() {
        String path = Command.currentPath + "\\" + parameters.get(0);
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                outputWriter.println(line);
            }
        } catch (IOException e) {
            outputWriter.println("File \"" + path + "\" not found!");
        }
    }

    @Override
    public int getRequiredArguments() {
        return requiredArguments;
    }
}
