package Stack_queue.Strivers.Stack;

import java.util.Stack;
/*
 * 
 * Associated class: pair.java, mainStackLL.java
 


public class MinStack {
    Stack<pair> st;
    
    public MinStack() {
        st = new Stack<>();
    }


    //push operation
    public void push(int val) {
        int min;
        if (st.empty()) {
            min = val;
        } else {
            min = Math.min(st.peek().second, val);
        }
        st.push(new pair(val, min));
    }

    //pop operation
    public void pop() {
        st.pop();
    }
    //peek operation
    public int top() {
        return st.peek().first;
    }

    //get minimum value in the stack **********
    public int getMin() {
        return st.peek().second;
    }
}
*/
public class MinStack {

    // complexity : T = O(1) , space: o(N)


    Stack<Long> st = new Stack<>();
    Long min;

    public MinStack() {
        min = Long.MAX_VALUE;
    }

    //push the calculated vlue and tracking min
    public void push(int value) { //push calculated + min 
        Long val = Long.valueOf(value);
        ;
        if (st.empty()) {
            min = val;
            st.push(val);
        } else {
            if (val < min) {
                st.push(2 * val - min);
                min = val;
                
            } else
                st.push(val);
        }
    }
    
    // pop element
    public void pop() {  // pop + min update
        if (st.empty()) {
            return;
        }
        Long val = st.pop();
        if (val < min) {
            min = 2 * min - val;
        }

    }
    //top 
    public int top() {   // top er integer version 
        Long val = st.peek();
        if (val < min) {
            return min.intValue();
        }
        return val.intValue();
    }
    // getMin
    public int getMin() {
        return min.intValue();
    }
}
