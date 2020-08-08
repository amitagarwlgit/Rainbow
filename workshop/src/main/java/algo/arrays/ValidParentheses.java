package algo.arrays;

import com.sun.codemodel.internal.JForEach;
import com.sun.tools.javac.util.StringUtils;

import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:
Input: "()"
Output: true

Example 2:
Input: "()[]{}"
Output: true

Example 3:
Input: "(]"
Output: false

Example 4:
Input: "([)]"
Output: false

Example 5:
Input: "{[]}"
Output: true
*/
public class ValidParentheses {
    public boolean isValid(String inputStr) {
        if (inputStr.length() == 0) return true;
        char[] strArray = inputStr.toCharArray();
        HashMap<Character, Character> paranthesis = new HashMap<>();
        paranthesis.put('(', ')');
        paranthesis.put('{', '}');
        paranthesis.put('[', ']');
        Stack<Character> stack = new Stack<>();

        for (char s : strArray) {
            if (paranthesis.keySet().contains(s)) {
                stack.push(s);
                continue;
            }
            if (stack.isEmpty() || !paranthesis.get(stack.pop()).equals(s)) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
