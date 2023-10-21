import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class containsDuplicate {
    public static void main(String[] args) {
        containsNearbyDuplicate(new int[] {12,23,4,56,6,12}, 3);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i]))
                map.put(nums[i], i);
            else {
                int j = map.get(nums[i]);
                if ( i != j && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}
