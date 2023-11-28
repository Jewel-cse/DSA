package DP;

import java.util.Arrays;

public class PartitionEqualSS {
    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0;i<n;i++){
            sum += nums[i];
        }
        if(sum%2 == 1)
            return false;
        //wow sum is even,send it to target function
       
        int[][] dp = new int[n][(sum / 2) + 1];
        for (int[] is : dp) {
            Arrays.fill(is,-1); 
        }

        boolean ans =  f(n-1,sum/2,nums,dp);
        return ans;
    }

    private static boolean f(int ind, int target, int[] nums, int[][] dp) {
        ///base case;
        if (ind < 0) {
            if (target == 0)
                return true;
            return false;
        }
        if (ind == 0)
            return target == nums[ind];
        //check previous calculated
        if (dp[ind][target] != -1)
            return dp[ind][target] == 1 ? true : false;
        //non calculated , so calculate it
        boolean pick = false;
        if (target >= nums[ind])
            pick = f(ind - 1, target - nums[ind], nums, dp);
        boolean nonPick = f(ind - 1, target, nums, dp);
        //insert into dp matrix
        dp[ind][target] = pick || nonPick ? 1 : 0;
        return pick || nonPick;
    }
    
    public static void main(String[] args) {
        int[] nums = { 3, 3, 3, 4, 5 };
        System.out.println(canPartition(nums));
    }
}
