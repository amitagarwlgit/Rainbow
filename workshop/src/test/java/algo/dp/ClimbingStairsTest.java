package algo.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClimbingStairsTest {
    private ClimbingStairs climbingStairs = new ClimbingStairs();

    @Test
    void testClimbingStairs() {
        Assertions.assertEquals(climbingStairs.climbStairs(0), 0);
        Assertions.assertEquals(climbingStairs.climbStairs(3), 3);
        Assertions.assertEquals(climbingStairs.climbStairs(5), 8);
        Assertions.assertEquals(climbingStairs.climbStairs(6), 13);
    }
}