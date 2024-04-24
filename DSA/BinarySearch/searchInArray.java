package BinarySearch;

import java.util.Arrays;

public class searchInArray {
    //using iterative method
    private static int BinarySearch(int[] arr,int target){
        int low = 0;
        int high = arr.length-1;
        Arrays.sort(arr);

        while (low<=high) {
            int mid = low + (high-low)/2 ;
            if(arr[mid] == target)  return mid;
            else if(arr[mid]<target)    low = mid+1;
            else    high = mid-1;
        }
        return -1;
    }

    //using recursion
    private static int binarySearch_Rec(int[]arr,int target,int low,int high){
        if(low>high)    return -1;
        int mid  = low +(high-low)/2;
        if(arr[mid] == target)  return mid;
        else if(arr[mid]<target)
            return binarySearch_Rec(arr, target, mid+1, high);
        return binarySearch_Rec(arr, target, low, mid-1);
    }


    public static void main(String[] args) {
        
        System.out.println(BinarySearch(new int[]{1,3,4,5,6,7,8},8));
        System.out.println(binarySearch_Rec(new int[]{1,3,4,5,6,7,8},8,0,6));
    }
}
