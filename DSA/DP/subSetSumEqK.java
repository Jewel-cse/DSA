package DP;

import java.util.Arrays;

public class subSetSumEqK {

    // @@@@@@@@@@@@ recursion @@@@@@@@@@@@@@
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    public static boolean subsetSumToK_rec(int index, int target, int arr[]) {
        //base case
        if (target == 0) {
            return true;
        }
        if (index == 0) {
            return target == arr[index];
        }
        boolean take = false;
        if (target >= arr[index])
            take = subsetSumToK_rec(index - 1, target - arr[index], arr);
        boolean nonTake = subsetSumToK_rec(index - 1, target, arr);

        return take || nonTake;
    }
    
    //@@@@@@@@@@@@ Memoization @@@@@@@@@@@@@@
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    public static boolean subsetSumToK_dp(int n, int target, int arr[]) {
        int[][] dp = new int[n][target+1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return subset_dp(n - 1, target, arr, dp) ;
    }

    public static boolean subset_dp(int index, int target, int arr[], int[][] dp) {
        if (dp[index][target] != -1)
            return dp[index][target] == 1?true:false;
        //base case
        if (target == 0) {
            return  true;
        }
        if (index == 0) {
            return target == arr[0];
        }
        
        //take
        boolean take = false;
        if (target >= arr[index])
            take = subset_dp(index - 1, target - arr[index], arr, dp);
        // non take 
        boolean nonTake = subset_dp(index - 1, target, arr, dp);

        //store dp
        dp[index][target] = (take || nonTake) ? 1 : 0;

        //return 
        return take || nonTake;
    }



    
    
    public static void main(String[] args) {
        int[] nums = {6,1,2,1};
/*
 4
 4 5 // true
 4 3 2 1
 5 4 //false
 2 5 1 6 7
 4 4 // true
 6 1 2 1
 5 6  // false
 1 7 2 9 10
 */
        System.out.println(subsetSumToK_dp(nums.length, 4, nums));
    }
}
