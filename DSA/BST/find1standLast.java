package BST;

import java.util.Arrays;
import java.util.List;

public class find1standLast {
    public static void main(String[] args) {
        int[] arr = { 12, 33, 44, 55, 66, 77 };
        //System.out.println(searchRange(arr, 55).toString());
        searchRange(arr, 44);

    }
    public static int[] searchRange(int[] nums, int target) {
        int left = -1;
        int right = -1;
 
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
             int mid = (low + high)/2;
             if(nums[mid] == target){
                 left = mid ;
                 right = mid ;
                 while(nums[left] == target && left >= low)   left--;
                 while(nums[right] == target && right <= high)  right++;
                
                 System.out.println(left+" " + right);
             }
             else if(nums[mid] > target){
                 high = mid-1;
             }
             else {
                 low = mid + 1;
             }
 
        }
        return [left,right];
     }
}
