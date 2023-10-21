package Stack_queue;

public class sumOfSubArrRange {

    //brute force :  o(n^3)
    public static long subArrayRanges_naive(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {

            for (int j = i; j < nums.length; j++) {
                long max = Long.MIN_VALUE;
                long min = Long.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    if (nums[k] > max)
                        max = nums[k];
                    if (nums[k] < min) {
                        min = nums[k];
                    }
                }
                sum += max - min;

            }
        }
        return sum;
    }
    
    //slightly better : O(n^2)
    public static long subArrayRanges_naive_better(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {

            long max = nums[i];
            long min = nums[i];
            for (int j = i; j < nums.length; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);

                sum += (max - min);
            }
        }
        return sum;
    }
    
    //it can be solved usign stack: O(n)

    public static void main(String[] args) {
        System.out.println(subArrayRanges_naive(new int[]{1,3,3}));
    }
}
