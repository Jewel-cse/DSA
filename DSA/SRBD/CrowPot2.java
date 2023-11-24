package SRBD;

import Sorting.sorting_algo ;
import java.util.Scanner;

public class CrowPot2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //input section ....................................
        int numberofPot = sc.nextInt();
        int[] ovflw = new int[numberofPot];
        for (int i = 0; i < ovflw.length; i++) {
            ovflw[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        //sort overflow ....................................
        sorting_algo.mergeSort(ovflw, 0, numberofPot - 1);
        // difference ..........................
        for (int i = numberofPot - 1; i > 0; i--) {
            ovflw[i] = Math.max(0, ovflw[i] - ovflw[i - 1]);
        }
        //stone claculate...................................
        int stones = 0;
        for (int i = 0; i < k; i++) {
            stones += ovflw[i] * (numberofPot - i);
        }
        System.out.println("totol stone needed: " + stones);
        sc.close();
    }
}
