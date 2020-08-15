package algo.dp;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * <p>
 * Example 1:
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * <p>
 * Example 2:
 * Input: n = 13
 * Output: 2    `
 * Explanation: 13 = 4 + 9.
 */
public class PerfectSquareSum {

    private Map<Integer, Integer> memo = new HashMap<>();

    public int numSquares(int n) {
        if (n < 4) {
            memo.put(n, n);
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int[] breakPoints = getBreakPoints(n);
        int len = breakPoints.length;
        HashMap<Integer, Integer> sumLengths = new HashMap<>();
        for (int j = 2; j <= len - 1; j++) {
            sumLengths.put(breakPoints[j], 1 + numSquares(n - breakPoints[j]));
        }
        memo.put(n, Collections.min(sumLengths.values()));
        return memo.get(n);
    }

    public int[] getBreakPoints(int n) {
        int[] breakPoints = new int[(int) Math.floor(Math.sqrt(n)) + 1];
        for (int i = 0; i * i <= n; i++) {
            breakPoints[i] = i * i;
        }
        return breakPoints;
    }
}