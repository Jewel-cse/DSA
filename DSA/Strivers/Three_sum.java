package Strivers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_sum {
    public static void main(String[] args) {
        int[] nums = { -1, 2, 1, -4};
        /* 
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ans = threeSum(nums);
        for (List<Integer> list : ans) {
            System.out.println(list);
        
        }
        */
        System.out.println(threeSumClosest( nums, 1));
       
    }
    //two pointer approach........Leet : 15
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) // i duplicate hole skip
                continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k]; //calculate sum
                if (sum < 0) // sum baranor jonno
                    j++;
                else if (sum > 0)
                    k--; //sum komanor jonno
                else { // triplet peyechi
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(temp);

                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) // for duplicate avoid 
                        j++;
                    while (j < k && nums[k] == nums[k + 1]) // for duplicate avoid
                        k--;

                }
            }
        }
        return ans;
    }
    
    // 3 sum closest : leet - 16
    public static int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];   //just for initialize
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }

                if (sum < target)   // sum increase korte hobe
                    j++;
                else                //sum decrese korte hobe
                    k--; 
            }

        }
        return closestSum;
    }
}
