package credit.ex1;

import java.util.Scanner;

/**
 * Имеется прямоугольное отверстие размера a на b.
 * Определить можно ли полностью закрыть отверстие круглой картонкой радиусом r
 * Пример работы программы:
 * 6
 * 8
 * 5
 * Картонка с радиусом 5 закрывает полностью отверстие размера 6 * 8
 */

public class RectangularHole {

    public static void main(String[] args) {

        System.out.println("Введите размеры отверстия \"a\" и \"b\":");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("Введите радиус круглой картонки:");
        int r = sc.nextInt();
        sc.close();

        double c = Math.sqrt(a * a + b * b) / 2;

        if (r >= c) {
            System.out.format("Картонка с радиусом %d закрывает полностью отверстие размера %d * %d", r, a, b);
        } else {
            System.out.format("Картонка с радиусом %d не закрывает полностью отверстие размера %d * %d", r, a, b);
        }
    }
}
