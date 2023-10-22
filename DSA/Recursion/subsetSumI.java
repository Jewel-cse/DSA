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
        generate(arr, sums, index + 1, N, sum + arr.get(index));
        generate(arr, sums, index + 1, N, sum);

        return sums;
    }
    


    
    public static void main(String[] args) {
        //subsetsum(new int[] { 1, 2, 3 });
        //subSets(new int[]{1,2,3});
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(2);
        arr.add(1);

        System.out.println(subsetSums(arr,arr.size()));
    }









}
