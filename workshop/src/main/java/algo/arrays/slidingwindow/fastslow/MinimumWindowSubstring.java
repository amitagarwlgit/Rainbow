package algo.arrays.slidingwindow.fastslow;

import java.util.HashMap;

/*
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 */
public class MinimumWindowSubstring {

  public String perform(String input) {
    String target = "ABC";

    HashMap<Character, Boolean> targetMap = new HashMap<Character, Boolean>();

    for (char t : target.toCharArray()) {
      targetMap.putIfAbsent(t, false);
    }

    int i = 0;
    int j = 0;
    char[] inputChars = input.toCharArray();
    int foundStringLength = 0;
    int targetSize  = targetMap.size();

    while (foundStringLength < targetSize)


    for (int k=0; k < inputChars.length; k++) {
        if (targetMap.containsKey(inputChars[k])) {
            foundStringLength++;
        }



    }

    return input;
  }

  private void expand() {}

  private void shrink() {}
}
