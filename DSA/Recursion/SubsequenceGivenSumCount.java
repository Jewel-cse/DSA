package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceGivenSumCount {
    //static int count = 0;

    //@@@@@@@@@@@@@   Q1: generate all the subsequence or Power set of given array @@@@@@@@@@@@@@@
    public static void subsequence(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        int n = nums.length;
        powerSets(0, nums, n, ls);
    }

    // TC: 2^n and Sp: auxiliary stack memory (n),
    public static void powerSets(int index, int[] nums, int n, List<Integer> ds) {
        if (index == n) {
            System.out.println(ds.toString());
            return;
        }
        ds.add(nums[index]);
        powerSets(index + 1, nums, n, ds);

        ds.remove(ds.size() - 1);
        powerSets(index + 1, nums, n, ds);

    }
    
    //@@@@@@@@@@@@@@ Q2: generate all the sub sequence that sum k  @@@@@@@@@@@@@@@@@@@@@@@
    private static void sequenceWithKsum(int[] nums, int sum) {
        int n = nums.length;
        //need extra variable sum and pass recursion
        List<Integer> ds = new ArrayList<>();
        sumSequence(0,  ds,0, sum, nums, n);
    }


    private static void sumSequence(int index, List<Integer> ds, int newSum, int sum, int[] nums, int n) {
        if (index == n) {
            if (newSum == sum) {
                System.out.println(ds.toString());
            }
            return;
        }
        //peek option
        ds.add(nums[index]);
        sumSequence(index + 1, ds, newSum + nums[index], sum, nums, n);
        //non peek
        ds.remove(ds.size() - 1);
        sumSequence(index + 1, ds, newSum, sum, nums, n);

    }
    
    //@@@@@@@@@@@@@ generate only one subsequence that sum k @@@@@@@@@@@@@@ without global variable
    private static boolean sequenceWithKsum_one(int[] nums, int sum) {
        int n = nums.length;
        //need extra variable sum and pass recursion
        List<Integer> ds = new ArrayList<>();
        return sumSequence_one(0,  ds,0, sum, nums, n);
    }


    private static boolean sumSequence_one(int index, List<Integer> ds, int newSum, int sum, int[] nums, int n) {
        if (index == n) {
            if (newSum == sum) {
                System.out.println(ds.toString());
                return true;
            }
            return false;
        }
        //peek option
        ds.add(nums[index]);
        if (sumSequence_one(index + 1, ds, newSum + nums[index], sum, nums, n))
            return true;
        //non peek
        else {
            ds.remove(ds.size() - 1);
            return sumSequence_one(index + 1, ds, newSum, sum, nums, n);
        }

    }
    
    // @@@@@@@@@ count number of subsequence with given sum @@@@@@@@@@@@@@@
    private static int totalsubsequence(int[] nums,int sum) {
        return countSequence(0, nums,0,sum, nums.length);
    }
    private static int countSequence(int index,int[] nums,int newSum,int sum,int n) {
        if (index == n) {
            if(newSum == sum)
                return 1;
            return 0;
        }
        int l = countSequence(index + 1, nums,newSum+nums[index],sum, n);
        int r = countSequence(index + 1, nums,newSum,sum, n);

        return l + r;
    }

    //main functions
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3,4};
        subsequence(nums);
        sequenceWithKsum(nums, 3);
        sequenceWithKsum_one(nums, 6);

        System.out.println(totalsubsequence(nums,3));
    }
}
