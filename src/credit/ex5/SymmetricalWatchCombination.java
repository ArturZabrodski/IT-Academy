package credit.ex5;

/**
 * Электронные часы показывают время в формате от 00:00 до 23:59.
 * Подсчитать сколько раз за сутки случается так, что слева от двоеточия
 * показывается симметричная комбинация для той, что справа от двоеточия
 * (например, 02:20, 11:11 или 15:51)
 */

public class SymmetricalWatchCombination {

    public static void main(String[] args) {

        int count = 0;

        for (int h1 = 0; h1 <= 2; h1++) {
            if (h1 < 2) {
                for (int h2 = 0; h2 <= 9; h2++) {
                    for (int m1 = 0; m1 <= 5; m1++) {
                        for (int m2 = 0; m2 <= 9; m2++) {
                            if (h1 == m2 && h2 == m1) {
                                System.out.format("%d%d:%d%d\n", h1, h2, m1, m2);
                                count++;
                            }
                        }
                    }
                }
            } else {
                for (int h2 = 0; h2 <= 3; h2++) {
                    for (int m1 = 0; m1 <= 5; m1++) {
                        for (int m2 = 0; m2 <= 9; m2++) {
                            if (h1 == m2 && h2 == m1) {
                                System.out.format("%d%d:%d%d\n", h1, h2, m1, m2);
                                count++;
                            }
                        }
                    }
                }
            }
        }

        System.out.println("\nКоличество симметричных комбинаций = " + count);
    }
}