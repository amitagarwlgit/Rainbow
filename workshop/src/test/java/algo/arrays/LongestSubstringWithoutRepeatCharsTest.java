package algo.arrays;

import algo.arrays.slidingwindow.fastslow.LongestSubstringWithoutRepeatChars;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestSubstringWithoutRepeatCharsTest {

    private LongestSubstringWithoutRepeatChars longSubstring =
            new LongestSubstringWithoutRepeatChars();

    @Test
    void testLongString1() {
        Assertions.assertEquals(longSubstring.lengthOfLongestSubstring("abcabcbb"), 3);
        Assertions.assertEquals(longSubstring.lengthOfLongestSubstring("bbbbbb"), 1);
        Assertions.assertEquals(longSubstring.lengthOfLongestSubstring("pwwkettt"), 4);
    }
}