package DP;

import java.util.Arrays;

public class frogJumpWithKdistance {
    ////  @@@@@@@@@@@@@Jump from when k steps  @@@@@@recursion ...........
    private static int calculateMin_kths_rec(int index, int[] heights, int k) {
        if (index == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        int newVal = 0;
        for (int i = 1; i <= k; i++) {
            if (index - i >= 0) {
                newVal = calculateMin_kths_rec(index - i, heights, k) + Math.abs(heights[index] - heights[index - i]);
                min = Math.min(newVal, min);
            }
        }
        return min;
    }




    //// @@@@@@@@@@ DP memoization:  @@@@@@@@@@@@@@@@@@  TOP DOWN APPROACH
    /////////////////////////////////////////////////////  

    private static int calculateMin_kths_dp(int n, int[] heights, int k) {
        int[] dp = new int[n];     ///////step 1
        Arrays.fill(dp, -1);
        return minEnergy(n-1, heights, k, dp);
    }

    private static int minEnergy(int index, int[] heights, int k, int dp[]) {
        if (index == 0)
            return dp[0] = 0;
        if (dp[index] != -1) //step 2
            return dp[index];

        int min = Integer.MAX_VALUE;
        int newVal = 0;
        for (int i = 1; i <= k; i++) {
            if (index - i >= 0) {
                newVal = minEnergy(index - i, heights, k, dp) + Math.abs(heights[index] - heights[index - i]);
                min = Math.min(newVal, min);
            }
        }
        return dp[index] = min; //step 3  
    }
    
    //@@@@@@@@@@@@@@@ Tabulaization                      //n = length of array,  k = maximum length of jumps 
    // TC: o(n*k)  SC: o(n)
    private static int calculateMin_kths_tabu(int n, int[] heights, int k) {
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int newVal = 0;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    newVal = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    min = Math.min(newVal, min);
                }
            }
            dp[i] = min;

        }
        return dp[n - 1];
    }
    //@@@@@@@@@@@ most optimal sp: TC: o(n*k)  SC: o(k),  o(n) is not posible...
    // we have to use list to carry k last min value..... 
    //worst case sp: o(n)
    
    


    public static void main(String[] args) {
        int[] heights = { 10, 40, 50, 20, 60 };
        System.out.println(calculateMin_kths_rec(heights.length - 1, heights, 3));
        System.out.println(calculateMin_kths_dp(heights.length, heights, 3));
        System.out.println(calculateMin_kths_tabu(heights.length, heights, 3));
        
    }
}
