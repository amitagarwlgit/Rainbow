package algo.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {

    @Test
    void longestCommonPrefix() {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        Assertions.assertEquals(longestCommonPrefix.longestCommonPrefix(new String[]{"c", "c"}), "c");

        //Assertions.assertEquals(longestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"}), "fl");
        //Assertions.assertEquals(longestCommonPrefix.longestCommonPrefix(new String[]{"dog", "racecar", "car"}), "");
    }
}