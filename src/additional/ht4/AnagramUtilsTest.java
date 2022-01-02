package additional.ht4;

import org.junit.Test;

import static additional.ht4.AnagramUtils.*;
import static org.junit.Assert.*;

public class AnagramUtilsTest {

    @Test
    public void returnsBooleanIfStringsAreAnagrams1() {
        String input1 = "hEoLl";
        String input2 = "eHllo";
        assertTrue(isAnagram(input1, input2));
    }

    @Test
    public void returnsBooleanIfStringsAreAnagrams2() {
        String input1 = "anagram";
        String input2 = "margana";
        assertTrue(isAnagram(input1, input2));
    }

    @Test
    public void returnsBooleanIfStringsAreAnagrams3() {
        String input1 = "anagramm";
        String input2 = "marganaa";
        assertFalse(isAnagram(input1, input2));
    }

    @Test
    public void returnsBooleanIfStringsAreAnagrams4() {
        String input1 = "Hello";
        String input2 = "hello";
        assertTrue(isAnagram(input1, input2));
    }

    @Test
    public void returnsBooleanIfStringsAreAnagrams5() {
        String input1 = "Hello world";
        String input2 = "hello WORLD";
        assertTrue(isAnagram(input1, input2));
    }

    @Test
    public void returnsBooleanIfStringsAreAnagrams6() {
        String input1 = "Hello world";
        String input2 = "hello";
        assertFalse(isAnagram(input1, input2));
    }
}
