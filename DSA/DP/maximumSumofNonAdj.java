package DP;

import java.util.ArrayList;
import java.util.Arrays;

public class maximumSumofNonAdj {

    /// @@@@@@@@@@@@@@@@        recursion approach  ==== 0 to n
    private static int maximumNonAdjacentSum(int n, ArrayList<Integer> nums) {
        if (n == 0)
            return nums.get(n);
        if (n < 0)
            return 0;
        int pick = nums.get(n) + maximumNonAdjacentSum(n - 2, nums);
        int nonPick = maximumNonAdjacentSum(n - 1, nums);

        return Math.max(pick, nonPick);
    }
    
    //@@@@            memoization         @@@@@@@@@@@@@@@
    private static int maximumNonAdjacentSum_memo(int n, ArrayList<Integer> nums) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return maxsum_memo(n-1, nums, dp);
    }

    private static int maxsum_memo(int n, ArrayList<Integer> nums, int[] dp) {
        if (n == 0)
            return nums.get(0);
        if (n < 0)
            return 0;
        // if pre calculated , use it
        if (dp[n] != -1)
            return dp[n];
        //other wise calculate it
        int pick = nums.get(n) + maxsum_memo(n - 2, nums, dp);
        int nonPick = maxsum_memo(n - 1, nums, dp);

        return dp[n] = Math.max(pick, nonPick);

    }
    
    ///@@@@@@@@@@@@@@@   Tabulization    
    private static int maximumNonAdjacentSum_tabu(ArrayList<Integer> nums) {
        int[] dp = new int[nums.size()];
        dp[0] = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            //pick
            int pick = nums.get(i);
            if (i - 2 >= 0)
                pick += dp[i - 2];

            //non pick
            int nonPick = dp[i - 1];

            dp[i] = Math.max(pick, nonPick);
        }
        return dp[dp.length - 1];
    }
    // @@@@@@@@@@@@@@@@@ space optimization @@@@@@@@@@@@@@@
    // @@@@@@@@ tc: O(n), space: O(1)
    private static int maximumNonAdjacentSum_spaceOp(ArrayList<Integer> nums) {
        
        //dp[index]  er jonno we need dp[index-1],dp[index-2] so we need 3 extra variable
        //dp[index] = cur
        //dp[index-1] =prev
        //dp[index-2] = prev2

        int prev = nums.get(0);
        int prev2 = 0;

        for (int i = 1; i < nums.size(); i++) {
            //pick
            int pick = nums.get(i);
            if (i - 2 >= 0)
                pick += prev2;

            //non pick
            int nonPick = prev;

            int cur = Math.max(pick, nonPick);

            // asgin series
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
    
    
    
    
    ///////////// @@@@@@@@@@@ main function
    public static void main(String[] args) {
        //int[] nums = { 1, 2, 3, 5, 4 };
        int[] nums = { 1, 2, 3, 1, 3, 5, 8, 1, 9 };
        ArrayList<Integer> ls = new ArrayList<>();
        for (int i : nums) {
            ls.add(i);
        }
        System.out.println(maximumNonAdjacentSum(ls.size()-1, ls));
        System.out.println(maximumNonAdjacentSum_memo(ls.size(), ls));
        System.out.println(maximumNonAdjacentSum_tabu(ls));
        System.out.println(maximumNonAdjacentSum_spaceOp(ls));
       
    }
}
