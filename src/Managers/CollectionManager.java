package Managers;

import java.util.LinkedList;

import Objects.City;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Оперирует коллекцией.
 */
public class CollectionManager {
    private int currentId = 1;
    private Map<Integer, City> citys = new HashMap<>();
    private LinkedList<City> collection = new LinkedList<City>();
    private LocalDateTime lastInitTime;
    private LocalDateTime lastSaveTime;
    private final LoadManager loadManager;

    public CollectionManager(LoadManager loadManager) {
        this.lastInitTime = null;
        this.lastSaveTime = null;
        this.loadManager = loadManager;
    }

    /**
     * @return коллекция.
     */
    public LinkedList<City> getCollection() {
        return collection;
    }

    /**
     * @return Последнее время инициализации.
     */
    public LocalDateTime getLastInitTime() {
        return lastInitTime;
    }

    /**
     * @return Последнее время сохранения.
     */
    public LocalDateTime getLastSaveTime() {
        return lastSaveTime;
    }

    /**
     * Сохраняет коллекцию в файл
     */
    public void saveCollection() {
        loadManager.writeCollection(collection);
        lastSaveTime = LocalDateTime.now();
    }

    /**
     * Получить City по ID
     */
    public City byId(Integer id) { return citys.get(id); }

    /**
     * Содержит ли колекции City
     */
    public boolean isСontain(City e) { return e == null || byId(e.getId()) != null; }

    /**
     * Получить свободный ID
     */
    public int getFreeId() {
        while (byId(currentId) != null)
            if (++currentId < 0)
                currentId = 1;
        return currentId;
    }


    /**
     * Добавляет City
     */
    public boolean add(City d) {
        if (isСontain(d)) return false;
        citys.put(d.getId(), d);
        collection.add(d);
        update();
        return true;
    }

    public boolean add_if_min(City d) {
        if (isСontain(d)) return false;
        citys.put(d.getId(), d);
        collection.add(d);
        update();
        return true;
    }

    /**
     * Удаляет City по ID
     */
    public boolean remove(int id) {
        var a = byId(id);
        if (a == null) return false;
        citys.remove(a.getId());
        collection.remove(a);
        update();
        return true;
    }

    /**
     * Фиксирует изменения коллекции
     */
    public void update() {
        Collections.sort(collection);
    }

    /**
     * Загружает коллекцию из файла.
     * @return true в случае успеха.
     */
    public boolean loadCollection() {
        citys.clear();
        loadManager.readCollection(collection);
        lastInitTime = LocalDateTime.now();
        for (var e : collection)
            if (byId(e.getId()) != null) {
                collection.clear();
                return false;
            } else {
                if (e.getId()>currentId) currentId = e.getId();
                citys.put(e.getId(), e);
            }
        update();
        return true;
    }

    @Override
    public String toString() {
        if (collection.isEmpty()) return "Коллекция пуста!";

        StringBuilder info = new StringBuilder();
        for (City city : collection) {
            info.append(city+"\n\n");
        }
        return info.toString().trim();
    }
}