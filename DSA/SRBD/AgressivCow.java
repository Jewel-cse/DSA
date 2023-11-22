package SRBD;

import java.util.Arrays;

public class AgressivCow {
    /*   time compelxity: 
        for sorting: n logn 
        binary search: logn * n
     *  TC: N LOG N
     */
    public static int aggressiveCows(int[] stalls, int cow) {
        Arrays.sort(stalls);
        /*
         * 
         int max = stalls[stalls.length - 1];
         int min = stalls[0];
        
         int i = 1;
         for (i = 1; i <= max - min; i++) {
             if (canGet(stalls, i, cow))
                 continue;
             else
                 break;
         }
         return i - 1;
         */
        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canGet(stalls, mid, cow)) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return high;
    }

    private static boolean canGet(int[] stalls, int distance, int cow) {
        int cowNumber = 1;
        int lastCowPos = 0;
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - stalls[lastCowPos] >= distance) {
                cowNumber++;
                lastCowPos = i;
            }
            if (cowNumber >= cow)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(aggressiveCows(new int[]{4, 2, 1, 3, 6}, 2));
    }
}
