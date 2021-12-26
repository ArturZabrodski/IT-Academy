package exam.ex9;

import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingNumbers {

  public static void main(String[] args) throws IOException {

    String str = "";
    List<Integer> arrayList = new ArrayList<>();

    try (FileWriter writer1 = new FileWriter("in1.txt");
        FileWriter writer2 = new FileWriter("in2.txt")) {

      for (int i = 0; i < 1000; i++) {
        writer1.write((1 + (int) (Math.random() * 100000)) + " ");
        writer2.write((1 + (int) (Math.random() * 100000)) + " ");
      }

    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }

    try (FileReader reader1 = new FileReader("in1.txt");
        FileReader reader2 = new FileReader("in2.txt");
        FileWriter writer3 = new FileWriter("out.txt")) {

      int i;
      while ((i = reader1.read()) != -1) {
        str = str.concat(String.valueOf((char) i));
      }

      while ((i = reader2.read()) != -1) {
        str = str.concat(String.valueOf((char) i));
      }

      int startIndex = 0;

      for (i = 2; i <= str.length(); i++) {
        if (str.charAt(i - 1) == ' ') {
          arrayList.add(Integer.parseInt(str.substring(startIndex, i - 1)));
          startIndex = i;
        }
      }

      Collections.sort(arrayList);

      // в файл копируем строку, иначе будут записаны иероглифы
      for (Integer arr : arrayList) {
//      writer3.write(String.valueOf(arr) + " ");
        writer3.write(arr + " ");
      }

      System.out.println(arrayList);

    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
