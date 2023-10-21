
import java.util.HashSet;

public class MakeZeroOfArray {
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{1,5,0,3,5}));
    }

    public static int minimumOperations(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >0)
                set.add(nums[i]);
        }
        return set.size();

    }
}
