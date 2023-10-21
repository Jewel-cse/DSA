package BinarySearch;

import java.util.Arrays;

public class capacityToshipPackagewithinDays {
    public static void main(String[] args) {
        int[] weights = { 1,2,3,4,5,6,7,8,9,10 };
        System.out.println(shipWithinDays_Naive(weights, 5));
    }
    //                   ****************Naive approach********************
    //brouteforce solution: find the minimum capacity of ships which ships within days
    public static int shipWithinDays_Naive(int[] weights, int days) {

        //minimum capacity will be tha maximum weight 
        int low = Arrays.stream(weights).max().getAsInt();
        //find maximum capacity
        int high = 0;
        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
        }

        //find the minimum capacity along low and high
        for (int i = low; i <= high; i++) {
            if (possibleWithcapacity(weights, i, days)) {
                return i;
            }
        }
        return -1;

    }
    //           ***********Binary search **************
    //we iterate maxof weights to summation
    //optimize it using binary search
    public static int shipWithinDays(int[] weights, int days) {

        //minimum capacity will be tha maximum weight 
        int low = Arrays.stream(weights).max().getAsInt();
        //find maximum capacity
        int high = 0;
        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
        }
        //int minCapacity = low;
        //find the minimum capacity along low and high
        while (low <= high) {
            int mid = (low+high)/2;
            if (possibleWithcapacity(weights, mid, days)) {
                //minCapacity = mid;  //this is ans
                high = mid - 1;
            }else
                low = mid + 1;
        }
        return low;  //minCapacity just extra variable

    }

    public static boolean possibleWithcapacity(int[] weights,int capacity,int days){
        int countday = 1;
        int wt = 0;
        for (int i = 0; i < weights.length; i++) {
            wt +=weights[i];
            if(wt>capacity){
                countday++;
                wt = weights[i];
            }
            if(countday>days){
                return false;
            }
        }
        return true;
    }
}
