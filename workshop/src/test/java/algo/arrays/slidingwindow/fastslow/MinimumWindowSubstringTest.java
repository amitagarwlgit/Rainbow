package algo.arrays.slidingwindow.fastslow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinimumWindowSubstringTest {

    MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();

    @Test
    void testMinWindowSubstring() {
        String output = minimumWindowSubstring.perform("ADOBECODEBANC", "ABC");
        Assertions.assertEquals(output, "BANC");

        String output2 = minimumWindowSubstring.perform("AB", "A");
        Assertions.assertEquals(output2, "A");

        String output3 = minimumWindowSubstring.perform("ADOBECODEBANC", "");
        Assertions.assertEquals(output3, null);

        String output4 = minimumWindowSubstring.perform("A", "A");
        Assertions.assertEquals(output4, "A");

        String output5 = minimumWindowSubstring.perform("A", "ABC");
        Assertions.assertEquals(output5, null);
    }

    @Test
    void testMinWindowSubstring2() {
        String output = minimumWindowSubstring.perform("AA", "AA");
        Assertions.assertEquals(output, "AA");
    }



}