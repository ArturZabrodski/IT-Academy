package exam.ex4;

import java.util.Scanner;

/**
 * Создать двумерный квадратный массив размера n. Заполнить его случайными числами таким образом:
 * числа по диагонали равны 0;
 * вверху и снизу от пересечения диагоналей находятся только положительные числа;
 * слева и справа от пересечения диагоналей находятся только отрицательные числа;
 *
 * Вывести массив на экран. Найти сумму всех элементов.
 * Найти среднее арифметическое всех элементов, которые больше суммы всех элементов.
 *
 * Пример:
 *
 * 0  4  5  5  3  8  0
 * -2  0  5  6  3  0 -4
 * -2 -8  0  6  0 -1 -2
 * -5 -9 -2  0 -9 -7 -3
 * -6 -2  0  1  0 -1 -5
 * -2  0  3  5  2  0 -8
 * 0  4  2  9  1  3  0
 *
 * Суммa всех элементов: -3
 * Cреднее арифметическое всех элементов больше -3: 1.6579
 */

public class TwoDimensionalSquareArray {

    public static void main(String[] args) {
        System.out.println("Введите размер двумерного квадратного массива: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int[][] array = new int[n][n];

        // кнопка переключатель, по ней определяем (-) или (+) число присваивать
        int buttonOnOff = -1;
        int sum = 0;
        double sumOfNumbersForArithmeticMean = 0;
        int numberOfElementsForArithmeticMean = 0;

        // присваиваем в ячейку (-1), где должен быть 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == j) || (j == n - i - 1)) {
                    array[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == -1) {
                    // для матриц где n - нечетное, на центральном нуле не переключаем
                    if (n % 2 == 1 && i == n / 2) {
                        array[i][j] = 0;
                        continue;
                    } else {
                        buttonOnOff *= -1;
                        array[i][j] = 0;
                        continue;
                    }
                }
                // присваиваем от нуля до нуля, а затем меняем знак
                if (buttonOnOff < 0) {
                    array[i][j] = -9 + (int) (Math.random() * 9);
                    sum += array[i][j];
                } else {
                    array[i][j] = 1 + (int) (Math.random() * 9);
                    sum += array[i][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.format("%4d\t", array[i][j]);
            }
            System.out.println();
        }

        System.out.format("\nСуммa всех элементов: %d \n", sum);

        // ищем элементы, которые больше суммы
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] > sum) {
                    sumOfNumbersForArithmeticMean += array[i][j];
                    numberOfElementsForArithmeticMean++;
                }
            }
        }

        if (numberOfElementsForArithmeticMean != 0) {
            System.out.format("Cреднее арифметическое всех элементов больше %d: %.4f\n",
                    sum, sumOfNumbersForArithmeticMean / numberOfElementsForArithmeticMean);
        } else {
            System.out.format("Отсутствуют элементы больше %d\n", sum);
        }
    }
}

