package Commands;

import Consoles.*;
import Utility.ExecutionResponse;

/**
 * Команда 'exit'. Завершает выполнение.
 * @author dim0n4eg
 */
public class Exit extends Command {
    private final BaseConsole console;

    public Exit(Console console) {
        super("exit", "завершить программу (без сохранения в файл)");
        this.console = (BaseConsole) console;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public ExecutionResponse apply(String[] arguments) {
        if (arguments.length == 0) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");

        return new ExecutionResponse("exit"); //"Завершение выполнения...");
    }
}