package Objects;

import Utility.Element;
import Utility.Validatable;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Objects;

public class City extends Element implements Validatable {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private float area; //Значение поля должно быть больше 0
    private Long population; //Значение поля должно быть больше 0, Поле не может быть null
    private float metersAboveSeaLevel;
    private Long carCode; //Значение поля должно быть больше 0, Максимальное значение поля: 1000, Поле не может быть null
    private long agglomeration;
    private Government government; //Поле не может быть null
    private Human governor; //Поле не может быть null


    public City(int id, String name, Coordinates coordinates, ZonedDateTime creationDate, float area, Long population, float metersAboveSeaLevel, Long carCode, long agglomeration, Government government, Human governor) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.area = area;
        this.population = population;
        this.metersAboveSeaLevel = metersAboveSeaLevel;
        this.carCode = carCode;
        this.agglomeration = agglomeration;
        this.government = government;
        this.governor = governor;
    }

    public City(int id, String name, Coordinates coordinates, float area, Long population, float metersAboveSeaLevel, Long carCode, long agglomeration, Government government, Human governor) {
        this(id, name, coordinates, ZonedDateTime.now(), area, population, metersAboveSeaLevel, carCode, agglomeration, government, governor);
    }

    @Override
    public String toString() {
        return "City{\"id\": " + id + ", " +
                "\"name\": \"" + name + "\", " +
                "\"coordinates\": \"" + coordinates + "\", " +
                "\"creationDate\": \"" + creationDate + "\", " +
                "\"area\": \"" + area + "\", " +
                "\"population\": \"" + population + "\", " +
                "\"metersAboveSeaLevel\": \"" + metersAboveSeaLevel + "\", " +
                "\"carCode\": \"" + carCode + "\", " +
                "\"agglomeration\": \"" + agglomeration + "\", " +
                "\"government\": \"" + government + "\", " +
                "\"governor\": \"" + governor + "\", ";
    }

    @Override
    public boolean validate() {
        if (id <= 0) return false;
        if (name == null || name.isEmpty()) return false;
        if (coordinates == null) return false;
        if (creationDate == null) return false;
        if (area <= 0) return false;
        if (population == null || population <= 0) return false;
        if (carCode == null || carCode <= 0 || carCode > 1000) return false;
        if (government == null) return false;
        if (governor == null) return false;
        return true;
    }

    @Override
    public int compareTo(Element element) {
        return (int) (this.id - element.getId());
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Coordinates getCoordinates(){
        return coordinates;
    }
    public ZonedDateTime getCreationDate(){
        return creationDate;
    }
    public float getArea(){
        return area;
    }
    public Long getPopulation(){
        return population;
    }
    public float getMetersAboveSeaLevel(){
        return population;
    }
    public Long getCarCode(){
        return population;
    }
    public long getAgglomeration(){
        return population;
    }
    public Government getGovernment(){
        return government;
    }
    public Human getHuman(){
        return governor;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City that = (City) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, ZonedDateTime.now(), area, population, metersAboveSeaLevel, carCode, agglomeration, government, governor);
    }



public static City fromArray(String[] a) {
    int id;
    String name;
    Coordinates coordinates;
    java.time.ZonedDateTime creationDate;
    float area;
    Long population;
    float metersAboveSeaLevel;
    Long carCode;
    long agglomeration;
    Government government;
    Human governor;
    try {
        try {
            id = Integer.parseInt(a[0]);

        } catch (NumberFormatException e) {
            id = 0;
        }
        name = a[1];
        coordinates = new Coordinates(a[2]);
        try {
            creationDate = ZonedDateTime.now();
            //creationDate = ZonedDateTime.parse(a[3], ZonedDateTime.parse(DateTimeFormatter.ISO_DATE_TIME));

        } catch (DateTimeParseException e) {
            creationDate = null;
        }
        ;
        try {
            area = Float.parseFloat(a[4]);
        } catch (NumberFormatException e) {
            area = 0;
        }
        try {
            population = Long.parseLong(a[5]);
        } catch (NumberFormatException e) {
            population = null;
        }
        try {
            metersAboveSeaLevel = Float.parseFloat(a[6]);
        } catch (NumberFormatException e) {
            metersAboveSeaLevel = 0;
        }
        try {
            carCode = Long.parseLong(a[7]);
        } catch (NumberFormatException e) {
            carCode = null;
        }
        try {
            agglomeration = Long.parseLong(a[8]);
        } catch (NumberFormatException e) {
            agglomeration = 0;
        }

        try {
            government = a[9].equals("null") ? null : Government.valueOf(a[4]);
        } catch (NullPointerException | IllegalArgumentException e) {
            government = null;
        }
        governor = new Human(a[10]);

        return new City(id, name, coordinates, ZonedDateTime.now(), area, population, metersAboveSeaLevel, carCode, agglomeration, government, governor);

    } catch (ArrayIndexOutOfBoundsException e) {
    }
    return null;
}

public static String[] toArray(City e) {
    var list = new ArrayList<String>();
    list.add(String.valueOf(e.getId()));
    list.add(e.getName());
    list.add(e.getCoordinates().toString());
    list.add(e.getCreationDate().format(DateTimeFormatter.ISO_DATE_TIME));
    list.add(String.valueOf(e.getArea()));
    list.add(e.getPopulation().toString());
    list.add(String.valueOf(e.getMetersAboveSeaLevel()));
    list.add(e.getCarCode().toString());
    list.add(String.valueOf(e.getAgglomeration()));
    list.add(e.getGovernment() == null ? "null" : e.getGovernment().toString());
    list.add(e.getHuman().toString());
    return list.toArray(new String[0]);
}

}
