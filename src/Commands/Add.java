package Commands;

import Consoles.BaseConsole;
import Managers.CollectionManager;
import Objects.City;
import Utility.ExecutionResponse;

/**
 * Команда 'add'. Добавляет новый элемент в коллекцию.
 */
public class Add extends Command {
    private final BaseConsole console;
    private final CollectionManager collectionManager;

    public Add(BaseConsole console, CollectionManager collectionManager) {
        super("add {element}", "добавить новый элемент в коллекцию");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды и сообщение об успешности.
     */

    public ExecutionResponse apply(String argument) {
        try {
            if (argument.isEmpty()) return new ExecutionResponse(false,

                    "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");

            console.println("* Создание нового City:");
            City a = Ask.askCity(console, collectionManager.getFreeId());

            if (a != null && a.validate()) {
                collectionManager.add(a);
                return new ExecutionResponse("City успешно добавлен!");
            } else
                return new ExecutionResponse(false, "Поля city не валидны! City не создан!");
        } catch (Ask.AskBreak e) {
            return new ExecutionResponse(false, "Отмена...");
        }
    }

    @Override
    public ExecutionResponse apply(String[] arguments) {
        return apply(arguments[0]);
    }
}