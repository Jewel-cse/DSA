package Stack_queue;
import java.util.Stack;

public class LargestRectangleInhistogram {
    public static void main(String[] args) {
        int[] arr = { 2,1,5,6,2,3 };
        System.out.println(largestREctangleArea(arr));
    }
    //@@@ Largest ractangle Area in a histogram...................
    public static int largestREctangleArea(int[] heights) {
        int n = heights.length;
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];

        Stack<Integer> st = new Stack<>();

        //calculate leftsmaller array
        for (int i = 0; i < n; i++) {
            while (!st.empty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.empty())
                leftSmaller[i] = 0;
            else
                leftSmaller[i] = st.peek() + 1;
            st.push(i);
        }
        //stack clear 
        while (!st.empty())
            st.pop();
        //st.clear();
        //calculate rightsmaller array
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.empty())
                rightSmaller[i] = n - 1;
            else
                rightSmaller[i] = st.peek() - 1;
            st.push(i);
        }

        int maxA = 0;
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, (rightSmaller[i] - leftSmaller[i] + 1) * heights[i]);
        }
        
        return maxA;
    }
}
