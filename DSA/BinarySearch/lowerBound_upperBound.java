//package BinarySearch;

import java.util.Arrays;

/*
 * What is lower bound: (it is a index)
 * The lower bound is the @@smallest index, ind, where arr[ind] >= x. 
 * 
 * what is upper bound : 
 * The upper bound is the @@smallest index, ind, where arr[ind] > x.
 * 
 * But if any such index is not found, both algorithm returns n i.e. size of the given array.
 * array must be sorted


 */
public class lowerBound_upperBound {

    //lower bound
    private static int lowerBound(int[]arr,int target){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        Arrays.sort(arr);
        int ans = n;
        while (low<=high) {
            int mid = low + (high-low)/2 ;
            if(arr[mid]>=target){
                ans = mid;
                high = mid-1;
            }    
            else    low = mid+1;
        }
        return ans;
    }

    //upper bound
    private static int upperbound(int[]arr,int target){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        Arrays.sort(arr);
        int ans = n;
        while (low<=high) {
            int mid = low + (high-low)/2 ;
            if(arr[mid]>target){
                ans = mid;
                high = mid-1;
            }    
            else    low = mid+1;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(lowerBound(new int[]{1,4,5,65},4));
        System.out.println(upperbound(new int[]{1,4,5,65},4));
    }
}
