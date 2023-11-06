package Recursion;

import java.util.ArrayList;
import java.util.Collections;


public class subsetSumI {
    

    //@@@@@@@@@@@@ Subset sum   @@@@@@@@@@@@@@@@@@
    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> sums = new ArrayList<>();
        sums = generate(arr, sums, 0, N, 0);
        Collections.sort(sums);
        return sums;
    }

    
    
    public static ArrayList<Integer> generate(ArrayList<Integer> arr, ArrayList<Integer> sums, int index, int N,
            int sum) {
        if (index == N) {
            sums.add(sum);
            return sums;
        }
        generate(arr, sums, index + 1, N, sum + arr.get(index)); //add sum
        generate(arr, sums, index + 1, N, sum); //not add

        return sums;
    }
    
    //@@@@@@@@@@@  generate all the subset sum of given array @@@@@@@@@@@
    private static void subsetSumOfArr(int[] nums) {
        subsetSum(0, nums, 0,nums.length);

    }

    private static void subsetSum(int index, int[] nums, int sum, int n) {
        if (index == n) {
            System.out.println(sum);
            return;
        }
        subsetSum(index + 1, nums, sum + nums[index], n); //peek
        subsetSum(index + 1, nums, sum, n);
    }
    
    //@@@@@@@@@@  count number of  the subset which sum is k @@@@@@@@@@@ 
    private static int subsetSumKOfArr(int[] nums,int k) {
        return subsetSumK(0, nums, 0,k,nums.length);
    }

    private static int subsetSumK(int index, int[] nums, int sum,int k, int n) {
        if (index == n) {
            if(sum == k)
                return 1;
            return 0 ;
        }
        int l = subsetSumK(index + 1, nums, sum + nums[index],k, n); //peek
        int r = subsetSumK(index + 1, nums, sum, k, n);
        return l + r;
    }

    
    public static void main(String[] args) {
        //subsetsum(new int[] { 1, 2, 3 });
        //subSets(new int[]{1,2,3});
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(2);
        arr.add(1);

        //System.out.println(subsetSums(arr,arr.size()));

        int[] nums = { 1, 2,3};
        subsetSumOfArr(nums);
        System.out.println(subsetSumKOfArr(nums, 3));
    }









}
