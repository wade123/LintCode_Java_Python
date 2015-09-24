import java.util.*;

public class ValidParentheses {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        if (s == null) {
            return false;
        } else if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            if (stack.empty() || !match(stack.peek(), chr)) {
                stack.push(chr);
            } else {
                stack.pop();
            }
        }
        return stack.empty();
    }

    private boolean match(char a, char b) {
        if (a == '(' && b == ')' || a == '[' && b == ']' || a == '{' && b == '}') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidParentheses test = new ValidParentheses();
        System.out.println(test.isValidParentheses("[({}())]]]{[[[[[]]]]]}"));
    }
}