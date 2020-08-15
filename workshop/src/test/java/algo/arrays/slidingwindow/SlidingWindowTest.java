package algo.arrays.slidingwindow;

import algo.arrays.slidingwindow.fastcatchup.MaxConsecutiveSum;
import algo.arrays.slidingwindow.fastlagging.HouseRobber;
import algo.arrays.slidingwindow.fastslow.MinimumWindowSubstring;
import algo.arrays.slidingwindow.frontback.TrappingRainWater;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SlidingWindowTest {

  // Fast, Lagging
  @Disabled
  @Test
  public void testHouseRobber() {
    int[] input = {5,3,4,11,2};
    HouseRobber houseRobber = new HouseRobber();
    int result = houseRobber.performIterative(input);
    int result2 = houseRobber.performRecursion(input);
    Assertions.assertEquals(result, 16);
    Assertions.assertEquals(result2, 16);
  }

  // Fast, Catchup
  @Disabled
  @Test
  public void testMaxConsecutiveSum() {
    MaxConsecutiveSum maxConsecutiveSum = new MaxConsecutiveSum();
    int[] input1 = {1, 2, 3, -7, 7, 2, -12, 6};
    int[] input2 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    Assertions.assertEquals(maxConsecutiveSum.perform(input1), 9);
    Assertions.assertEquals(maxConsecutiveSum.perform(input2), 6);
  }

  // Front, Back
  @Disabled
  @Test
  public void testTrappingRainWater() {
    int[] input = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    TrappingRainWater trappingRainWater = new TrappingRainWater();
    int result = trappingRainWater.perform(input);
    Assertions.assertEquals(result, 6);
  }
}
