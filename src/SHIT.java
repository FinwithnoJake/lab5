public class SHIT {
/*
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String UserInput = new String();
        System.out.println("Привет, давай начнем работу!");
        while (UserInput.equals("exit") != true){
            UserInput = in.nextLine().toLowerCase();
            if (UserInput.split(" ").length == 1) {
                if (UserInput.equals("help")) {
                    System.out.println("ghjk"); // Названия всех существующих функций вывести справку по доступным командам
                }

                if (UserInput.equals("info")) {
                    System.out.println(); // вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
                }

                if (UserInput == "show") {
                    System.out.println(); // вывести в стандартный поток вывода все элементы коллекции в строковом представлении
                }

                if (UserInput == "history") {
                    System.out.println(); // вывести последние 10 команд (без их аргументов)
                }
            }
            else {
                if (UserInput.split(" ")[0] == "filter_by_car_code") {
                    int ch = Integer.parseInt(UserInput.split(" ")[1]);
                    System.out.println(); // вывести элементы, значение поля carCode которых равно заданному
                }

                if (UserInput.split(" ")[0] == "filter_by_car_code") {
                    int ch = Integer.parseInt(UserInput.split(" ")[1]);
                    System.out.println(); // вывести элементы, значение поля carCode которых равно заданному
                }

                if (UserInput.split(" ")[0] == "filter_greater_than_agglomeration") {
                    int ch = Integer.parseInt(UserInput.split(" ")[1]);
                    System.out.println(); // вывести элементы, значение поля agglomeration которых больше заданного
                }
            }

        }


        System.out.println("Good job!");
    }
}
*/

/*

ZonedDateTime birthday;
            while (true) {
                console.print("Time (Exemple: " +
                        ZonedDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + " or 2000-01-01): ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new AskBreak();
                if (!line.equals("")) {
                    try {
                        birthday = ZonedDateTime.from(LocalDateTime.parse(line, DateTimeFormatter.ISO_DATE_TIME));
                        break;
                    } catch (DateTimeParseException e) {
                    }
                    try {
                        birthday = ZonedDateTime.from(LocalDateTime.parse(line + "T00:00:00.00+03:00[Europe/Moscow]", DateTimeFormatter.ISO_DATE_TIME));
                        break;
                    } catch (DateTimeParseException e) {
                    }
                }
            }
            return new Human(height, birthday);
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }

 */

}
