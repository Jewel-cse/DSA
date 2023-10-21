package Stack_queue;
import java.util.Stack;

public class sumOfSubArrMin {
    
    
    //Naive approach: TC(n^3):: time limit exceeded
    public static int sumSubarrayMins_naive(int[] arr) {
        final int MOD = 1000000007;
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    if (arr[k] < min) {
                        min = arr[k];
                    }
                }
                //System.out.println(min);
                sum += min;
            }
        }

        return (int) sum % MOD;
    }
    //sligntly better : O(n^2)
    public static int sumOfSubArrMins_better(int[] nums){
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            long min = nums[i];
            for (int j = i; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                sum += min;
            }
        }
        return (int)sum;
    }
    
    /* an approach here: TC : ~O(n)
    @@Step: 
    
    calculate Next smaller to left array<NSL>
    calcualte next smaller to right array<NSR>
    calculate number of left side smaller array
    calculate number of right side smaller array
    calculate Product of ls*rs
    then sum of Product and array elemnent
    
    */
    //@@@step 1:
     //@@calculate nsl array
     public static int[] NSL(int[] arr) {
        int n = arr.length;
        int[] nsl = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.peek()] >= arr[i]) //top e boro value thakle pop cz i need choto element er index
                st.pop();
            if (!st.empty()) {
                nsl[i] = st.peek();
            } else {
                nsl[i] = -1; //kono smaller element na thakle -1
            }
            st.push(i); //pust the index of array
        }
        //System.out.println(Arrays.toString(nsl));
        return nsl;
    }
    
    //@@@step 2: calculate next smaller element to right array
    public static int[] NSR(int[] arr) {
        int n = arr.length;
        int[] nsr = new int[n];

        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && arr[st.peek()] > arr[i])
                st.pop();
            if (!st.empty()) {
                nsr[i] = st.peek();
            } else {
                nsr[i] = n;
            }
            st.push(i);
        }
        //System.out.println(Arrays.toString(nsr));
        return nsr;
    }

    //@@@step 3: take input number of leftside smaller and right side smaller arry and calcualte minsum
    public static int minSum(int[] ls, int[] rs, int[] arr) {
        final long MOD = 1000000007L;
        long SumOfProduct = 0;
        long totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            SumOfProduct =(long) arr[i] * (ls[i] * rs[i]);
            totalSum = (totalSum+SumOfProduct) % MOD;
        }
        //return SumOfProduct;
        return (int)totalSum;
    }

    public static int sumSubarrayMins(int[] arr) {
        /* 
         *  nsl, nsr,ls#,rs#,prod*ar,sum  
         */
        int[] nsl = NSL(arr);
        int[] nsr = NSR(arr);
        int[] ls = new int[arr.length];
        int[] rs = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            ls[i] = i - (nsl[i]);
            rs[i] = nsr[i] - i;
        }
        //System.out.println(Arrays.toString(ls));
        //System.out.println(Arrays.toString(rs));
        return minSum(ls, rs, arr);
        
    }

    public static void main(String[] args) {
        int[] ar = { 3, 1, 2, 4 };
        //System.out.println(sumSubarrayMins(ar));
        //NSL(ar);
        //NSR(ar);
        System.out.println(sumSubarrayMins(ar));
        System.out.println(sumOfSubArrMins_better(ar));
    }
}
