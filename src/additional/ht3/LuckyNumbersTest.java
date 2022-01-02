package additional.ht3;

import org.junit.Test;

import static additional.ht3.LuckyNumbers.*;
import static org.junit.Assert.assertEquals;

public class LuckyNumbersTest {

    @Test
    public void lookingForLuckyTicket1() {
        assertEquals(true, isLucky(1230));
    }

    @Test
    public void lookingForLuckyTicket2() {
        assertEquals(false, isLucky(239017));
    }

    // will be false because there is an odd number of digits.
    @Test
    public void lookingForLuckyTicket3() {
        assertEquals(false, isLucky(11111));
    }

    @Test
    public void lookingForLuckyTicket4() {
        assertEquals(true, isLucky(2002));
    }

    // will be false, because > 10E6
    @Test
    public void lookingForLuckyTicket5() {
        assertEquals(false, isLucky(20097301));
    }
}