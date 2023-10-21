package Strivers.Stack_queue;

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
        //System.out.println(st.peek());
        sortedStack(st);
        System.out.println(st.toString());

    }
    // store values in array : then sort array: reverse kore stack e push..........
    public static void sortedStack(Stack<Integer> st) {  //space complexitY = O(n)   time complexity: N+ nlogN+n
        int[] arr = new int[st.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = st.pop();
        }
        Arrays.sort(arr);
        for (int i = arr.length-1; i >=0; i--) {
            st.push(arr[i]);
        }
    }
}
