package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CombinationsII {

    /*
     * difference from combinationsum 1
     * : sort array   : nlogn
     * : user hashset in place of anslist
     * : index+1 instead of index in recursive function
     * : convert hashset to list of list : 
     * 
     * : tc: 2^n*klogn
     */

    static int counter = 0;
    //array contains duplicate element but answer must be unique..
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashSet<List<Integer>> set = new HashSet<>();
        combinations(0, candidates, target, new ArrayList<>(), set);
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.addAll(set);
        return ans;
    }
    public static void combinations(int index, int[] candidates, int target, List<Integer> ds,
            HashSet<List<Integer>> ans) {
        if (index == candidates.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds)); //add expected list to answer list 
            }
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[index] <= target) {
                ds.add(candidates[index]);
                combinations(index + 1, candidates, target - candidates[index], ds, ans); //changes index+1
                ds.remove(ds.size() - 1);
            }
            combinations(index + 1, candidates, target, ds, ans);
        }

    }
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{1,1}, 1).toString());
    }
}
