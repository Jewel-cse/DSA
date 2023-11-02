package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindstandLastPosOftarget {
    //     @@@@@@@@@@@@@@@@@@@@@@@@Leatcode : 34 @@@@@@@@@@@@@@@@@@@@@
    //find the first place of occurance
    public static int firstPos(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low < 0 || low >= nums.length || nums[low] != target ? -1 : low;
    }
    //find the last place of occurance
    public static int LasttPos(int[] nums, int target){
        int low = 0;
        int high =  nums.length-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return high>=nums.length|| high < 0 || nums[high]!=target?-1:high;
    }
    //now find the range of occurance.............
    public static int[] searchRange(int[] nums, int target) {
        int f = firstPos(nums, target);
        int s = LasttPos(nums, target);
        return new int[] { f, s };
    }

    //  @@@@@@@@@@@@@@@@@@@@@@@  leetcode : 2089 @@@@@@@@@@@@@
    public static List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> ls = new ArrayList<>();
        Arrays.sort(nums);
        int i = firstPos(nums,target);
        if(i == -1)
            return ls;
        for(int k = i;k<nums.length;k++){
            if(nums[k] == target)
                ls.add(k);
            else
                break;
        }

    return ls;
    }

    public static void main(String[] args) {
        int[] nums = { 1,2,5,2,3};
        //System.out.println(firstPos(nums, 4));
        //System.out.println(LasttPos(nums, 4));

        //System.out.println(Arrays.toString(searchRange(nums, 0)));
        System.out.println(targetIndices(nums, 2).toString());
        System.out.println("hi fklsadjfksadjfklasjdfklasjkldfkasjdf");
    }
}
