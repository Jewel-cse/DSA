
public class subArraySum {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    //maximum subarray sum:
    // 3 loop : n^3
    // 2 lop : n^2
    //optimal : kadane algorithm--> A subarray with a sum less than 0 will always
    // reduce our answer and so this type of subarray cannot be a part of the subarray with maximum sum.
    public static int maxSubArray(int[] nums) {
        int maximum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > maximum) {
                maximum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maximum;
    }
}
