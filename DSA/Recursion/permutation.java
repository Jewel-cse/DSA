package Recursion;

import java.util.ArrayList;
import java.util.List;

public class permutation {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        parmutationArr(0, nums, ans);
        return ans;
    }

    public static void parmutationArr(int index, int[] nums, List<List<Integer>> ans) {

        //add list to output
        if (index == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(ds);
            return;
        }

        //swap , index+1 kore call
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            parmutationArr(index + 1, nums, ans);
            swap(i, index, nums);               //last swap 
        }
    }

    private static void swap(int i, int index, int[] arr) {
        int t = arr[index];
        arr[index] = arr[i];
        arr[i] = t;
    }
    public static void main(String[] args) {
        System.out.println(permute(new int[]{0,1}).toString());
    }
}
