package additional.ht1;

/**
 * Написать функцию, которая вычисляет факториал для любого целого N с помощью цикла.
 * Юнит-тесты должны подтверждать правильность решения.
 * Optional:
 * реализовать эту же функцию, но с использованием рекурсии
 */

public class Factorial {

    public static int fact(int N) {
        if (N == 0) {
            return 1;
        }
        if (N == 1) {
            return 1;
        }
        int fact = N;

        for (int i = 1; i < N; i++) {
            fact *= (N - i);
        }
        return fact;
    }


    public static int factRec(int N) {
        if (N == 0) {
            return 1;
        }
        if (N == 1) {
            return 1;
        }
        return N * factRec(N - 1);
    }
}