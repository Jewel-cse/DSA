import java.util.HashMap;

public class subArraySums {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
    }
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[i];

                if (sum == k) {
                    count++;
                }
            }
        }
        return count;    
    }
}
