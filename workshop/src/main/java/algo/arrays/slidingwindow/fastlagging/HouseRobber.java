package algo.arrays.slidingwindow.fastlagging;

/*
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 *
 *  [1,2,3,1]  ==> 4 [1,3]
 *  [2,7,9,3,1]  ==> 12 [2,9,1] *
 *  [5,3,4,11,2]   ===> 16   [5,11]
 *  [5,3,4,11,8]   ===> 17   [5,4,8]
 *  [2,7,1,11,14]  ===> 21   [7,14]
 *  [2,7,31,3,4]   ===> 37    [2,31,4]
 *
 *
 */
public class HouseRobber {
  public int perform(int[] arr) {
    return stealFromHouse(arr, 0);
  }

  // Recursion
  int stealFromHouse(int[] arr, int index) {
    if (index >= arr.length) {
      return 0;
    }
    return Math.max(arr[index] + stealFromHouse(arr, index + 2), stealFromHouse(arr, index + 1));
  }
}
