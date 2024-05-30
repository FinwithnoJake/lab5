package Managers;

//import au.com.bytecode.opencsv.*;

//Чтение из файла - класса java.io.InputStreamReader
//Запись в файл - java.io.FileWriter

//FILE_PATH — это переменная окружения,
// указывающая на директорию с установленным JDK


import Consoles.BaseConsole;
import Objects.City;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class LoadManager {
    private final String fileName;
    private final BaseConsole console;

    public LoadManager(String fileName, BaseConsole console) {
        this.fileName = fileName;
        this.console = console;
    }

    /**
     * Преобразует коллекцию в CSV-строку.
     * @param collection
     * @return CSV-строка
     * java.io.FileWriter
     */
    private String collection2CSV(Collection<City> collection) {
        try {
            StringBuilder sb = new StringBuilder();
            //FileWriter fileWriter = new FileWriter(sw);
            for (var e : collection) {
                sb.append(Arrays.toString(City.toArray(e)));
                sb.append('\n');
            }
            return sb.toString();
        } catch (Exception e) {
            console.printError("Ошибка сериализации");
            return null;
        }
    }

    /**
     * Записывает коллекцию в файл.
     * @param collection коллекция
     */
    public void writeCollection(Collection<City> collection) {
        OutputStreamWriter writer = null;
        try {
            var csv = collection2CSV(collection);
            if (csv == null) return;
            writer = new OutputStreamWriter(new FileOutputStream("1.csv"));
            try {
                writer.write(csv);
                writer.flush();
                console.println("Коллекция успешна сохранена в файл!");
            } catch (IOException e) {
                console.printError("Неожиданная ошибка сохранения");
            }
        } catch (FileNotFoundException | NullPointerException e) {
            console.printError("Файл не найден");
        } finally {
            try {
                writer.close();
            } catch(IOException e) {
                e.printStackTrace();
                console.printError("Ошибка закрытия файла");
            }
        }
    }

    /**
     * Преобразует CSV-строку в коллекцию.
     * @param CSV-строка
     * @return коллекция
     * java.io.InputStreamReader
     */
    private LinkedList<City> CSV2collection(String s) {
        try {
            InputStreamReader fileReader = new InputStreamReader(InputStream.nullInputStream());
            LinkedList<City> ds = new LinkedList<City>();
            for(String record : Files.readAllLines(Paths.get("1.csv"))) {
                City d = City.fromArray(record.split(";"));
                if(d == null) continue;
                if (d.validate())
                    ds.add(d);
                else
                    console.printError("Файл с колекцией содержит недействительные данные");
            }
            fileReader.close();
            return ds;
        } catch (Exception e) {
            e.printStackTrace();
            console.printError("Ошибка десериализации");
            return null;
        }
    }

//    public static void main(String[] args) {
//        LinkedList<City> cities = new LoadManager("1.csv", new BaseConsole()).CSV2collection(null);
//
//    }

    /**
     * Считывает коллекцию из файл.
     * @return Считанная коллекция
     */
    public void readCollection(Collection<City> collection) {
        if (fileName != null && !fileName.isEmpty()) {
            try (var fileReader = new Scanner(new File(fileName))) {
                var s = new StringBuilder("");
                while (fileReader.hasNextLine()) {
                    s.append(fileReader.nextLine());
                    s.append("\n");
                }
                collection.clear();
                for (var e: CSV2collection(s.toString()))
                    collection.add(e);
                if (collection != null) {
                    console.println("Коллекция успешна загружена!");
                    return;
                } else
                    console.printError("В загрузочном файле не обнаружена необходимая коллекция!");
            } catch (FileNotFoundException exception) {
                console.printError("Загрузочный файл не найден!");
            } catch (IllegalStateException exception) {
                console.printError("Непредвиденная ошибка!");
                System.exit(0);
            }
        } else {
            console.printError("Аргумент командной строки с загрузочным файлом не найден!");
        }
        collection = new LinkedList<City>();
    }
}
