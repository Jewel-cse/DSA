package BinarySearch;

import java.util.Arrays;

public class minDayNeedToBouqoutts {
    
    //            ***************Brouteforce solution ***************
    //minimum koto day te m bouquets of each k adjacent flowr banano jabe..
    //Broute force solution: tc: (max-min+1)*ar_size
    public int minDays_naive(int[] bloomDay, int m, int k) {
        int mini = Arrays.stream(bloomDay).min().getAsInt();
        int maxi = Arrays.stream(bloomDay).max().getAsInt();

        if (bloomDay.length < m * k) {
            return -1;
        }
        for (int i = mini; i <= maxi; i++) {
            if (posible(bloomDay, i, m, k)) {
                return i;
            }
        }
        return -1;
    }

    public boolean posible(int[] bloomDay, int day, int m, int k) {
        int count = 0;
        int noOfBouq = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (day >= bloomDay[i]) {
                count++;
            } else {
                noOfBouq += count / k; //adjacent flower k
                count = 0;
            }
        }
        noOfBouq += count / k;
        if (noOfBouq >= m) { //no of bouqoutes
            return true;
        }
        return false;
    }
    
    //        *****************Using Binary search **************
    //time complexity: n*log(max-min+1)
    public int minDays(int[] bloomDay, int m, int k) {
        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();

        if (bloomDay.length < (long)m * k) {
            return -1;
        }
        int minDay = high;          //ei day te sob bouqoutes hoy jabe 
        while (low <= high) {
            int mid = (low + high) / 2;
            if (posible(bloomDay, mid, m, k)) {
                minDay = mid;
                high = mid - 1;  //find min day
            } else {
                low = mid + 1;   // kom day te hocche na day barao
            }
        }
        return minDay;
    }
}
