package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsets {
    //                      @@@@@@How to generate each sub sets??????
    
    //using bit masking : 2^n * n
    public static void subsetsum(int[] arr) {
        int n = arr.length;
        List<List<Integer>> subsets = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, n); i++) { //2^n times
            List<Integer> s = new ArrayList<>();
            for (int j = 0; j < n; j++) { //n times 
                if ((i & (1 << j)) != 0) { //this pick or not pick condition
                    s.add(arr[j]);
                }
            }
            subsets.add(s);
        }
        System.out.println(subsets.toString());
    }

    //Using Recursion we reduce the time complexity 
    public static List<List<Integer>> subSets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ansList = new ArrayList<>();
        findSubsets(0, arr, new ArrayList<>(), ansList);
        System.out.println(ansList.toString());
        return ansList;
    }
    
    public static void findSubsets(int index,int[] nums,List<Integer> ds,List<List<Integer>>ansList){
        ansList.add(new ArrayList<>(ds));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])     //for duplicate remove er jonno 
                continue;
            ds.add(nums[i]); //list a add
            findSubsets(i + 1, nums, ds, ansList);
            ds.remove(ds.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        subSets(new int[] { 1, 2,2,3 });
    }
}
