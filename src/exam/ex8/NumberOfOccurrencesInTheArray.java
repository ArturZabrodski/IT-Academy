package exam.ex8;

import java.util.HashMap;
import java.util.Map;

/**
 * Напишите метод, который получает на вход массив элементов типа К (Generic) и возвращает Map<K, Integer>,
 * где K — значение из массива, а Integer — количество вхождений в массив.
 * Сигнатура метода: <K> Map<K, Integer> arrayToMap(K[] ks)
 */

public class NumberOfOccurrencesInTheArray {

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 1, 2};
        Object[] array2 = {"aaa", "bbb", "aaa", 4.5, 5, 't', 7, 't', 2, 'm', 4.5, 1, 2};

        System.out.println(arrayToMap(array1));
        System.out.println(arrayToMap(array2));
    }

    public static <K> Map<K, Integer> arrayToMap(K[] ks) {
        Map<K, Integer> hashMap = new HashMap<>(Map.of(ks[0], 1));

        for (int i = 1; i < ks.length; i++) {
            // проверяем содержит ли hashmap уже такой ключ и обновляем значение value
            if (hashMap.containsKey(ks[i])) {
                int value = hashMap.get(ks[i]);
                hashMap.replace(ks[i], ++value);
            } else {
                hashMap.put(ks[i], 1);
            }
        }
        return hashMap;
    }
}
