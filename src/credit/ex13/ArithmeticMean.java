package credit.ex13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Записать в двоичный файл 30 случайных чисел от 1 до 100.
 * Прочитать записанный файл распечатать числа и их среднее арифметическое.
 */

public class ArithmeticMean {

    public static void main(String[] args) throws IOException {

        List<Integer> arraylist = new ArrayList<>();
        double sum = 0;
        double result = 0;

        try (FileOutputStream fos = new FileOutputStream("file.bin");
             FileInputStream fis = new FileInputStream("file.bin")) {

            for (int i = 0; i < 30; i++) {
                fos.write((1 + (int) (Math.random() * 100)));
            }

            int i;

            while ((i = fis.read()) != -1) {
                arraylist.add(i);
                sum += i;
            }

            result = sum / 30;

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println(arraylist);
            System.out.format("Среднее арифметическое = %.2f", result);
        }
    }
}