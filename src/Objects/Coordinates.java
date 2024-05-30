package Objects;

import Utility.Validatable;

public class Coordinates implements Validatable {
    private Float x; //Максимальное значение поля: 273, Поле не может быть null
    private float y;

    public Coordinates(String s) {
        try {
            try { this.x = Float.parseFloat(s.split(",")[0]); } catch (NumberFormatException e) { }

            try { this.y = Float.parseFloat(s.split(",")[1]); }catch (NumberFormatException e) { }
        } catch (ArrayIndexOutOfBoundsException e) {}
        //return new Coordinates(x, y);
    }

    @Override
    public String toString() {
        return x + ";" + y;
    }

    @Override
    public boolean validate() {
        if (x == null || x > 273) return false;
            return true;
    }
}
