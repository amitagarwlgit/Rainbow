package algo.arrays.slidingwindow.fastslow;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        char[] input = s.toCharArray();
        int left = 0;
        int right = 0;
        int i = 0;
        int j = 0;
        while (i < input.length && j < input.length) {
            if (isPalindrome(input, i, j)) {
                // shift i
                if (j - i + 1 > right - left + 1) {
                    right = j;
                    left = i;
                }
                i += 1;
            } else {
                // shift j
                j += 1;
            }
        }
        return s.substring(left, right + 1);
    }

    public boolean isPalindrome(char[] arr, int p, int q) {
        if (q == 0) return false;
        while (p < q) {
            if (arr[p] != arr[q]) return false;
            p++;
            q--;
        }
        return true;
    }
}
