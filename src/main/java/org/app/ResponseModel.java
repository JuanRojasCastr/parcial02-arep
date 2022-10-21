package org.app;

public class ResponseModel {
    private String operation;
    private int input;

    @Override
    public String toString() {
        return "{" +
                "\"operation\":" + "\"" + operation + "\"" +
                ", \"input\":" + "\"" + input + "\"" +
                ", \"output\":'" +  "\"" + output +  "\"" +
                '}';
    }

    private String output;

    public ResponseModel(String operation, int input, String output) {
        this.operation = operation;
        this.input = input;
        this.output = output;
    }

    public String getOperation() {
        return operation;
    }

    public int getInput() {
        return input;
    }

    public String getOutput() {
        return output;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
