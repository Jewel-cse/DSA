package DP;

import java.util.Arrays;

public class fibonacci {
    //@@@@@@@@@@@@ find nth fibonacci  using recursion  @@@@@@@@@@@TC: 2^n ,SC: O(n) auxiliaty stack space
    // 0 1 1 2 3 5 8 13  > fibonacci
    // 0 1 2 3 4 5 6 7   > index
    static int fibo(int n) {
        if (n <= 1)
            return n;
        return fibo(n - 1) + fibo(n - 2);
    }

    //@@@@@@@@@@@@@@@@@ find nth fibonacci using DP @@@@@@@@@@@@TC(n),sc: o(n) for array + o(n)  for aux stack
    // dp use to elemenet overlapping sub problem , same computation jeno na kore
    //so we use an array to store calculated value
    static int fibonacciDp(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return fiboDp(n, dp);
    }

    static int fiboDp(int n, int[] dp) {
        if (n <= 1)
            return n;
        if (dp[n] != -1)
            return dp[n];

        return dp[n] = fiboDp(n - 1, dp) + fiboDp(n - 2, dp);
    }
    
    ///@@@@@@@@@find fibonacci using tabulaization @@@@@@@@ TC : o(n) SC: o(n)
    static int fiboTable(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    //@@@@@@@@@@@@the most optimal solution   @@@@@@@@@@TC: O(n), SC: o(1)
    //we can elemenet the array; just use extra variable

    static int fiboOptimal(int n) {
        int prev2 = 0;
        int prev = 1;
        int cur = 1;
        for (int i = 2; i <= n; i++) {
            cur = prev + prev2;
            prev2 = prev;
            prev = cur;
        }
        return cur;
    }
    
    public static void main(String[] args) {
        //System.out.println(fibo(5));
        System.out.println(fibonacciDp(7));
        System.out.println(fiboTable(7));
        System.out.println(fiboOptimal(7));
    }
}
