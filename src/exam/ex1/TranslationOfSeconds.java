package exam.ex1;

/**
 * Напишите программу, которая будет переводить секунды в форматированный вид - часы минуты секунды
 * Примеры:
 * 1249
 * 20 минут 49 секунд
 * 648958
 * 180 часов 15 минут 58 секунд
 */

public class TranslationOfSeconds {

    public static String weeks(int secondsTime) {
        int weeksTime = secondsTime / 3600 / 24 / 7;
        secondsTime = secondsTime - weeksTime * (3600 * 24 * 7);
        String str = null;
        if (weeksTime % 10 == 0 || weeksTime % 10 >= 5) {
            str = String.valueOf(weeksTime).concat(" недель ").concat(days(secondsTime));
        } else if (weeksTime % 10 == 1) {
            if (weeksTime % 100 == 11) {
                str = String.valueOf(weeksTime).concat(" недель ").concat(days(secondsTime));
            } else {
                str = String.valueOf(weeksTime).concat(" неделя ").concat(days(secondsTime));
            }
        } else if (weeksTime % 10 >= 2 && weeksTime % 10 <= 4) {
            str = String.valueOf(weeksTime).concat(" недели ").concat(days(secondsTime));
        }
        return str;
    }

    public static String days(int secondsTime) {
        int daysTime = secondsTime / 3600 / 24;
        secondsTime = secondsTime - daysTime * (3600 * 24);
        String str = null;
        if (daysTime % 10 == 0 || daysTime % 10 >= 2) {
            str = String.valueOf(daysTime).concat(" суток ").concat(hours(secondsTime));
        } else if (daysTime % 10 == 1) {
            if (daysTime % 100 == 11) {
                str = String.valueOf(daysTime).concat(" суток ").concat(hours(secondsTime));
            } else {
                str = String.valueOf(daysTime).concat(" сутки ").concat(hours(secondsTime));
            }
        }
        return str;
    }

    public static String hours(int secondsTime) {
        int hoursTime = secondsTime / 3600;
        secondsTime = secondsTime - hoursTime * 3600;
        String str = null;
        if (hoursTime % 10 == 0 || hoursTime % 10 >= 5) {
            str = String.valueOf(hoursTime).concat(" часов ").concat(minutes(secondsTime));
        } else if (hoursTime % 10 == 1) {
            if (hoursTime % 100 == 11) {
                str = String.valueOf(hoursTime).concat(" часов ").concat(minutes(secondsTime));
            } else {
                str = String.valueOf(hoursTime).concat(" час ").concat(minutes(secondsTime));
            }
        } else if (hoursTime % 10 >= 2 && hoursTime % 10 <= 4) {
            if (hoursTime % 100 >= 12 && hoursTime % 100 <= 14) {
                str = String.valueOf(hoursTime).concat(" часов ").concat(minutes(secondsTime));
            } else {
                str = String.valueOf(hoursTime).concat(" часа ").concat(minutes(secondsTime));
            }
        }
        return str;
    }

    public static String minutes(int secondsTime) {
        int minutesTime = secondsTime / 60;
        secondsTime = secondsTime - minutesTime * 60;
        String str = null;
        if (minutesTime % 10 == 0 || minutesTime % 10 >= 5) {
            str = String.valueOf(minutesTime).concat(" минут ").concat(seconds(secondsTime));
        } else if (minutesTime % 10 == 1) {
            if (minutesTime % 100 == 11) {
                str = String.valueOf(minutesTime).concat(" минут ").concat(seconds(secondsTime));
            } else {
                str = String.valueOf(minutesTime).concat(" минута ").concat(seconds(secondsTime));
            }
        } else if (minutesTime % 10 >= 2 && minutesTime % 10 <= 4) {
            str = String.valueOf(minutesTime).concat(" минуты ").concat(seconds(secondsTime));
        }
        return str;
    }

    public static String seconds(int secondsTime) {
        String str = null;
        if (secondsTime % 10 == 0 || secondsTime % 10 >= 5) {
            str = String.valueOf(secondsTime).concat(" секунд");
        } else if (secondsTime % 10 == 1) {
            if (secondsTime % 100 == 11) {
                str = String.valueOf(secondsTime).concat(" секунд");
            } else {
                str = String.valueOf(secondsTime).concat(" секунда");
            }
        } else if (secondsTime % 10 >= 2 && secondsTime % 10 <= 4) {
            str = String.valueOf(secondsTime).concat(" секунды");
        }
        return str;
    }
}