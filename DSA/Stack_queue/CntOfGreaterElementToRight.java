package Stack_queue;

import java.util.Arrays;
import java.util.Stack;
//@@@@@@@@@incomplete
public class CntOfGreaterElementToRight {

    public static int[] countGreater(int[] arr) {
        int n = arr.length;
        int[] ger = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && st.peek() <= arr[i])
                st.pop();
            if (!st.empty()) {
                ger[i] = st.size();
            }
            st.push(arr[i]);
        }
        return ger;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countGreater(new int[]{2,3,1,5,4}))); 
    }
}
