package exam.ex3;

/**
 * В городе N проезд в трамвае осуществляется по бумажным отрывным билетам.
 * Каждую неделю трамвайное депо заказывает в местной типографии рулон билетов с номерами от 000001 до 999999.
 * «Счастливым» считается билетик у которого сумма первых трёх цифр номера равна сумме последних трёх цифр,
 * как, например, в билетах с номерами 003102 или 567576.
 * Трамвайное депо решило подарить сувенир обладателю каждого счастливого билета и теперь раздумывает,
 * как много сувениров потребуется.
 * С помощью программы подсчитайте сколько счастливых билетов в одном рулоне?
 */

public class LuckyTicket {

    public static void main(String[] args) {

        // поиск с 001001 номера, т.к. до этого числа счастливых билетов нет
        System.out.format("В одном рулоне %d счастливых билетов.\n",
                searchForLuckyTickets(1001, 999999));

        System.out.format("В одном рулоне %d счастливых билетов.\n",
                searchForLuckyTickets(1, 999999));
    }

    public static int searchForLuckyTickets(int i, int n) {
        int result = 0;
        for (i = 1001; i <= n; i++) {
            int firstHalfOfTheNumber = i / 1000;
            int secondHalfOfTheNumber = i % 1000;
            if (sumOfHalfTheNumber(firstHalfOfTheNumber) == sumOfHalfTheNumber(secondHalfOfTheNumber)) {
                result++;
            }
        }
        return result;
    }

    public static int sumOfHalfTheNumber(int value) {
        int sum = 0;
        for (int count = 3; count > 0; count--) {
            sum += value % 10;
            value /= 10;
        }
        return sum;
    }
}
