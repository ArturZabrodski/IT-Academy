package credit.ex7;

import java.util.Arrays;

/**
 * Создать массив заполнить его случайными элементами, распечатать, перевернуть, и снова распечатать.
 * При перевороте элементов не желательно создавать еще один массив
 */

public class RotateArray {

    public static void main(String[] args) {
        int[] array = new int[10];
        array = arrayRandomNumbers(array);
        printArray(array);
        flipTheArray(array);
        printArray(array);
    }

    public static int[] arrayRandomNumbers(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 21);
        }
        return array;
    }

    public static int[] flipTheArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int tmp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
        }
        return array;
    }

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
