import java.util.*;

public class DeleteDigits {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        if (A == null || A.length() == 0 || k == 0) {
            return A;
        } else if (k == A.length()) {
            return "0";
        }
        char[] charArray = A.toCharArray();
        Stack<Character> stack = new Stack<>();
        int i = 0;
        int popCount = 0;
        while (popCount < k && i < A.length()) {
            if (stack.empty()) {
                stack.push(charArray[i]);
                i++;
            } else if (Character.getNumericValue(charArray[i])
                >= Character.getNumericValue(stack.peek())) {
                stack.push(charArray[i]);
                i++;
            } else {
                while (popCount < k && !stack.empty() && Character.getNumericValue(charArray[i])
                    < Character.getNumericValue(stack.peek())) {
                    stack.pop();
                    popCount++;
                }
                stack.push(charArray[i]);
                i++;
            }
        }
        while (popCount < k) {
            stack.pop();
            popCount++;
        }
        while (i < A.length()) {
            stack.push(charArray[i]);
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        DeleteDigits test = new DeleteDigits();
        System.out.println(test.DeleteDigits("178542", 4));
    }
}
