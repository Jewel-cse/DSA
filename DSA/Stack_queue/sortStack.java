package Stack_queue;

import java.util.Arrays;
import java.util.Stack;

public class sortStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(123);
        st.push(2983);
        st.push(76);
        st.push(78);
        st.push(678);
        st.push(6);

        System.out.println(st.toString());
       /*  //System.out.println(st.peek());
       sortedStack(st);
       System.out.println(st.toString());
       */
       //sortStackUsingStack(st);
        sortstack(st);
        System.out.println(st.toString());

    }
    // store values in array : then sort array: reverse kore stack e push..........
    public static void sortedStack(Stack<Integer> st) { //space complexitY = O(n)   time complexity: N+ nlogN+n
        int[] arr = new int[st.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = st.pop();
        }
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            st.push(arr[i]);
        }
    }
    
    //using auxiliary stack: T: o(n^2) , s:  o(n),
    private static void sortStackUsingStack(Stack<Integer> inputStack) {
        Stack<Integer> aux = new Stack<>();
        while (!inputStack.isEmpty()) {
            int temp = inputStack.pop();
            while (!aux.isEmpty() && temp > aux.peek()) {
                inputStack.push(aux.pop());
            }
            aux.push(temp);
        }
        //now place the sorted value into input stack
        while (!aux.isEmpty()) {
            inputStack.push(aux.pop());
        }
    }

    ///using recursion: O(n^2), auxiliary stack space : o(n)
    private static void sortstack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortstack(stack);
            insert(stack, temp);
        }
    }

    private static void insert(Stack<Integer> stack, int el) {
        if (stack.isEmpty() || stack.peek() <= el) {
            stack.push(el);
            return;
        }
        int temp = stack.pop();
        insert(stack, el);
        stack.push(temp);
    }
}
