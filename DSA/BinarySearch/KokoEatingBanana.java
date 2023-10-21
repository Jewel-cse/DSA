package BinarySearch;

import java.util.Arrays;



public class KokoEatingBanana {
    public static void main(String[] args) {
        int[] piles = { 30, 11, 23, 4, 20 };
        //System.out.println(minEatingSpeed_NaiveApp(piles, 6));
        System.out.println(minEatingSpeed(piles, 5));

    }

    //Binary search : n*log2^maxValue of array
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int minimumRate = high;//ei rate e eat korle min time lagbe
        while (low <= high) {
            int mid = (low + high) / 2;
            if (totalTime(piles, mid) <= h) {
                minimumRate = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return minimumRate;
    }

    public static int totalTime(int[] piles, int mid) {
        int totalTime = 0;
        for (int i = 0; i < piles.length; i++) {
            totalTime += Math.ceil((double) piles[i] / (double) mid);
        }
        return totalTime;
    }


    //Naive approach: o(maxvalue of Array*n)
    //hourly koita kore eat korl e h hour er moddhei sob banana eat korte parbe
    public static int minEatingSpeed_NaiveApp(int[] piles, int h) {
        int maxK = Arrays.stream(piles).max().getAsInt();
        if (h < piles.length)
            return -1;
        for (int i = 1; i <= maxK; i++) {
            int totalTime = 0;
            for (int j = 0; j < piles.length; j++) {
                totalTime += Math.ceil((double) (piles[j]) / (double) i);
            }
            System.out.println("Total time needed  "+totalTime + " "+ i+"b/h (minimum)" + "  hourLimit"+ h);
            if (totalTime <= h) {
                return i;  //
            }
        }
        return 1;
    }
    
}
