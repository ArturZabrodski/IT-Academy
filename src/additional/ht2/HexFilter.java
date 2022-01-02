package additional.ht2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Напишите метод, выполняющий удаление в строке шестнадцатеричных чисел,
 * записанных по правилам Java, с помощью регулярных выражений
 * Правильность работы метода должна быть подтверждена юнит тестами.
 * Пример:
 * Для входной строки "akjhsd 0xFF sag asdf 0b0112 ds"
 * должно выводится "akjhsd sag asdf 0b0112 ds"
 */

public class HexFilter {

    public static String hexFilter(String line) {

        String pattern = " 0[xX][\\da-fA-F]+";
        Pattern p = Pattern.compile(pattern);

        Matcher m = p.matcher(line);
        String str = line;

        while (m.find()) {
            str = str.replaceAll(m.group(), "");
        }
        return str;
    }
}


