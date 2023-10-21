package Stack_queue;
import java.util.LinkedList;
import java.util.Queue;

public class im_stack_using_Q {
    Queue<Integer> q = new LinkedList<>();
    
    //push in stack using queue
    void push(int val) {
        q.add(val);
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());
        }
    }

    //pop from stack
    int pop() {
        return q.remove();
    }

    //top of stack
    int top() {
        return q.peek();
    }

    //size of stack
    int size() {
        return q.size();
    }

    //display stack
    void display() {
        if (q.size() == 0) {
            return;
        } else {
            for (int i = 0; i < q.size(); i++) {
                System.out.println(((LinkedList<Integer>) q).get(i));
            }
        }
    }
}
