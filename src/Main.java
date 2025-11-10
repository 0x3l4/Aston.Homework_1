import Collections.HashSet;
import Collections.ArrayList;
import Students.Book;
import Students.Student;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        runtTestHashSet();
        runTestArrayList();
        runTestStudents();
    }

    public static void runTestArrayList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Вадим");
        list.add("Ксения");
        list.add("Михаил");

        System.out.println("Количество: " + list.count());

        list.remove("Ксения");

        System.out.println(list.elementAt(0));
        System.out.println(list.elementAt(1));
        System.out.println("Количество: " + list.count());

        list.addAll(new String[]{ "Екатерина", "Александр", "Андрей" });
        System.out.println("Количество: " + list.count());
    }

    public static void runtTestHashSet() {
        HashSet<Integer> map = new HashSet<>();

        Integer[] inputValues = new Integer[] { 1, 2, 3, 5, -5 };

        System.out.println("Количество элементов: " + map.count());
        System.out.println("Заносим в массив элементы...");

        for (int i = 0; i < inputValues.length; i++) {
            System.out.println(inputValues[i] + " (+)");
            map.add(i);
        }

        System.out.println("Количество элементов: " + map.count());
        System.out.println("Пробуем добавить дубликат: ");
        System.out.println("1 (+)");
        map.add(1);

        System.out.println("Количество элементов: " + map.count());
        System.out.println("Содержится ли:");
        System.out.println("1 " + map.contains(1));
        System.out.println("2 " + map.contains(2));
        System.out.println("10 " + map.contains(10));
        System.out.println("5 " + map.contains(5));
        System.out.println("-5 " + map.contains(-5));

        System.out.println("Убираем: ");
        System.out.println("-5 (-)");
        System.out.println("120 (-)");
        map.remove(-5);
        map.remove(120);
        System.out.println("Количество элементов: " + map.count());
        System.out.println("Содержится ли:");
        System.out.println("-5 " + map.contains(-5));
        System.out.println("3 " + map.contains(3));
    }

    public static void runTestStudents() {
        java.util.ArrayList<Student> students = createStudents();

        students.stream()
                .peek(System.out::println)
                .flatMap(s -> s.getBooks().stream())
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct()
                .filter(b -> b.getYear() > 2000)
                .limit(3)
                .findFirst()
                .ifPresentOrElse(
                        b -> System.out.println("Найдена книга, год выпуска: " + b.getYear()),
                        () -> System.out.println("Подходящих книг не найдено")
                );
    }

    public static java.util.ArrayList<Student> createStudents() {
        Student aston = new Student("Астон", "Астонов", "Астонович");
        Student petrov = new Student("Василий", "Петров", "Андреевич");
        Student sidorov = new Student("Олег", "Сидоров", "Дмитриевич");
        aston.addBook(new Book(
                "Java с нуля 1",
                "Лучшая книга по Java",
                "Содержимое",
                "Андрей А.А.",
                2017,
                455
        ));

        aston.addBook(new Book(
                "Java с нуля 2",
                "Лучшая книга по Java",
                "Содержимое",
                "Андрей А.А.",
                2019,
                388
        ));

        aston.addBook(new Book(
                "Java с нуля 3",
                "Лучшая книга по Java",
                "Содержимое",
                "Андрей А.А.",
                2019,
                402
        ));

        aston.addBook(new Book(
                "Java с нуля 4",
                "Лучшая книга по Java",
                "Содержимое",
                "Андрей А.А.",
                2021,
                513
        ));

        aston.addBook(new Book(
                "Java с нуля 5",
                "Лучшая книга по Java",
                "Содержимое",
                "Андрей А.А.",
                2022,
                519
        ));

        sidorov.addBook(new Book(
                "C++ для самых маленьких 1",
                "Сделайте своего ребенка счастливым",
                "Содержимое",
                "Марк Н.Н.",
                1997,
                230
        ));

        sidorov.addBook(new Book(
                "C++ для самых маленьких 2",
                "Сделайте своего ребенка счастливым",
                "Содержимое",
                "Марк Н.Н.",
                1999,
                320
        ));

        sidorov.addBook(new Book(
                "C++ для самых маленьких 3",
                "Сделайте своего ребенка счастливым",
                "Содержимое",
                "Марк Н.Н.",
                2005,
                353
        ));

        sidorov.addBook(new Book(
                "C++ для самых маленьких 4",
                "Сделайте своего ребенка счастливым",
                "Содержимое",
                "Марк Н.Н.",
                2009,
                560
        ));

        sidorov.addBook(new Book(
                "C++ для самых маленьких 5",
                "Сделайте своего ребенка счастливым",
                "Содержимое",
                "Марк Н.Н.",
                2017,
                404
        ));

        petrov.addBook(new Book(
                "Мемология",
                "Будьте в тренде",
                "Содержимое",
                "Илон Маск",
                2030,
                153
        ));

        petrov.addBook(new Book(
                "Мемология",
                "Будьте в тренде",
                "Содержимое",
                "Илон Маск",
                2050,
                340
        ));

        petrov.addBook(new Book(
                "Мемология",
                "Будьте в тренде",
                "Содержимое",
                "Илон Маск",
                2060,
                370
        ));

        petrov.addBook(new Book(
                "Мемология",
                "Будьте в тренде",
                "Содержимое",
                "Илон Маск",
                2070,
                421
        ));

        petrov.addBook(new Book(
                "Мемология",
                "Будьте в тренде",
                "Содержимое",
                "Илон Маск",
                2077,
                1200
        ));

        java.util.ArrayList<Student> students = new java.util.ArrayList<>(3);
        students.add(aston);
        students.add(sidorov);
        students.add(petrov);

        return students;
    }
}