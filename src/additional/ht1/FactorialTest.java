package additional.ht1;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class FactorialTest {

    @Test
    public void test1() {
        assertEquals(1, Factorial.fact(0));
    }

    @Test
    public void test2() {
        assertEquals(1, Factorial.factRec(1));
    }

    @Test
    public void test3() {
        assertEquals(120, Factorial.fact(5));
    }

    @Test
    public void test4() {
        assertEquals(24, Factorial.factRec(4));
    }
}
