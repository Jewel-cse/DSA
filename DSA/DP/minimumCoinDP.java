package DP;
import java.util.Arrays;
import java.util.Scanner;

/*
 *  Md Jewel Rana
    Problem statement: https://leetcode.com/problems/coin-change/
    step: 
    1: ind  = 0: number of coin = amount/value[0] or max
    2: non pick and next
    3: peak and stay
 */
public class minimumCoinDP {
    private static final int mx = (int) 1e9;

    // @@@@@@@@ RECURSION
    private static int findMinimum(int ind, int value, int[] nums) {
        //base case;
        if (ind == 0) {
            if (value % nums[ind] == 0) {
                return value / nums[0];
            }
            return mx;
        }
        int nonPick = findMinimum(ind - 1, value, nums);
        int pick = mx;
        if (nums[ind] <= value)
            pick = 1 + findMinimum(ind, value - nums[ind], nums);
        return Math.min(nonPick, pick);
    }

    // @@@@@@@@ DP @@@@@@@@@@@@@
    private static int findMinimum_dp(int[] nums, int value) {
        int n = nums.length;
        int[][] dp = new int[n][value + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        int min = min_dp(n - 1, value, nums, dp);
        for (int[] is : dp) {
            System.out.println(Arrays.toString(is));
        }
        return min != (int) 1e9 ? min : -1;
    }

    private static int min_dp(int ind, int value, int[] nums, int[][] dp) {
        //base case;
        if (ind == 0) {
            if (value % nums[0] == 0) {
                return value / nums[0];
            }
            return mx;
        }
        //check already calculated.............
        if (dp[ind][value] != -1)
            return dp[ind][value];
        int nonPick = min_dp(ind - 1, value, nums, dp);
        int pick = mx;
        if (nums[ind] <= value)
            pick = 1 + min_dp(ind, value - nums[ind], nums, dp);
        return dp[ind][value] = Math.min(nonPick, pick);
    }

    ///@@@@@@@@@@@ MAIN FUNCTION @@@@@@@@@@
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            // input area -------------------
            int n = sc.nextInt();
            int value = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            //------------- call function
            int minCoin = findMinimum(n - 1, value, nums);
            int minCoin2 = findMinimum_dp(nums, value);
            System.out.println(minCoin != (int) 1e9 ? minCoin : -1);
            System.out.println("DP : " + minCoin2);
        }
        sc.close();
    }

}

/*        Test Case
4
3 7
1 2 3
1 0
1
3 4
12 1 3
2 11
2 1

 */
