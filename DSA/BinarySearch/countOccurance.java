package BinarySearch;

import java.util.Arrays;

public class countOccurance {
  
    //            ***********Approach one***************
    // BS e jekono ekta x pailei tar age and pore loop calabo jotokhon x pawa jai and count korbo
    public static int count(int arr[], int n, int x) { //length,target
        int low = 0;
        int high = n - 1;
        int count = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) { //ureca.....
                count++;
                int forward = mid + 1;
                int backward = mid - 1;

                while (forward <= high && arr[forward] == x) {
                    count++;
                    forward++;
                }
                while (backward >= low && arr[backward] == x) {
                    count++;
                    backward--;
                }
                break;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return count;
    }

    // ############## find 1st and last occurance using BS ####################
    
    public static int firstOccur(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int firstOccrance = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target){
                firstOccrance = mid;
                high = mid-1;
            }
            else if (nums[mid] > target) {
                high = mid - 1; 
            } else {
                low = mid + 1;
            }
        }
        return firstOccrance;
    }
    public static int lastOccur(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int last = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target){
                last = mid;
                low = mid+1;
            }
            else if (nums[mid] > target) {
                high = mid - 1;
                
            } else {
                low = mid + 1; 
            }
        }
        return last;
    }
    
    ////############ Number of Occurance ###########
    public static int count(int arr[], int x) { //length,target
        int first =firstOccur(arr,x) ;
        if(first == -1)     return 0;

        return lastOccur(arr, x) -first + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2,2,2,2,4,4, 4, 4, 5 };
        System.out.println(count(arr, arr.length, 3));

        System.out.println(firstOccur(arr, 4));
        System.out.println(lastOccur(arr, 4));
        //System.out.println(totalOccurance(arr, 3));
        //System.out.println(Arrays.toString(firstAndLastIndex(arr, 3)));

    }
}
