package credit.ex4;

import java.util.Scanner;

/**
 * Для введенного целого числа определить является ли это число простым
 */

public class PrimeNumber {

    public static void main(String[] args) {

        System.out.println("Введите число: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        sc.close();

        if (isPrimeNumber(number)) {
            System.out.format("Число %d является простым", number);
        } else {
            System.out.format("Число %d не является простым", number);
        }
    }

    public static boolean isPrimeNumber(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
