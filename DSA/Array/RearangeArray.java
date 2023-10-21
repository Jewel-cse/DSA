import java.util.Arrays;

public class RearangeArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rearrangeArray(new int[] { -1,1 })));
    }
    
    public static int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int odd = 1;
        int even = 0;
        for (int i = 0; i < res.length; i++) {
            if (nums[i] > 0) {
                res[even] = nums[i];
                even += 2;
            } else {
                res[odd] = nums[i];
                odd += 2;
            }
        }
        return res;
    }
}
