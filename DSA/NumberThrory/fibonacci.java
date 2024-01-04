package NumberThrory;

import java.util.Arrays;

public class fibonacci {
    public static void main(String[] args) {
        //System.out.println(fib(112));
        System.out.println(fibo2(4));
        System.out.println(fiboMemo(4));
        System.out.println(fiboConst(4));
    }


    //  ------  return the nth value of fibonacci  ----------
    
    
    //@@@@@@@@  fibonacci : o(n) time
    private static int fibo2(int n) {
        if(n == 0 || n == 1)
            return n;
        int prv = 0;
        int cur = 1;
        int ans = 0; // just for initialize
        for (int i = 2; i <= n; i++) {
            ans = prv + cur;
            prv = cur;
            cur = ans;
        }
        return ans;
    }
    
    //@@@@@@@@@  fibonacci: 2^n time  @@@@ recursion 
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    //@@@@@@ Tail recursion  @@@@ O(n),O(n) auxiliary stack space
    static int fib(int n, int a, int b ){ 
        if (n == 0)
            return a;
        if (n == 1)
            return b;
        return fib(n - 1, b, a + b);
    }

    //@@@@@@@@ using memoization: Time Complexity: O(n)  Space Complexity: O(n)
    private static int fiboMemo(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp,-1);
        return fiboDp(n, dp);
    }

    private static int fiboDp(int n, int[] dp) {
        if (n < 2)
            return n;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = fiboDp(n - 1, dp) + fiboDp(n - 2, dp);
    }
    
    /*
     * Golden ratio: ratio of two successive fibonacci number is app 1.618
     * can we calculate nth fibonacci  @@without recurtion or iteration
     * @@@YESS,Binets formula
     * Q = 1+root(5)/2
     * nth fibonacci = (Q^n - (-Q)^-n ) / root(5)
     */

    private static int fiboConst(int n){
        double Q = (1+Math.sqrt(5))/2;
        double fOfNth = (Math.pow(Q, n) - Math.pow(-Q, -n))/Math.sqrt(5);

        return (int)fOfNth;
    }
}
