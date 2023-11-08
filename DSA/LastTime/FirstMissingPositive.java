import java.util.Arrays;
import java.util.HashSet;

class FirstMissingPositive {

    //@@@@@@@@@@@@@  First missing positive numver in array @@@@@@@@@@
    // Missing positive number is in range: 1 to len(arr)+1
    /*
     *  approach 1: sort the array and find
     *  approach 2: use hashset then find 1 to len(a)+1
     *  approach 3: 
     */

    //@@@@@@@@@@@@@ sorted @@@@@@@@@@@@@@@@
     //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
     public static int firstMissingPositive_sorted(int[] nums) {
         Arrays.sort(nums);
         int i = 0;
         int missingNumber = 1;
         while (i < nums.length) {
             if (nums[i] <= 0)
                 i++;
             else if (nums[i] == missingNumber) {
                 missingNumber++;
                 i++;
             } else if (i - 1 >= 0 && nums[i] != nums[i - 1] && nums[i] != missingNumber) {
                 break;
             } else
                 i++;

         }
         return missingNumber;
     }
     
     //@@@@@@@@@@@  Hahsset @@@@@@@@@@@@@@@
     //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
     public static int firstMissingPositive_hashset(int[] nums) {
         HashSet<Integer> hs = new HashSet<>();
         for (int i = 0; i < nums.length; i++) {
             if (nums[i] > 0) {
                 hs.add(nums[i]);
             }
         }
         //missing number should be 1 to len(arr)+1
         int i = 1;
         for (i = 1; i < nums.length + 1; i++) {
             if (!hs.contains(i)) {
                 return i;
             }
         }
         return i;
     }
     
     //@@@@@@@@@@@ Optimal @@@@@@@@@@@@@@@@
     //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    public static int firstMissingPositive_op(int[] nums) {
        
        // map (index+1) -> value 
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correct]) {
                //swap correct and i position value
                int tem = nums[i];
                nums[i] = nums[correct];
                nums[correct] = tem;
            } else
                i++;
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                System.gc();
                return j + 1;
            }
        }
        System.gc();
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,5,6,7,8};
        //System.out.println(firstMissingPositive_sorted(nums));
        System.out.println(firstMissingPositive_hashset(nums));
        System.out.println(firstMissingPositive_op(nums));
    }
}