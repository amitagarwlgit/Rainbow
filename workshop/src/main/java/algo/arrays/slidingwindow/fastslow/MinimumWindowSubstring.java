package algo.arrays.slidingwindow.fastslow;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 */
public class MinimumWindowSubstring {

    public String perform(String input, String target) {
        int i = 0;
        int j = 0;
        int min = 0;
        int max = 0;
        int minLen = 0;
        char[] arr = input.toCharArray();

        while (i < arr.length && j < arr.length) {
            if (isConditionSatisfied(arr, i, j, target)) {
                if (j - i + 1 < minLen || minLen == 0) {
                    minLen = j - i + 1;
                    min = i;
                    max = j;
                }
                i += 1;
            } else {
                j += 1;
            }
        }
        return (minLen == 0) ? null : input.substring(min, max + 1);
    }

    private boolean isConditionSatisfied(char[] arr, int i, int j, String target) {
        char[] targets = target.toCharArray();
        for (char x : targets) {
            if (!contains(arr, i, j, x)) return false;
        }
        return true;
    }

    private boolean contains(char[] arr, int i, int j, char x) {
        for (int k = i; k <= j; k++)
            if (arr[k] == x) return true;
        return false;
    }
}
