package Commands;


import Managers.CollectionManager;
import Consoles.BaseConsole;
import Utility.ExecutionResponse;

/**
 * Команда 'remove_by_id'. Удаляет элемент из коллекции.
 * @author dim0n4eg
 */
public class Clear extends Command {
    private final BaseConsole console;
    private final CollectionManager collectionManager;

    public Clear(BaseConsole console, CollectionManager collectionManager) {
        super("clear", "очистить коллекцию");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public ExecutionResponse apply(String[] arguments) {
        if (arguments.length == 0)
            return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");

        while (collectionManager.getCollection().size() > 0) {
            var dragon = collectionManager.getCollection().getLast();
            collectionManager.remove(dragon.getId());
        }

        collectionManager.update();
        return new ExecutionResponse("Коллекция очищена!");
    }
}