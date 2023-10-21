public class printMaximumSubArray {
    public static void main(String[] args) {
        System.out.println(maxSumSubArray(new int[]{12,-324,2,6,12,-14,4,9,10,-11,2}));
    }
    //kadane's algo to find maximum subarray sum...Modified(just print it)
    public static int maxSumSubArray(int[] num) {
        int len = num.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0 ,end = 0;
        for (int i = 0; i < len; i++) {
            if (sum == 0)                    // mark start..........
                start = i;
            sum += num[i];
            if (sum > max) {
                max = sum;
                end = i;                     // mark end.........
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        for (int i = start; i <= end; i++) {
            System.out.print(num[i]);
        }
        return max;
    }
}