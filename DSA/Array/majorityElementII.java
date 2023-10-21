import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class majorityElementII {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1,2}).toString());
    }
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = nums.length;
        //frequency add in map
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Integer i : map.keySet()) {
            if (map.get(i) > (n / 3)) {
                ls.add(i);
            }
        }
        return ls;
    }
}
