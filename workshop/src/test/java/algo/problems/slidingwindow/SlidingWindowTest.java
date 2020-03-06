package algo.problems.slidingwindow;

import algo.problems.slidingwindow.fastcatchup.MaxConsecutiveSum;
import algo.problems.slidingwindow.fastlagging.HouseRobber;
import algo.problems.slidingwindow.fastslow.MinimumWindowSubstring;
import algo.problems.slidingwindow.frontback.TrappingRainWater;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SlidingWindowTest {

  // Fast, Slow
  @Test
  public void testMinimumWindowSubstring() {
    String input = "ADOBECODEBANC";
    MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
    String result = minimumWindowSubstring.perform(input);
    Assertions.assertEquals(result, "BANC");
  }

  // Fast, Lagging
  @Test
  public void testHouseRobber() {
    int[] input = {2, 7, 1, 11, 14};
    HouseRobber houseRobber = new HouseRobber();
    int result = houseRobber.perform(input);
    Assertions.assertEquals(result, 21);
  }

  // Fast, Catchup
  @Test
  public void testMaxConsecutiveSum() {
    int[] input = {1, 2, 3, -7, 7, 2, -12, 6};
    MaxConsecutiveSum maxConsecutiveSum = new MaxConsecutiveSum();
    int result = maxConsecutiveSum.perform(input);
    Assertions.assertEquals(result, 9);
  }

  // Front, Back
  @Test
  public void testTrappingRainWater() {
    int[] input = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    TrappingRainWater trappingRainWater = new TrappingRainWater();
    int result = trappingRainWater.perform(input);
    Assertions.assertEquals(result, 6);
  }
}
