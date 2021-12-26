package credit.ex3;

import java.util.Scanner;

/**
 * На некотором предприятии инженер Петров создал устройство, на табло которого показывается количество секунд,
 * оставшихся до конца рабочего дня.
 * Когда рабочий день начинается ровно в 9 часов утра — табло отображает «28800» (т.е. остаётся 8 часов),
 * когда времени 14:30 — на табло «9000» (т.е. остаётся два с половиной часа),
 * а когда наступает 17 часов — на табло отображается «0» (т.е. рабочий день закончился).
 * Программист Иванов заметил, как страдают офисные сотрудницы — им неудобно оценивать остаток рабочего дня в секундах.
 * Иванов вызвался помочь сотрудницам и написать программу, которая вместо секунд будет выводить
 * на табло понятные фразы с информацией о том, сколько полных часов осталось до конца рабочего дня.
 * Например: «осталось 7 часов», «осталось 4 часа», «остался 1 час», «осталось менее часа».
 * Итак, в переменную n должно записываться случайное (на время тестирования программы) целое число из [0;28800],
 * далее оно должно выводиться на экран (для Петрова) и на следующей строке (для сотрудниц) должна выводиться фраза
 * о количестве полных часов, содержащихся в n секундах.
 * Пример работы программы:
 * 23466
 * Осталось 6 часов
 */

public class DeviceShowingTheNumberOfSeconds {

    public static void main(String[] args) {

        while (true) {
            System.out.println("Введите целое число из интервала [0; 28800]: ");
            Scanner sc = new Scanner(System.in);
            int seconds = sc.nextInt();

            if (seconds >= 0 && seconds <= 28800) {
                System.out.println(hours(seconds));
                break;
            } else {
                System.out.println("Введено неверное число!");
            }
        }
    }

    public static String hours(int secondsTime) {
        if (secondsTime == 0) {
            return "Рабочий день закончился";
        }

        int hoursTime = secondsTime / 3600;
        String str = null;

        if (hoursTime % 10 >= 5) {
            str = "Осталось ".concat(String.valueOf(hoursTime)).concat(" часов");
        } else if (hoursTime % 10 == 1) {
            if (hoursTime % 100 == 11) {
                str = "Осталось ".concat(String.valueOf(hoursTime)).concat(" часов");
            } else {
                str = "Остался ".concat(String.valueOf(hoursTime)).concat(" час");
            }
        } else if (hoursTime % 10 >= 2 && hoursTime % 10 <= 4) {
            if (hoursTime % 100 >= 12 && hoursTime % 100 <= 14) {
                str = "Осталось ".concat(String.valueOf(hoursTime)).concat(" часов");
            } else {
                str = "Осталось ".concat(String.valueOf(hoursTime)).concat(" часа");
            }
        } else if (hoursTime % 10 == 0) {
            str = "Осталось менее часа";
        }
        return str;
    }
}