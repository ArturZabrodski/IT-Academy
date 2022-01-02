package additional.ht4;

import java.util.Arrays;

/**
 * Two strings, a and b, are called anagrams if they contain all the same characters in the same frequencies.
 * For this challenge, the test is not case-sensitive.
 * For example, the anagrams of CAT are CAT, ACT, tac, TCA, aTC, and CtA.
 *
 * Function Description
 * Complete the isAnagram() function in the class called AnagramUtils:
 *
 * public static boolean isAnagram(String a, String b) {
 * // Complete the function
 * }
 * string a: the first string
 * string b: the second string
 * Returns: boolean: If a and b are case-insensitive anagrams, return true. Otherwise, return false.
 *
 * Constraints
 * Length of either a or b is not greater than 50 symbols.
 * only ASCII symbols would be used (English alphabetic characters)
 * The comparison should NOT be case sensitive
 *
 * Sample Input
 * anagram
 * margana
 *
 * Sample Output
 * true
 */

public class AnagramUtils {

    public static boolean isAnagram(String a, String b) {

        if (a.length() != b.length()) return false;

        char[] charArray1 = a.toLowerCase().toCharArray();
        char[] charArray2 = b.toLowerCase().toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        String sortedString1 = new String(charArray1);
        String sortedString2 = new String(charArray2);

        return sortedString1.equalsIgnoreCase(sortedString2);
    }
}
