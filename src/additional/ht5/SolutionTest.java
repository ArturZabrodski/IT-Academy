package additional.ht5;

import org.testng.annotations.Test;

import static additional.ht5.Solution.*;
import static org.testng.AssertJUnit.assertEquals;

public class SolutionTest {

    @Test
    public void returnsTheNumberOfLiveFish1() {
        int[] A = {3};
        int[] B = {1};
        assertEquals(1, solution(A, B));
    }

    @Test
    public void returnsTheNumberOfLiveFish2() {
        int[] A = {3, 2};
        int[] B = {1, 0};
        assertEquals(1, solution(A, B));
    }

    @Test
    public void returnsTheNumberOfLiveFish3() {
        int[] A = {3, 2};
        int[] B = {1, 1};
        assertEquals(2, solution(A, B));
    }

    @Test
    public void returnsTheNumberOfLiveFish4() {
        int[] A = {4, 3, 2, 1, 5};
        int[] B = {0, 1, 0, 0, 0};
        assertEquals(2, solution(A, B));
    }
}
