package Objects;

import Utility.Validatable;

import java.time.ZonedDateTime;

public class Human implements Validatable {
    private Double height; //Значение поля должно быть больше 0
    private java.time.ZonedDateTime birthday;

    public Human(String s) {
        try {
            try { this.height = Double.parseDouble(s.split(";")[0]); } catch (NumberFormatException e) { }

            try { this.birthday = ZonedDateTime.parse(s.split(";")[1]); }catch (NumberFormatException e) { }
        } catch (ArrayIndexOutOfBoundsException e) {}
    }

    public static Human valueOf(String line) {
        return null;
    }

    @Override
    public String toString() {
        return height + "; " + birthday;
    }

    @Override
    public boolean validate() {
        if (height <= 0) return false;
            return true;
    }
}