package DP;

import java.util.Arrays;

public class knapSack01 {
    //@@@@@@@@@@@@@@ recursion
    //check korbe weight ,but add korbe value...... 
    static int knapsack(int ind, int currentWt, int[] weight, int[] value) {
        if (ind == 0) {
            if (weight[0] <= currentWt) {
                return value[0];
            } else
                return 0;
        }
        int nonTakeValue = knapsack(ind - 1, currentWt, weight, value);
        int takeValue = Integer.MIN_VALUE;
        if (weight[ind] <= currentWt)
            takeValue = value[ind] + knapsack(ind - 1, currentWt - weight[ind], weight, value);

        return Math.max(nonTakeValue, takeValue);
    }
    //@@@@@@@@@@@@@ USing DP: MEMOIZATION
    private static int knapsack_dp(int n,int maxWt, int[] weight, int[] value) {
        int[][] dp = new int[n][maxWt+1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return solveKnapsackDP(n - 1, maxWt, weight, value, dp);
    }

    private static int solveKnapsackDP(int ind, int maxWt, int[] weight, int[] value, int[][] dp) {
        if (dp[ind][maxWt] != -1) {
            return dp[ind][maxWt];
        }
        //base case
        if (ind == 0) {
            if (weight[0] <= maxWt)
                return value[0];
            else
                return 0;
        }
        //pick or non pick
        int nonTakeValue = solveKnapsackDP(ind - 1, maxWt, weight, value, dp);
        int takeValue = Integer.MIN_VALUE;
        if(weight[ind]<=maxWt)
            takeValue = value[ind] + solveKnapsackDP(ind - 1, maxWt-weight[ind], weight, value, dp);
        return dp[ind][maxWt] = Math.max(nonTakeValue, takeValue);
    }
    public static void main(String[] args) {
        int[] weight = { 1, 2, 4, 5 };
        int[] value = { 5, 4, 8, 6 };
        int maxWt = 5;
        int n = weight.length;
        int maxValueWillBeThief = knapsack(n - 1, maxWt, weight, value);
        System.out.println(maxValueWillBeThief);

        System.out.println(knapsack_dp(n,maxWt, weight, value));
    }


    

}
