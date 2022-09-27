package additional.ht2;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class HexFilterTest {

    @Test
    public void deletesHexadecimalNumbers1() {
        assertEquals("akjhsd sag asdf 0b0112 ds",
                HexFilter.hexFilter("akjhsd 0xFF sag asdf 0b0112 ds"));
    }

    @Test
    public void deletesHexadecimalNumbers2() {
        assertEquals("akjhsd sag 0b0112 ds",
                HexFilter.hexFilter("akjhsd 0xFF sag 0xF8 0b0112 ds"));
    }
}
