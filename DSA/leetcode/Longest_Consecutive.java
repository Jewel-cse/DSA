import java.util.Arrays;

public class Longest_Consecutive {
    public static void main(String[] args) {
        int[] arr = { 100, 3, 6, 8, 4, 5 };
        System.out.println(longestConsecutive(arr));
    }

    // sort , difference 1, not equal, maxcount....
    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0)
          return 0;
        Arrays.sort(nums);
        int maxCount = 1,checkMaxCount=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1] == 1){
                checkMaxCount++;
            }else if(nums[i] != nums[i-1]){
                checkMaxCount =1;
            }

            if(checkMaxCount > maxCount){
                maxCount=checkMaxCount;
            }

        }
        return maxCount;
    }
}
