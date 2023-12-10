package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

////@@@@@@@@@@@   incomplete   @@@@@@@@@@
public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int[]ans = new int[1];
        ans[0] = -1;
        List<Integer> ds = new ArrayList<>();
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        generate(0,nums,ds,ans,dp);
        return ans[0];
    }

    private static void generate(int ind, int[] nums, List<Integer> ds, int[] ans, int[] dp) {
        if (dp[ind] != -1) {
            System.out.print(dp[ind] + " ");
            ans[0] = Math.max(ans[0], dp[ind]);
            return;
        }
        if(ind == nums.length){
            //got a sub sequence
            //calculate length
            //update max
            System.out.println(ds.toString());
            int length = ds.size()+1;
            dp[ind] = ans[0] = Math.max(ans[0],length);
            return;
        }
        //take part
        if(ind+1<nums.length && nums[ind]<nums[ind+1]){
                ds.add(nums[ind]);
                generate(ind+1,nums,ds,ans,dp);
                ds.remove(ds.size()-1);
            }

        //non take part
        generate(ind+1,nums,ds,ans,dp);
    }
    
    //@@@@@@@@@@@@@@@   MAIN @@@@@@@@@@@@@@@@@@
    public static void main(String[] args) {
        int[] nums = { 10,9,2,5,3,7,101,45 };
        System.out.println(lengthOfLIS(nums));
    }
}
