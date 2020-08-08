package algo.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidParenthesesTest {

    ValidParentheses validParentheses = new ValidParentheses();

    @Test
    void testParanthesis() {
        Assertions.assertTrue(validParentheses.isValid("()"));
    }
}