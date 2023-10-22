package Recursion;

import java.util.ArrayList;

import java.util.List;

public class CombinationSum {
    static int counter = 0;

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        

        List<List<Integer>> ans = new ArrayList<>();
        combinations_unique(0, candidates, target, new ArrayList<>(), ans);
        System.out.println("number of combinations : "+counter);
        return ans;
    }

    //when all the elements are unique in the array: 2^t *k
    public static void combinations_unique(int index, int[] candidates, int target, List<Integer> ds,
            List<List<Integer>> ans) {

        if (index == candidates.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds)); //add expected list to answer list 
                counter++;    //to know how many combinations are posible
            }
            return;
        }
        if (candidates[index] <= target) { //pick element
            ds.add(candidates[index]);
            combinations_unique(index, candidates, target - candidates[index], ds, ans);
            ds.remove(ds.size() - 1);
        }
        combinations_unique(index + 1, candidates, target, ds, ans);
    }
    
    
    
    public static void main(String[] args) {

        System.out.println(combinationSum(new int[]{2,3,6,7}, 7).toString());
    }
}
