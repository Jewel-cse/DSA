import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        System.out.println(fourSum(nums, 0).toString());
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            //skip the duplicate
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            //skip the duplicate
            for (int j = i+1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;

                        //skip the duplicate
                        while (k < l && nums[k] == nums[k - 1])
                            k++;
                        while (k < l && nums[l] == nums[l + 1])
                            l--;
                    } else if (sum < target)
                        k++;
                    else
                        l--;
                }
            }
            
        }
        
        return ans;
    }
}
