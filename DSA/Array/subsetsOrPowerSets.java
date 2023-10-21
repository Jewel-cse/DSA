import java.util.ArrayList;
import java.util.List;

public class subsetsOrPowerSets {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(subsets(nums).toString());
    }

    //bit manupulation approach...........
    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>());

        int len = nums.length;
        int n = (int) (Math.pow(2, len) - 1);
        for (int i = 1; i <= n; i++) { // near about 2^n times
            List<Integer> sublist = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) { // n times
                if ((i & (1 << j)) != 0) {
                    sublist.add(nums[j]);
                }
            }
            list.add(sublist);
        }
        return list;
    }
    
    // Recursion approach................
    public List<List<Integer>> subsetsII(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        generator(0,nums,new ArrayList<Integer>(),res);
        return res;
    }

    //generator fucntion
    public void generator(int i,int[] nums,List<Integer> ssets,List<List<Integer>> res){
        res.add(ssets);
        
        for(int j = i;j<nums.length;j++){
            ssets.add(nums[j]);            //list add
            generator(j+1,nums,ssets,res);  // generator function
            ssets.remove(ssets.size()-1);   //list remove

        }
    }
}
