import Collections.HashMap;

public class Main {
    public static void main(String[] args) {
        runHashMapTest();
    }

    public static void runHashMapTest() {
        HashMap<Integer, String> daysInWeek = new HashMap<>();

        System.out.println("Добавление двух элементов с одинаковым ключем (1)");

        daysInWeek.put(1, "Понедельник");
        daysInWeek.put(1, "Вторник");

        System.out.println("Размер коллекции: " + daysInWeek.count());
        System.out.println("Значение с ключем 1: " + daysInWeek.get(1)); // Вторник
        System.out.println("Добавление элемента (0 - Понедельник)");

        daysInWeek.put(0, "Понедельник");

        System.out.println("Размер коллекции: " + daysInWeek.count());
        System.out.println("Удаление элемента с ключем 1");

        daysInWeek.remove(1);

        System.out.println("Размер коллекции: " + daysInWeek.count());
        System.out.println("Значение с ключем 0: " + daysInWeek.get(0)); // Понедельник


        System.out.println("Превысим размер бакетов (добавим оставшиеся дни недели)");
        daysInWeek.put(1, "Вторник");
        daysInWeek.put(2, "Среда");
        daysInWeek.put(3, "Четверг");
        daysInWeek.put(4, "Пятница");
        daysInWeek.put(5, "Суббота");
        daysInWeek.put(6, "Воскресенье");

        System.out.println("Размер коллекции: " + daysInWeek.count());
        for (int i = 0; i < 7; i++) {
            System.out.println(i + " - " + daysInWeek.get(i));
        }

        System.out.println("Попробуем обратиться к элементу, которого нет в коллекции (7)");
        System.out.println(daysInWeek.get(7));
    }
}