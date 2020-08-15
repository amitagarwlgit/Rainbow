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
    public int performRecursion(int[] arr) {
        return stealFromHouse(arr, 0);
    }

    public int performIterative(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] f = new int[nums.length];
        f[0] = nums[0];
        f[1] = Math.max(nums[0], nums[1]);

        for (int k = 2; k < nums.length; k++) {
            f[k] = Math.max(nums[k] + f[k - 2], f[k - 1]);
        }
        return f[nums.length - 1];
    }

    // Recursion
    int stealFromHouse(int[] arr, int index) {
        if (index >= arr.length) {
            return 0;
        }
        return Math.max(arr[index] + stealFromHouse(arr, index + 2), stealFromHouse(arr, index + 1));
    }
}
