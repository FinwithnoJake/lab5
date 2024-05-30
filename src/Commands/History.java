package Commands;

import Managers.CommandManager;
import Consoles.*;
import Utility.ExecutionResponse;
import java.util.stream.Collectors;

/**
 * Команда 'history'. Вывыодит историю команд.
 * @author dim0n4eg
 */
public class History extends Command {
    private final BaseConsole console;
    private final CommandManager commandManager;

    public History(Console console, CommandManager commandManager) {
        super("history", "Вывыодит историю команд");
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

        return new ExecutionResponse(commandManager.getCommandHistory().stream().map(command -> " " + command).collect(Collectors.joining("\n")));
    }
}