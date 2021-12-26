package exam.ex7;

/**
 * Реализовать класс Pair, который будет создержать 2 значения любого типа.
 * Класс умеет выводить:
 * first() - возвращает 1ый элемент
 * last() - возвращает 2ой элемент
 * swap() - меняет элементы местами
 * replaceFirst() - заменяет 1ый элемент на новый
 * replaceLast() - заменяет 2ой элемент на новый
 */

public class PairMain {

    public static void main(String[] args) {
        Pair<String, Integer> car1 = new Pair<>("Text", 123);

        System.out.println("\nFirst value: " + car1.first());
        System.out.println("Last value: " + car1.last() + "\n");

        Pair car2 = car1.replaceFirst(456).replaceLast('A');

        System.out.println("First value: " + car2.first());
        System.out.println("Last value: " + car2.last() + "\n");

        Pair car3 = car2.swap();

        System.out.println("First value: " + car3.first());
        System.out.println("Last value: " + car3.last());
    }
}
