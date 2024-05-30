package Commands;

import Managers.CollectionManager;
import Consoles.BaseConsole;
import Utility.ExecutionResponse;

/**
 * Команда 'remove_by_id'. Удаляет элемент из коллекции.
 * @author dim0n4eg
 */
public class Remove_Lower extends Command {
    private final BaseConsole console;
    private final CollectionManager collectionManager;

    public Remove_Lower(BaseConsole console, CollectionManager collectionManager) {
        super("remove_lower <ID>", "удалить элемент из коллекции");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public ExecutionResponse apply(String[] arguments) {
        if (arguments.length <= 1) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        int id = -1;
        try { id = Integer.parseInt(arguments[1].trim()); } catch (NumberFormatException e) { return new ExecutionResponse(false, "ID не распознан"); }

        if (collectionManager.byId(id) == null || !collectionManager.getCollection().contains(collectionManager.byId(id)))
            return new ExecutionResponse(false, "Не существующий ID");
        collectionManager.remove(id);
        collectionManager.update();
        return new ExecutionResponse("City успешно удалён!");
    }
}