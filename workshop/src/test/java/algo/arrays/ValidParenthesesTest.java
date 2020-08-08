package algo.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidParenthesesTest {

    ValidParentheses validParentheses = new ValidParentheses();

    @Test
    void testParanthesis() {
        Assertions.assertTrue(validParentheses.isValid("()"));
    }

    @Test
    void testParanthesis2() {
        Assertions.assertTrue(validParentheses.isValid("()[]{}"));
    }


    @Test
    void testParanthesis3() {
        Assertions.assertTrue(validParentheses.isValid(""));
    }

    @Test
    void testParanthesis4() {
        Assertions.assertTrue(validParentheses.isValid("[{()}]"));
    }

    @Test
    void testParanthesis5() {
        Assertions.assertFalse(validParentheses.isValid("[{()}}"));
    }
}