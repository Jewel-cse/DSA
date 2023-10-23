package GreedyAlgo;

import java.util.Arrays;

public class minPlatformsNeeded {
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        Arrays.sort(at);
        Arrays.sort(dt);
        int platfromNeed = 1;
        int result = 1;

        int i = 1;
        int j = 0;
        while (i < n && j < n) {
            if (at[i] > dt[j]) { //train charar por new train asche means platform faka
                platfromNeed--;
                j++;
            } else if (at[i] <= dt[j]) {// new train agei cole asche or same time of dt e cole asche means platform lagbe
                platfromNeed++;
                i++;
            }
            if (platfromNeed > result)
                result = platfromNeed;
        }
        return result;
    }
    public static void main(String[] args) {
        int at[] = {900 ,940, 950, 1100, 1500, 1800};
        int dt[] = { 910, 1200, 1120, 1130, 1900, 2000 };

        System.out.println(calculateMinPatforms(at, dt, at.length));
    }
}
