import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class twoSum {
    public static void main(String[] args) {
        int[] arr = { 2, 7, 11, 15 };
        int[] ar2 = {2,3,4 };

        //System.out.println(two_Sum(arr, 9).toString());
        for (int i : _twoSum(ar2,6)) {
            System.out.println(i);
        }

    }

    public static List<Integer> two_Sum(int[] nums, int target) {
        List<Integer> ls = new ArrayList();
        HashMap<Integer, Integer> hs = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hs.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int finder = target - nums[i];
            if (hs.containsKey(finder)) {
                ls.add(i);
                ls.add(hs.get(finder));
                break;
            }
        }
        return ls;
    }
    //Leet code : 167, use: two pointer
    public static int[] _twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                ans[left - left] = left + 1;
                ans[left - left + 1] = right + 1;
                break;
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
