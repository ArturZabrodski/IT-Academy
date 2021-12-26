package credit.ex12;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Создать файл с текстом, прочитать, подсчитать в тексте количество знаков препинания и слов.
 */

public class PunctuationAndWords {

    public static void main(String[] args) {

        List<String> arrayList;
        int countPunct;
        String str = ""; // не null

        try (FileWriter writer = new FileWriter("ex12.txt")) {

            String text =
                    "I have English on Monday, Wednesday and Thursday. English is usually the second "
                            + "lesson.\nAt the English lesson we speak, read and write. We speak about school, pupils "
                            + "and teachers,\n about lessons, animals and nature, about our friends, sports and games."
                            + "We read books and\n stories about children, nature, school life and so on. We write "
                            + "letters, words, sentences,\n exercises and dictations. We play at English, too. "
                            + "We sing songs and learn poems.\nI like English. I can read and write well, but "
                            + "I can't speak English well yet.";

            writer.write(text);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try (FileReader reader = new FileReader("ex12.txt")) {

            // читаем посимвольно
            int c;
            while ((c = reader.read()) != -1) {
                str = str.concat(String.valueOf((char) c));
            }

            // считаем количество многоточий в строке и удаляем их из строки
            countPunct = (str.length() - str.replace("...", "").length()) / 3;
            str = str.replace("...", "");

            Pattern p = Pattern.compile("[.;,:\\-?!()\"]");
            Matcher m = p.matcher(str);

            // считаем остальные знаки препинания
            while (m.find()) {
                countPunct++;
            }

            // удаляем все лишнее, оставляем только слова и один пробел между ними
            str = str.replaceAll("\\p{Punct}", " ");
            str = str.replaceAll("\\d", " ");
            str = str.replaceAll("[\\s]{2,}", " ");
            str = str.trim();

            arrayList = List.of(str.split(" "));

            System.out.println("Количество слов в тексте = " + arrayList.size());
            System.out.println("Количество знаков препинания в тексте = " + countPunct);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
