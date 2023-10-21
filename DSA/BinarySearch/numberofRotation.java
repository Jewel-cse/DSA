package BinarySearch;
public class numberofRotation {
    public static void main(String[] args) {
        System.out.println(rotationNumber(new int[] { 8, 0, 1, 3, 4, 5 }));
    }

    //idea: find min in ratated array just track the index.
    public static int rotationNumber(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int index = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[low] <= nums[mid]) {
                if(nums[low]<nums[index])   //
                    index = low;
                low = mid + 1;
            } else {
                if(nums[mid]<nums[index])  //
                    index = mid;
                high = mid - 1;
            }
        }
        return index;
    }
}
