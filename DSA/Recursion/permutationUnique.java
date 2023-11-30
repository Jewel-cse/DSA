package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class permutationUnique {
    //APPROACH 1:   USING EXTRA MAP TO TRACK VISITED OR NOT
    private static void parmute(int[] nums,boolean[] vis, List<Integer> ans) {
        //base case
        if (ans.size() == nums.length) {
            System.out.println(ans.toString());
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!vis[i]) { // not visited, visit it and put ans
                vis[i] = true;
                ans.add(nums[i]);
                parmute(nums, vis, ans); //call for next value
                ans.remove(ans.size() - 1); // awww ,backward ! remove last of ans list
                vis[i] = false;      //and say not visited
            }
        }
    }
    //APPROACH 2 : USING SWAPING RECURSION
    /*USING SWAP: 
            : index == nums.length>> put nums array into ds
            : index to nums.length :
                swap(i,indx)
                recursiveCal(indx+1)
                swap() back
     * 
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> ans = new HashSet<>(); //for unique list
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

    //@@@@@@@@@@@@@@@ MAIN FUNCTION
    public static void main(String[] args) {
        //System.out.println(permuteUnique(new int[]{1,2,3}).toString());
        int[] nums = { 1, 2, 3 };
        boolean[] vis = new boolean[nums.length];
        List<Integer> ans = new ArrayList<>();
        parmute(nums, vis, ans); //this takes extra memory space
    } 
}
