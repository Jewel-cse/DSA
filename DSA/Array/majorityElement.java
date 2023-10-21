import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.html.parser.Entity;

public class majorityElement {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 5, 9, 2, 2, 2 };
        System.out.println(majority_Element(arr));
        //majority_Element(arr);
    }

    public static int majority_Element(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        
        for (int i = 0; i < nums.length; i++) {
            int val = map.getOrDefault(nums[i], 0);
            map.put(nums[i], val + 1);     // map : element -> count
        }
        
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            if (it.getValue() > (nums.length / 2)) {
                return it.getKey();
            }
        }
        return -1;
    }
}
