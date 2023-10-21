package BinarySearch;

import java.util.Arrays;

public class smallestDivisorGivenThresold {
    public static void main(String[] args) {
        int[] nums = { 44,22,33,11,1 };
        System.out.println(smallestDivisor(nums, 5));
    }

    public static int sumOfD(int[] nums, int d) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += Math.ceil((double) nums[i] / (double) d);
        }
        return sum;
    }
    public static int smallestDivisor(int[] nums, int threshold) {
        int high = Arrays.stream(nums).max().getAsInt(); //maximum value in array
        int low = 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sumOfD(nums, mid) <= threshold) {   // 1 2 3. 4 5 6 7
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return low;
    }
}
