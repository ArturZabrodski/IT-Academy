package credit.ex2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Напишите программу расчета даты следующего дня введя 3 числа - день месяц и год
 * Пример работы программы:
 * 15
 * 3
 * 2000
 * 16 3 2000
 */

public class DateOfTheNextDay {

    public static void main(String[] args) {

        System.out.println("Введите день месяц и год:");
        Scanner sc = new Scanner(System.in);
        int day = sc.nextInt();
        int month = sc.nextInt();
        int year = sc.nextInt();
        sc.close();

        LocalDate date = LocalDate.of(year, month, day).plusDays(1);
        String format = date.format(DateTimeFormatter.ofPattern("dd MM yyyy"));

        System.out.println(format);
    }
}