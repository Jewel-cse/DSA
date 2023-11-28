package DP;

public class TargetSum {
    /*
     1: find total sum;
     2: if total sum < target : then not possile
     3: if toatl sum- target is odd then not possible
     4: if even send (totalsum-target)/2 to rec function
     */
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < target || (sum - target) % 2 == 1)
            return 0;
        int s2 = (sum - target) / 2;
        return findways(nums.length-1, s2, nums);
    }

    // 1 1 1 1 1   , target = 3 
    private static int findways(int ind, int target, int[] nums) {
        if (ind == 0) {
            if (target == 0 && nums[0] == 0)
                return 2;
            else if (target == 0 || target == nums[0])
                return 1;
            return 0;
        }

        int nontake = findways(ind - 1, target, nums); // non take
        int take = 0;
        if(nums[ind] <= target)
            take = findways(ind -1, target - nums[ind], nums); //take
        return take + nontake;
    }
    public static void main(String[] args) {
        int[] nums = { 1,1,1,1,1};
        int target = 3;
        int ans = findTargetSumWays(nums, target);
        System.out.println(ans);
    }
}
