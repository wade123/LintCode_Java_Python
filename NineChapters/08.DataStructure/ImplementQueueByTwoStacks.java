import java.util.Stack;

public class ImplementQueueByTwoStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public ImplementQueueByTwoStacks() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
        stack1.push(element);
    }

    public int pop() {
        if (!stack2.empty()) {
            return stack2.pop();
        } else {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    public int top() {
        if (!stack2.empty()) {
            return stack2.peek();
        } else {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
    }

    public static void main(String[] args) {
        ImplementQueueByTwoStacks test = new ImplementQueueByTwoStacks();
        test.push(1);
        System.out.println(test.pop());
        test.push(2);
        test.push(3);
        System.out.println(test.top());
        System.out.println(test.pop());
    }
}

