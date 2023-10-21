package BinarySearch;
public class findMinInRotatedArray {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{6,0}));
    }

    public static int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[low] <= nums[mid]) {     // 5 6 7. 0 1, 0 1 2 3 
                min = Math.min(min, nums[low]);
                low = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);  //7 8 0. 1 2 3 4 
                high = mid - 1;
            }
        }
        return min;
    }
    
}
