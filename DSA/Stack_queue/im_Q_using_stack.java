package Stack_queue;

import java.util.Stack;

public class im_Q_using_stack {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    // push into stack.......
    public void enqueue(int val) {
        input.push(val);
    }

    // pop from the first element of queue
    public int dequeue() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }

        }
        return output.pop();
    }
    // retrive the first element of queqe
    public int top() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }

        }
        return output.peek();
    }
    
}
