package credit.ex6;

/**
 * Найти максимальный и минимальные элементы массива и вывести их индексы на экран
 */

public class IndexMaxMin {

    public static void main(String[] args) {

        int[] array = {2, 3, 8, 1, 4, 9, 7, 3, 2, 8, 9, 1};
        int min = array[0];
        int max = array[0];
        int indexMin = 0;
        int indexMax = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                indexMax = i;
            }
            if (array[i] < min) {
                min = array[i];
                indexMin = i;
            }
        }

        System.out.println("indexMax = " + indexMax + "\nindexMin = " + indexMin);
    }
}
