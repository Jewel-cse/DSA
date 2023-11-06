package DP;

import java.util.Arrays;

public class houseRobber {
    ///@@@@@@@@@@@ same as @@@@@@@@@@@ House Robber 1  @@@@@@@@@@@@@
    //Maximum sum of non adjacent element
    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return maxRob(nums.length - 1, nums, dp);
    }
    
    private static int maxRob(int ind, int[] nums, int[] dp) {
        if (ind == 0)
            return nums[0];
        else if (ind < 0)
            return 0;
        if (dp[ind] != -1) //already calculated
            return dp[ind];
        //calculate dp[ind]    
        int pick = nums[ind] + maxRob(ind - 2, nums, dp);
        int nonPick = maxRob(ind - 1, nums, dp);

        return dp[ind] = Math.max(pick, nonPick);
    }
    


    ///@@@@@@@@ House robber 2 @@@@@@@@@@@@@@@@@@@@
    //use maximum sum of non adjacent elements
    //space optimization code use 
    //idea of circular concept: 
    //leave 1st element and calculate max rob
    //leave last element and calculate max rob
    //max of both calculation is the anwser.
    private static int houseRob(int[] nums) {
        
        int[] tem1 = new int[nums.length - 1];
        int[] tem2 = new int[nums.length - 1];
        int l = 0, r = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i != 0)
                tem1[l++] = nums[i]; // leave first element
            if (i != nums.length-1) //leave last element
                tem2[r++] = nums[i];
        }
        //System.out.println(Arrays.toString(tem1));
        //System.out.println(Arrays.toString(tem2));
        return Math.max(maxRob_2(tem1), maxRob_2(tem2));
    }
    private static int maxRob_2(int[] nums) {
        int prev2 = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int pick = nums[i] + prev2;
            int nonPick = prev;
            int cur = Math.max(pick, nonPick);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1, 3, 5, 8, 1, 9 };
        System.out.println(rob(nums));
        System.out.println(houseRob(nums));
    }

}
