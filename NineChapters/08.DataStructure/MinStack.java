import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minList;

    public MinStack() {
        stack = new Stack<>();
        minList = new Stack<>();
        minList.push(Integer.MAX_VALUE);
    }

    public void push(int number) {
        this.stack.push(number);
        if (number <= minList.peek()) {
            minList.push(number);
        }
    }

    public int pop() {
        int temp = stack.pop();
        if (temp == minList.peek()) {
            minList.pop();
        }
        return temp;
    }

    public int min() {
        return this.minList.peek();
    }

    public static void main(String[] args) {
        MinStack test = new MinStack();
        test.push(1);
        System.out.println(test.pop()); 
        test.push(2);
        test.push(3);
        System.out.println(test.min());
        test.push(1);
        System.out.println(test.min());
    }
}