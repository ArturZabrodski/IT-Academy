package credit.ex8;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Найти в строке все знаки препинания.
 * Подсчитать общее количество их.
 */

public class PunctuationMarks {

    public static void main(String[] args) {

        System.out.println("Введите строку с текстом:");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        // считаем количество многоточий в строке и удаляем их из строки
        int count = (str.length() - str.replace("...", "").length()) / 3;
        str = str.replace("...", "");


        Pattern p = Pattern.compile("[.;,:\\-?!()\"]");
        Matcher m = p.matcher(str);

        // считаем остальные остальные знаки препинания
        while (m.find()) {
            count++;
        }

        System.out.println("Количество знаков препинания: " + count);
    }
}
