package additional.ht6;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Теперь задача на написание кода. В качестве решения понадобится внести ответ в текстовое поле и загрузить файл с
 * исходным кодом (можно zip если файлов несколько) на любом языке
 * (Баллов: 5)
 * В файле https://drive.google.com/file/d/1TNsY73GvS7xxLrQIwTCI5DVySt-dKg2r/view?usp=sharing хранятся данные заказов
 * (ID - id заказа, DATE_TIME - дата и время заказа).
 * В файле https://drive.google.com/file/d/1ewrWuP_xvBETDwCN7Ji3tLGlYxJi58Br/view?usp=sharing хранятся данные заказанных
 * позиций (ORDER_ID - id заказа, PRODUCT_ID - id товара, QUANTITY - количество товара в заказе)
 * В файле https://drive.google.com/file/d/1XghCk5iVYpjPzzC5Wa_N42iVgnC4pNms/view?usp=sharing - данные товаров
 * (ID - id товара, NAME - название товара, PRICE_PER_UNIT - цена за единицу товара).
 *
 * Необходимо, за каждый день месяца определить товар, принёсший максимальную прибыль. В качестве ответа ввести
 * NAME товара лидера за дату 2021-01-21.
 */

public class Program {
    public static void main(String[] args) {





        Map<String, LocalDateTime> map = new HashMap<>();

        String str = ""; // не null

        try (FileReader reader = new FileReader("orders.csv")) {

            int c;
            while ((c = reader.read()) != ',') {
                str = str.concat(String.valueOf((char) c));
            }

            System.out.println(str);




        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
