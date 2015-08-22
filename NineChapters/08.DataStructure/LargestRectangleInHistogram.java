import java.util.Stack;
import java.util.Arrays;

public class LargestRectangleInHistogram {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int[] heightCopy = new int[height.length + 1];
        heightCopy = Arrays.copyOf(height, height.length + 1);
        int maxArea = 0;
        int i = 0;
        while (i < heightCopy.length) {
            if (stack.empty() || heightCopy[i] >= heightCopy[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int top = stack.pop();
                maxArea = Math.max(maxArea,
                    heightCopy[top] * (stack.empty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram test = new LargestRectangleInHistogram();
        int[] height = {2, 1, 5, 6, 2, 3};
        System.out.println(test.largestRectangleArea(height));
    }
}

