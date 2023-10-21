package Strivers.Stack_queue;

import Strivers.Stack_queue.Strivers.Stack.MinStack;

public class mainStackLL {
    public static void main(String[] args) {
        
        /*
        Stack_using_LL stk = new Stack_using_LL();
        stk.push(3);
        stk.push(5);
        stk.push(7);
        stk.push(8);
        stk.push(2);
        stk.push(38);
        
        stk.pop();
        stk.pop();
        System.out.println(stk.stackSize());
        System.out.println(stk.isEmpty());
        stk.printStack();
        * 
        
        im_Q_using_stack q = new im_Q_using_stack();
        q.enqueue(0);
        q.enqueue(1);
        q.enqueue(3);
        q.enqueue(5);
        System.out.println(q.top());
        */
        
        MinStack stk = new MinStack();
        stk.push(3);
        stk.push(5);
        stk.push(-1);
        stk.push(8);
        stk.push(-18);
        stk.push(-11);
        System.out.println(stk.top());
        stk.pop();
        System.out.println(stk.getMin());
        stk.pop();
        System.out.println(stk.getMin());
    }
}
