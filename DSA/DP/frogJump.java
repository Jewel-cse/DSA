package DP;

import java.util.Arrays;


public class frogJump {
    //the minimum energy will cost to reach the nth stair......
    //have to find all possible ways
    
    //@@@@@@@@@@ recursion solution @@@@@@@@@@@  TC: 2^n  sc: o(n) auxiliary stack space
    private static int minEnergyNeed_rec(int n, int heights[]) {
        if (n == 0)
            return 0;
        int left = minEnergyNeed_rec(n - 1, heights) + Math.abs(heights[n] - heights[n - 1]);
        int right = Integer.MAX_VALUE;
        if (n > 1)
            right = minEnergyNeed_rec(n - 2, heights) + Math.abs(heights[n] - heights[n - 2]);

        return Math.min(left, right);
    }

    // We dont want to calculate overlapping sub problem ,cz previously we calculate it
    //@@@@@@@@@@@@@@@@@@@ Now DP  @@@@@@@@@@@@@@@@ TOP TO BOTTOM APPROACH ::::::::::::::
    // TC: o(n) SC: o(n) stack + o(n) array
    private static int minEnergyNeedDp(int[] heights) {
        int[] dp = new int[heights.length];
        Arrays.fill(dp, -1);
        return calculateMin(heights.length - 1, heights, dp);
    }

    private static int calculateMin(int index, int[] heights, int[] dp) {
        if (index == 0)
            return 0;

        //check previously calculate kora ase ki na?? thkle return koro
        if (dp[index] != -1) {
            //System.out.println("peyeci"+index);
            return dp[index];
        }

        //calculate kor nai , so calculate it
        int left = calculateMin(index - 1, heights, dp) + Math.abs(heights[index] - heights[index - 1]);
        int right = Integer.MAX_VALUE;
        if (index > 1)
            right = calculateMin(index - 2, heights, dp) + Math.abs(heights[index] - heights[index - 2]);
        return dp[index] = Math.min(left, right);
    }
    

    // @@@@@@@@@@@@@@@@@@       tabulaization method  @@@@ TC(o(n)),sc : o(n)
    private static int minEnergyNeed_tab(int[] heights) {
        int[] dp = new int[heights.length];
        dp[0] = 0;
        int right = Integer.MAX_VALUE;
        for (int i = 1; i < dp.length; i++) {
            int left = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            if (i > 1)
                right = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);

            dp[i] = Math.min(left, right);
        }
        return dp[dp.length - 1];
    }
    
    //Why we use the dp array : if we observed closly then we can use  3 variable 
    //tc: o(n) sp: o(1)
    private static int minEnergyNeed_tab_optimal(int[] heights) {

        int prev2 = 0;
        int prev = Math.abs(heights[1] - heights[0]);
        int cur = prev; // just for declare
        int right = Integer.MAX_VALUE;
        for (int i = 2; i < heights.length; i++) {
            int left = prev + Math.abs(heights[i] - heights[i - 1]);
            if (i > 1)
                right = prev2 + Math.abs(heights[i] - heights[i - 2]);

            cur = Math.min(left, right);

            prev2 = prev;
            prev = cur;
        }
        return cur;
    }
    






    

    
    public static void main(String[] args) {
        int[] heights = { 10, 40, 50, 20, 60};
        
        
        System.out.println(minEnergyNeed_rec(heights.length - 1, heights));
        System.out.println(minEnergyNeedDp(heights));
        System.out.println(minEnergyNeed_tab(heights));
        System.out.println(minEnergyNeed_tab_optimal(heights));
         
        
    }
}
