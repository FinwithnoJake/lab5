package Commands;

import Managers.CollectionManager;
import Consoles.*;
import Utility.ExecutionResponse;

/**
 * Команда 'save'. Сохраняет коллекцию в файл.
 * @author dim0n4eg
 */
public class Save extends Command {
    private final BaseConsole console;
    private final CollectionManager collectionManager;

    public Save(Console console, CollectionManager collectionManager) {
        super("save", "сохранить коллекцию в файл");
        this.console = (BaseConsole) console;
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public ExecutionResponse apply(String[] arguments) {
        //if (!arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");

        collectionManager.saveCollection();
        return new ExecutionResponse(true, "");
    }
}