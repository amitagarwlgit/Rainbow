package algo.arrays.slidingwindow.fastslow;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestPalindromicSubstringTest {

    LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

    @Test
    void testPalindrome() {
        String output = longestPalindromicSubstring.longestPalindrome("bababcda");
        Assertions.assertEquals(output, "bab");
    }

    @Test
    void testPalindrome2() {
        String output = longestPalindromicSubstring.longestPalindrome("cbbd");
        Assertions.assertEquals(output, "bb");
    }


}