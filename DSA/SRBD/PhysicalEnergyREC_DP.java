package SRBD;
/*  @@@ Problem statement: 
Initially you have H amount of energy and D distance to travel. You may travel
with any of the given 5 speeds. But you may only travel in units of 1 km. For 
each km distance traveled, you will spend corresponding amount of energy.
e.g. the given speeds are:

Cost of traveling 1 km: [4, 5, 2, 3, 6]
Time taken to travel 1 km: [200, 210, 230, 235, 215]

Find minimum time required to cover total D km with remaining H >= 0

1 <= H <= 4000
1 <= D <= 1000
Output: 
    h = 16, 17, ....-> 800
    h = 14, 15      -> 830
    h = 13          -> 860
 */

import java.util.Arrays;
import java.util.Scanner;

public class PhysicalEnergyREC_DP {
    //@@@@@@@@@@ using recursion @@@@@@@@@@@@@@@@@@@(Combination problem)
    private static int mintime_rec(int h, int d, int ind, int[] time, int[] cost) {
        if (ind < 0 || h < 0) // energy negative and not any time available 
            return (int) 1e9; //so return max
        if (d == 0) //distance 0 ,so no time requierd any more
            return 0;
        int nonPick = mintime_rec(h, d, ind - 1, time, cost);
        int pick = time[ind] + mintime_rec(h - cost[ind], d - 1, ind, time, cost);
        return Math.min(nonPick, pick);
    }

    
    //@@@@@@@  using DP @@@@@@@@@@@@@@@@@@@@@@(Top to bottom)
    private static int mintime_dp(int h, int d, int n, int[] time, int[] cost) {
        int[][][] dp = new int[h+1][d+1][n+1];
        for (int[][] arr2D : dp) {
            for (int[] arr : arr2D) {
                Arrays.fill(arr, -1);
            }
        }
        return solveDp(h, d, n-1, time, cost, dp); // n-1 send theke calculation start
    }

    private static int solveDp(int h, int d, int n, int[] time, int[] cost, int[][][] dp) {
        if (n < 0 || h < 0) // energy negative and not any time available 
            return (int) 1e9; //so return max
            if (d == 0) //distance 0 ,so no time requierd any more
            return 0;
        if (dp[h][d][n] != -1)
        return dp[h][d][n];
        int nonPick = mintime_rec(h, d, n - 1, time, cost);
        int pick = time[n] + mintime_rec(h - cost[n], d - 1, n, time, cost);
        return dp[h][d][n] = Math.min(nonPick, pick);
    }
    //@@@@@@@@@@@@@@@@ Main  @@@@@@@@@@@@@@@@@@@@
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
    
            int h = sc.nextInt();
            int d = 4; //distane will be covered
            int n = 5; //number of data
            int[] time = { 200, 210, 230, 235, 215 };
            int[] cost = { 4, 5, 2, 3, 6 };
            //-----------------------------------------
            //System.out.println("min time Needed: " + mintime_rec(h, d, n-1, time, cost));
            System.out.println("min time Needed: " + mintime_dp(h, d, n, time, cost));
        }
        sc.close();
    }
}

