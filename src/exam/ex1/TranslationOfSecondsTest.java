package exam.ex1;

import static exam.ex1.TranslationOfSeconds.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TranslationOfSecondsTest {

    @Test
    public void testCountingWeeks() {
        assertEquals("0 недель 0 суток 0 часов 0 минут 0 секунд", weeks(0));
        assertEquals("0 недель 1 сутки 6 часов 51 минута 51 секунда", weeks(111111));
        assertEquals("2 недели 4 суток 0 часов 5 минут 55 секунд", weeks(1555555));
        assertEquals("5 недель 3 суток 13 часов 55 минут 33 секунды", weeks(3333333));
        assertEquals("0 недель 2 суток 7 часов 33 минуты 20 секунд", weeks(200000));
        assertEquals("1 неделя 4 суток 13 часов 46 минут 40 секунд", weeks(1000000));
        assertEquals("8 недель 1 сутки 20 часов 53 минуты 20 секунд", weeks(5000000));
    }

    @Test
    public void testCountingDays() {
        assertEquals("0 суток 0 часов 0 минут 0 секунд", days(0));
        assertEquals("0 суток 0 часов 16 минут 41 секунда", days(1001));
        assertEquals("0 суток 2 часа 46 минут 42 секунды", days(10002));
        assertEquals("0 суток 8 часов 20 минут 3 секунды", days(30003));
        assertEquals("6 суток 10 часов 19 минут 15 секунд", days(555555));
        assertEquals("2 суток 7 часов 33 минуты 20 секунд", days(200000));
        assertEquals("11 суток 13 часов 46 минут 40 секунд", days(1000000));
    }

    @Test
    public void testCountingHours() {
        assertEquals("0 часов 0 минут 0 секунд", hours(0));
        assertEquals("1 час 55 минут 3 секунды", hours(6903));
        assertEquals("2 часа 45 минут 21 секунда", hours(9921));
        assertEquals("3 часа 17 минут 36 секунд", hours(11856));
        assertEquals("9 часов 5 минут 2 секунды", hours(32702));
        assertEquals("180 часов 15 минут 58 секунд", hours(648958));
        assertEquals("55 часов 33 минуты 20 секунд", hours(200000));
        assertEquals("277 часов 46 минут 40 секунд", hours(1000000));
    }

    @Test
    public void testCountingMinutes() {
        assertEquals("0 минут 0 секунд", minutes(0));
        assertEquals("1 минута 1 секунда", minutes(61));
        assertEquals("2 минуты 2 секунды", minutes(122));
        assertEquals("3 минуты 3 секунды", minutes(183));
        assertEquals("4 минуты 4 секунды", minutes(244));
        assertEquals("5 минут 5 секунд", minutes(305));
        assertEquals("6 минут 6 секунд", minutes(366));
        assertEquals("7 минут 7 секунд", minutes(427));
        assertEquals("8 минут 8 секунд", minutes(488));
        assertEquals("9 минут 9 секунд", minutes(549));
        assertEquals("10 минут 10 секунд", minutes(610));
        assertEquals("20 минут 49 секунд", minutes(1249));
    }

    @Test
    public void testCountingSeconds() {
        assertEquals("0 секунд", seconds(0));
        assertEquals("1 секунда", seconds(1));
        assertEquals("2 секунды", seconds(2));
        assertEquals("3 секунды", seconds(3));
        assertEquals("4 секунды", seconds(4));
        assertEquals("5 секунд", seconds(5));
        assertEquals("6 секунд", seconds(6));
        assertEquals("7 секунд", seconds(7));
        assertEquals("8 секунд", seconds(8));
        assertEquals("9 секунд", seconds(9));
    }
}
