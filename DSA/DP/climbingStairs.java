package DP;

import java.util.Arrays;

public class climbingStairs {
    //how may way to reach nth stairs, 1 or 2 move dite parbe
    // stair ith = stair (i-1)th + stair(i-2)th
    //tabulization 
    private static int totalwayOfreach(int n) {
        if (n <= 1)
            return 1;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    
    // @@@@@@@@@@@@        using dp memoization:  @@@@@ its like fibonacci...............
    private static int waysToreachDP(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return countways(n, dp);
    }

    private static int countways(int n, int[] dp) {
        if(n <= 1)
            return 1;
        if(dp[n] != -1)
            return dp[n];
        return dp[n] = countways(n - 1, dp) + countways(n - 2, dp);
    }
    public static void main(String[] args) {
        System.out.println(totalwayOfreach(45));
        System.out.println(waysToreachDP(45));
    }
}
