import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class subsetsWithDup {
    public static void main(String[] args) {
        System.out.println(subsetsWithDuplicate(new int[] { 4,4,4,1,4}).toString());
    }

    public static List<List<Integer>> subsetsWithDuplicate(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();    //for result 
        ans.add(new ArrayList<>());
        HashSet<List<Integer>> hs = new HashSet<>();    // for uniqe 

        int n = (int) Math.pow(2, nums.length) - 1;    //length of row
        
        for (int i = 1; i <= n; i++) {
            List<Integer> ls = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {            // take num at set bits 
                    ls.add(nums[j]);
                }
            }
            hs.add(ls);                            //avoid duplicate
        }
        //ans.add(hs);
        for (List<Integer> list : hs) {
            ans.add(list);                      //convert hs to list
        }
        return ans;
        
    }
}
