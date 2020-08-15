package algo.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.misc.ASCIICaseInsensitiveComparator;

import static org.junit.jupiter.api.Assertions.*;

class PerfectSquareSumTest {

    PerfectSquareSum perfectSquareSum = new PerfectSquareSum();

    @Test
    void testPerfectSquareSum() {
        Assertions.assertEquals(perfectSquareSum.numSquares(14), 3);
        Assertions.assertEquals(perfectSquareSum.numSquares(12), 3);
        Assertions.assertEquals(perfectSquareSum.numSquares(13), 2);
        Assertions.assertEquals(perfectSquareSum.numSquares(16), 1);
        Assertions.assertEquals(perfectSquareSum.numSquares(48), 3);
        Assertions.assertEquals(perfectSquareSum.numSquares(47), 4);
        Assertions.assertEquals(perfectSquareSum.numSquares(114), 3);
    }


    @Test
    void testBreakPoints() {
        display(perfectSquareSum.getBreakPoints(0));
    }

    private void display(int[] breakPoints) {
        for (int i : breakPoints)
            System.out.println(i);
    }
}