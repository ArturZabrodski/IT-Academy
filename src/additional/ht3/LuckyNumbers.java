package additional.ht3;

/**
 * Ticket numbers usually consist of an even number of digits.
 * A ticket number is considered lucky if the sum of the first half of the
 * digits is equal to the sum of the second half.
 * Given a ticket number n, determine if it's lucky or not.
 * <p>
 * boolean isLucky(int n)
 * <p>
 * Example
 * For n = 1230, the output should be isLucky(n) = true;
 * For n = 239017, the output should be isLucky(n) = false.
 * <p>
 * Input/Output
 * [execution time limit] 3 seconds (java)
 * [input] integer n --- A ticket number represented as a positive integer with an even number of digits.
 * Guaranteed constraints:
 * 10 ≤ n < 10E6.
 * <p>
 * [output] boolean --- true if n is a lucky ticket number, false otherwise.
 */

public class LuckyNumbers {

    public static boolean isLucky(int n) {

        boolean result = false;

        if ((numberOfDigits(n) % 2 == 0) && (n > 10) && (n < 10E6)) {
            int exp = numberOfDigits(n) / 2;
            int value = (int) Math.pow(10, exp);

            int firstHalfOfTheNumber = n / value;
            int secondHalfOfTheNumber = n % value;

            int sum1 = 0;
            int sum2 = 0;

            for (int count = exp; count > 0; count--) {
                sum1 += firstHalfOfTheNumber % 10;
                firstHalfOfTheNumber /= 10;
                sum2 += secondHalfOfTheNumber % 10;
                secondHalfOfTheNumber /= 10;
            }

            if (sum1 == sum2) {
                result = true;
            }
        }
        return result;
    }

    public static int numberOfDigits(int number) {
        return number == 0 ? 1 : (int) Math.ceil(Math.log10(Math.abs(number) + 0.5));
    }
}