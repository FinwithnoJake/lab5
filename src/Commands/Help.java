package Commands;

import Consoles.*;
import Managers.CommandManager;
import Utility.ExecutionResponse;
import java.util.stream.Collectors;

/**
 * Команда 'help'. Выводит справку по доступным командам
 * @author dim0n4eg
 */
public class Help extends Command {
    private final BaseConsole console;
    private final CommandManager commandManager;

    public Help(Console console, CommandManager commandManager) {
        super("help", "вывести справку по доступным командам");
        this.console = (BaseConsole) console;
        this.commandManager = commandManager;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public ExecutionResponse apply(String[] arguments) {
        if (arguments.length == 0) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");

        return new ExecutionResponse(commandManager.getCommands().values().stream().map(command -> String.format(" %-35s%-1s%n", command.getName(), command.getDescription())).collect(Collectors.joining("\n")));
    }
}