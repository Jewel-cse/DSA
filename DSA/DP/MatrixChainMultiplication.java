package DP;

import java.util.Arrays;

// Given n matrix tell me the min operation to multiply
public class MatrixChainMultiplication {
    public static int mcm(int[] mat) {
        int n = mat.length;
        //// start will be from 1 cz, 0 theke korle partition invalid
        //return getMinOperation(1, n - 1, mat);
        // for memoization: we need 2d dp cz, there are 2 state change i and j
        int[][] dp = new int[n][n];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return getMinOperation_dp(1, n - 1, mat, dp);

    }
    //@@@ this is the only recursive solution  : tc(n*n)*n 
    private static int getMinOperation(int i, int j, int[] mat) {
        if (i == j)
            return 0;

        int mn = (int) 1e9;
        for (int k = i; k < j; k++) { // previous  of last element
            //each time k index partition and pass i to k and k+1 to j two recursive call
            int steps = mat[i - 1] * mat[k] * mat[j] + getMinOperation(i, k, mat) + getMinOperation(k + 1, j, mat);
            if (steps < mn)
                mn = steps;
        }
        return mn;
    }
    
    //@@@@@@@@@@@@ MEMOIZATION @@@@@@
    private static int getMinOperation_dp(int i, int j, int[] mat,int[][]dp) {
        if (i == j)
            return 0;
        if(dp[i][j] != -1)  return dp[i][j];
        int mn = (int) 1e9;
        for (int k = i; k < j; k++) { // previous  of last element
            //each time k index partition and pass i to k and k+1 to j two recursive call
            int steps = mat[i - 1] * mat[k] * mat[j] + getMinOperation_dp(i, k, mat,dp) + getMinOperation_dp(k + 1, j, mat,dp);
            if (steps < mn)
                mn = steps;
        }
        return dp[i][j] =  mn;
    }
    
    public static void main(String[] args) {
        
        int[] mat = { 10, 15, 20, 25 };
        int minOperation = mcm(mat);
        System.out.println( minOperation);
    }
}
