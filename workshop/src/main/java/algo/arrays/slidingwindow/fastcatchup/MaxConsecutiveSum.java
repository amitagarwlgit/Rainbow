package algo.arrays.slidingwindow.fastcatchup;

/* Given an integer array nums, find the contiguous subarray (containing at least one number.
 * which has the largest sum and return its sum.
 *
 * Input: [1, 2, 3, -7, 7, 2, -12, 6]
 * Output: 9
 * Explanation: [7,2] has the largest sum = 9
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 */
public class MaxConsecutiveSum {

  public int perform(int[] input) {

    int maxSum = input[0];
    int maxSumStart = 0;
    int maxSumEnd = 0;
    int currSum = input[0];
    int i = 0;
    int j = 0;

    while (j < input.length - 1) {

      if (currSum + input[j + 1] >= maxSum) {
        maxSum = currSum + input[j + 1];
        maxSumStart = i;
        maxSumEnd = j + 1;
        currSum = maxSum;
        j += 1;
        continue;
      } else {
        j += 1;
        currSum += input[j];

        // increament i to adjust the window
        while (i < j) {
          int currentIvalue = input[i];
          i = i + 1;
          currSum -= currentIvalue;

          if (currSum > maxSum) {
            maxSum = currSum;
            maxSumStart = i;
            maxSumEnd = j;
            currSum = maxSum;
            break;
          }
        }
      }
    }
    return maxSum;
  }
}
