package Commands;

import Consoles.BaseConsole;
import Objects.*;

import java.time.ZonedDateTime;
import java.time.format.*;
import java.util.NoSuchElementException;

public class Ask {
    public static class AskBreak extends Exception {}

    public static City askCity(BaseConsole console, int id) throws AskBreak { //, java.time.ZonedDateTime creationDate

        try {
            String name;
            while (true) {
                console.print("name: ");
                name = console.readln().trim();
                if (name.equals("exit")) throw new AskBreak();
                if (!name.isEmpty()) break;
            }
            var coordinates = askCoordinates(console);
            float area = askArea(console);
            Long population = askPopulation(console);
            float metersAboveSeaLevel = askMetersAboveSeaLevel(console);
            Long carCode = askCarCode(console);
            long agglomeration = askAgglomeration(console);
            Government government = askGovernment(console);
            Human governor = askGovernor(console);
            return new City(id, name, coordinates, area, population, metersAboveSeaLevel, carCode, agglomeration, government, governor);
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }

    public static Coordinates askCoordinates(BaseConsole console) throws AskBreak {
        try {
            float x = 0;
            while (true) {
                console.print("coordinates.x: ");
                var line = console.readln().trim().toLowerCase();
                if (line.equals("exit")) throw new AskBreak();
                if (!line.equals("")) {
                    try {
                        x = Float.parseFloat(line);
                        if (x <= 273) break;
                    } catch (NumberFormatException e) {}
                }
            }
            float y;
            while (true) {
                console.print("coordinates.y: ");
                var line = console.readln().trim().toLowerCase();
                if (line.equals("exit")) throw new AskBreak();
                if (line.isEmpty()) {y = 0; break;}
                else {
                    try {y = Float.parseFloat(line); break;} catch (NumberFormatException e) {}
                }
            }
            return new Coordinates(String.valueOf(x) +';'+ String.valueOf(y));
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }

    public static Float askArea(BaseConsole console) throws AskBreak {
        try {
            float area;
            while (true) {
                console.print("Area: ");
                var line = console.readln().trim().toLowerCase();
                if (line.equals("exit")) throw new AskBreak();
                if (!line.equals("")) {
                    try {
                        area = Float.parseFloat(line);
                        if (Float.parseFloat(line) > 0) break;
                    } catch (NullPointerException | IllegalArgumentException  e) { }
                }
            }
            return area;
        } catch ( NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }

    public static Long askPopulation(BaseConsole console) throws AskBreak {
        try {
            Long population;
            while (true) {
                console.print("Population: ");
                var line = console.readln().trim().toLowerCase();
                if (line.equals("exit")) throw new AskBreak();
                if (!line.equals("")) {
                    if (Long.parseLong(line) > 0){
                        try {
                            population = Long.valueOf((line)); break;
                        } catch (NullPointerException | IllegalArgumentException  e) { }
                    }
                }
            }
            return population;
        } catch (NullPointerException | NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }

    public static Float askMetersAboveSeaLevel(BaseConsole console) throws AskBreak {
        try {
            float meters;
            while (true) {
                console.print("MetersAboveSeaLevel: ");
                var line = console.readln().trim().toLowerCase();
                if (line.equals("exit")) throw new AskBreak();
                if (line.isEmpty()) {meters = 0;}
                if (!line.equals("")) {
                    try {
                        meters = Float.parseFloat((line)); break;
                    } catch (NullPointerException | IllegalArgumentException  e) { }
                }
            }
            return meters;
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }

    public static Long askCarCode(BaseConsole console) throws AskBreak {
        try {
            Long carCode;
            while (true) {
                console.print("CarCode: ");
                var line = console.readln().trim().toLowerCase();
                if (line.equals("exit")) throw new AskBreak();
                if (!line.equals("")) {
                    try {
                        carCode = Long.valueOf(line);
                        if (Float.parseFloat(line) > 0 && Float.parseFloat(line) < 1000) break;
                    } catch (NullPointerException | IllegalArgumentException  e) { }
                }
            }
            return carCode;
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }

    public static Long askAgglomeration(BaseConsole console) throws AskBreak {
        try {
            long agglomeration;
            while (true) {
                console.print("Agglomeration: ");
                var line = console.readln().trim().toLowerCase();
                if (line.equals("exit")) throw new AskBreak();
                if (line.isEmpty()) {agglomeration = 0;}
                if (!line.equals("")) {
                    try {
                        agglomeration = Long.parseLong((line)); break;
                    } catch (NullPointerException | IllegalArgumentException  e) { }
                }
            }
            return agglomeration;
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }

    public static Government askGovernment(BaseConsole console) throws AskBreak {
        try {
            Government r;
            while (true) {
                console.print("Government ("+Government.Government() + "): ");
                var line = console.readln().trim().toUpperCase();
                if (line.equals("exit")) throw new AskBreak();
                if (!line.equals("")) {
                    try {
                        r = Government.valueOf(line); break;
                    } catch (NullPointerException | IllegalArgumentException  e) { }
                }
            }
            return r;
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }

    public static Human askGovernor(BaseConsole console) throws AskBreak {
        try {
            Double height;
            while (true) {
                console.print("Height: ");
                var line = console.readln().trim().toLowerCase();
                if (line.equals("exit")) throw new AskBreak();
                if (!line.equals("")) {
                    try {
                        height = Double.parseDouble(line);
                        if (height > 0) break;
                    } catch (NumberFormatException e) {
                    }
                }
            }
            ZonedDateTime birthday;
            while (true) {
                console.print("Time (Exemple: " +
                        ZonedDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + " or 2000-01-01): ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new AskBreak();
                if (!line.equals("")) {
                    try {
                        birthday = ZonedDateTime.now();
                        break;
                    } catch (DateTimeParseException e) {
                    }
                }
            }
            return new Human(String.valueOf(height) +';'+ String.valueOf(birthday));
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }



}