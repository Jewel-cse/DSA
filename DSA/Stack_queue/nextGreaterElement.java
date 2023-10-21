package Stack_queue;

import java.util.Arrays;
import java.util.Stack;

public class nextGreaterElement {
    //given array : find the next greater element of eache element <Not circular>
    //Brute force approach: o(N^2)
    public static int[] nextGreaterElement_Naive(int[] nums1) {
        
        int n = nums1.length;
        int[] nge = new int[n];
        Arrays.fill(nge, -1);
        
        for (int i = 0; i < n - 1; i++) {          //n times
            for (int j = i + 1; j < n; j++) {      //~n times
                if (nums1[i] < nums1[j]) {
                    nge[i] = nums1[j];
                    break;
                }
            }
        }
        return nge;
    }
    
    //Using stack ...................          ???????????????Not @circular
    public static int[] nextGreaterElement_Stack(int[] nums1) {
        int n = nums1.length;
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];

        for (int i = n - 1; i >= 0; i--) {    // n times
            while (!st.empty() && st.peek() <= nums1[i]) //stack er choto value thakle pop   //less than n times
            st.pop();
            
            if (!st.empty()) {
                nge[i] = st.peek();
            } else {
                nge[i] = -1;
            }
            st.push(nums1[i]);
        }
        return nge;
    }
    
      //TC: 2n+2n  Space : n (stack)        ??????????????? @Circular................
     public static int[] nextGreaterElement_Stack_circular(int[] nums1) {
        int n = nums1.length ;
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];

        for (int i = 2*n-1; i >=0; i--) {    // 2*n times
            while (!st.empty() && st.peek() <= nums1[i%n]) //stack er choto value thakle pop   //total 2*n times
                st.pop();
            
        if (i < n) {
            if (!st.empty()) 
                nge[i] = st.peek();
            else 
                nge[i] = -1;
                
            }
        st.push(nums1[i%n]);
        }
        return nge;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement_Stack_circular(new int[]{2,3,1,5,4})));
       // System.out.println(Arrays.toString(nextGreaterElement_Stack(new int[]{2,3,1,,56,5})));
    }
}
