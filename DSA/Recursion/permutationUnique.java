package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class permutationUnique {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> ans = new HashSet<>();
        parmutationArr(0, nums, ans);

        List<List<Integer>> res = new ArrayList<>();
        res.addAll(ans);
        return res;
    }

    public static void parmutationArr(int index, int[] nums, HashSet<List<Integer>> ans) {

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
        System.out.println(permuteUnique(new int[]{1,2,3}).toString());
    }
}
