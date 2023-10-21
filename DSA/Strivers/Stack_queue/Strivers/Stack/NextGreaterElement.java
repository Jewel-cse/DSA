package Strivers.Stack_queue.Strivers.Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums = { 4, 12, 5, 3, 1, 2 };
        System.out.println(Arrays.toString(NGEGenerator(nums)));
    }
    
    //next greate elemnet generate function
    public static int[] NGEGenerator(int[] arr) {
        int n = arr.length;

        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.empty() && st.peek() <= arr[i % n]) {
                st.pop();
            }
            if (i < n) {
                if (!st.empty())
                    nge[i] = st.peek();
                else
                    nge[i] = -1;
            }
            st.push(arr[i % n]);
        }
        return nge;
    }
}
