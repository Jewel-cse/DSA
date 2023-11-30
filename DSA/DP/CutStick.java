package DP;

import java.util.Arrays;

public class CutStick {

    static int[][] dp;
    static int newCuts[];
    ///@@@@@@@@@@@@@@@  RECURSIVE SOLUTION @@@@@@@@@@@@@@
    /*
        : right - left = 1 > no cuts return 0
        : mid(left+1 to right-1)
        : pass (left,mid) and (mid,right) and add new cost[right] - cost[left]
        : select min
    */

    private static int cost(int left, int right) {
        if (right - left == 1)
            return 0;
        int ans = Integer.MAX_VALUE;
        for (int mid = left + 1; mid < right; mid++) {
            int cost = cost(left, mid) + cost(mid, right) + (newCuts[right] - newCuts[left]);
            ans = Math.min(ans, cost);
        }
        return ans;
    }

    /*
        :new array niye copy korbo 1st index 0 last index n= inital length
        :sort the array
        :pass 0 and last index of new array
        */
    public static int minCost(int n, int[] cuts) {
        int m = cuts.length;
        newCuts = new int[m + 2];
        System.arraycopy(cuts, 0, newCuts, 1, m);
        newCuts[m + 1] = n;
        Arrays.sort(newCuts);
        //System.out.println(Arrays.toString(newCuts));
        return cost(0, newCuts.length - 1);
    }
    //@@@@@@@@@ MEMOIZATION @@@@@@@@@@@@@@@
    public static int mincostDp(int n, int[] cuts) {
        int m = cuts.length;
        newCuts = new int[m + 2];
        System.arraycopy(cuts, 0, newCuts, 1, m);
        newCuts[newCuts.length - 1] = n;
        Arrays.sort(newCuts);

        //create dp array
        dp = new int[m + 2][m + 2];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return costDP(0, newCuts.length - 1);
    }

    private static int costDP(int left, int right) {
        if (right - left == 1)
            return 0;
        //check
        if (dp[left][right] != -1)
            return dp[left][right];
        int ans = Integer.MAX_VALUE;
        for (int mid = left + 1; mid < right; mid++) {
            int cost = costDP(left, mid) + costDP(mid, right) + (newCuts[right] - newCuts[left]);
            if (cost < ans)
                ans = cost;
        }
        return dp[left][right] = ans;
    }

    //@@@@@@@@@@@@ main function 
    public static void main(String[] args) {
        int[] cuts = { 1, 3, 4, 5 };
        System.out.println(minCost(7, cuts));
        System.out.println(mincostDp(7, cuts));
    }
}


