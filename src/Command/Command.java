package Command;

import Console.OutputWriter;

import java.util.ArrayList;

public abstract class Command {
    protected ArrayList<String> parameters;
    protected OutputWriter outputWriter;

    public void execute() {

    }

    public ArrayList<String> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<String> parameters) {
        this.parameters = parameters;
    }

    public OutputWriter getOutputWriter() {
        return outputWriter;
    }

    public void setOutputWriter(OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
    }
}
