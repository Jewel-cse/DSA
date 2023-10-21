package BinarySearch;
public class findPeek {
    public static void main(String[] args) {
        int[] nums = { 1, 5,1,2,1 };
        System.out.println(findPeakElement(nums));
    }
    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1 || nums[0]>nums[1])      //firt index and last index check
            return 0;
        if(nums[n-1]>nums[n-2])
            return n - 1;
        int low = 1;
        int high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) //mid is top peek
                return mid;
            else if (nums[mid] > nums[mid - 1]) //mid is uphill
                low = mid + 1;
            else
                high = mid - 1;                  //mid is down hill or down peek= move anyside  
        }
        return -1;
    }
}
