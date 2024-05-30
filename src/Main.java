import Commands.*;
import Consoles.BaseConsole;
import Managers.*;

/**
 * 1800
 * коллекция - файл, все города
 * Элемент коллекции - один город
 */

public class Main
{

    public static void main(String[] args) throws Ask.AskBreak {
        var console = new BaseConsole();

        String filePath = System.getenv("FILE_PATH");
        if (filePath == null){
            console.printError("Введите имя загружаемого файла как переменная окружения");
        }

        var loadManager = new LoadManager(filePath, console);
        var collectionManager = new CollectionManager(loadManager);
        if (!collectionManager.loadCollection()) {
            System.exit(1);
        }

        var commandManager = new CommandManager() {{
            register("add", new Add(console, collectionManager));
            register("add_if_min", new Add_if_min(console, collectionManager));
            register("clear", new Clear(console, collectionManager));
            register("exit", new Exit(console));
            //register("filter_by_car_code", new Filter_by_car_code(console, collectionManager));
            //register("filter_greater_than_agglomeration", new Filter_greater_than_agglomeration(console, collectionManager));
            //register("group_counting_by_population", new Group_counting_by_population(console, collectionManager));
            register("help", new Help(console, this));
            register("history", new History(console, this));
            register("info", new Info(console, collectionManager));
            register("remove_by_id", new Remove_by_Id(console, collectionManager));
            register("remove_lower", new Remove_Lower(console, collectionManager));
            register("save", new Save(console, collectionManager));
            register("show", new Show(console, collectionManager));
            register("update", new Update_Id(console, collectionManager));
        }};

        new Runner(console, commandManager).interactiveMode();
    }
}
