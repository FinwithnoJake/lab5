package Commands;

import Utility.ExecutionResponse;

public abstract class Command{
    private final String name;
    private final String description;

    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * @return Название и использование команды.
     */
    public String getName() {
        return name;
    }

    /**
     * @return Описание команды.
     */
    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Command command = (Command) obj;
        return name.equals(command.name) && description.equals(command.description);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + description.hashCode();
    }

    @Override
    public String toString() {
        return "Command{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public abstract ExecutionResponse apply(String[] arguments);
}







/*
package utility;

public class ExecutionResponse {
    private boolean exitCode;
    private String massage;

    public ExecutionResponse(boolean code, String s) {
        exitCode = code;
        massage = s;
    }


    public ExecutionResponse(String s) {
        this(true, s);
    }

    public boolean getExitCode() { return exitCode; }
    public String getMassage() { return massage; }

    public String toString() { return String.valueOf(exitCode)+";"+massage+";"+

            (responseObj==null?"null":responseObj.toString()); }


 */