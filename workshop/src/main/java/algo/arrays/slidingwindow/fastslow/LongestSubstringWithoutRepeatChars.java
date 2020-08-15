package algo.arrays.slidingwindow.fastslow;

import com.sun.xml.internal.fastinfoset.util.CharArray;
import org.apache.logging.log4j.util.Chars;

/*Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatChars {

    public int lengthOfLongestSubstring(String inputStr) {
        if (inputStr.length() == 0) return 0;
        char[] arr = inputStr.toCharArray();
        int min = 0;
        int max = 0;
        int i = 0;
        int j = 1;

        while (i < arr.length - 1 && j < arr.length) {
            if (ifAlreadyExist(arr, i, j)) {
                i += 1;
            } else {
                if (j - i + 1 > max - min + 1) {
                    min = i;
                    max = j;
                }
                j += 1;
            }
        }
        return inputStr.substring(min, max + 1).length();
    }

    private boolean ifAlreadyExist(char[] arr, int i, int j) {
        for (int k = i; k < j; k++) {
            if (arr[k] == arr[j]) return true;
        }
        return false;
    }
}
