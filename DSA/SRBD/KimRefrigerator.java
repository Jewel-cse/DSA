package SRBD;

import java.util.Scanner;

public class KimRefrigerator {
    private static int mx = (int) 1e9;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 10;  //by default
        int serial = 1;
        while (t-- > 0) {
            int n = sc.nextInt();

            int sx = sc.nextInt();
            int sy = sc.nextInt();
            int ex = sc.nextInt();
            int ey = sc.nextInt();

            int[][] custloc = new int[n][2];
            for (int i = 0; i < n; i++) {
                custloc[i][0] = sc.nextInt();
                custloc[i][1] = sc.nextInt();
            }
            //find all possible ways of kim visits : (permutations)
            int[] dis = new int[1];
            dis[0] = mx;
            ways(0, custloc, sx, sy, ex, ey, dis);
            System.out.println("# " + serial + " " + dis[0]);
            serial++;
        }
        sc.close();
    }

    private static void ways(int ind, int[][] custloc, int sx, int sy, int ex, int ey,int[] dis) {
        if (ind == custloc.length) {
            //get one permutation, calculate distance
            dis[0] = Math.min(dis[0], getDistance(sx, sy, ex, ey, custloc));
            return;
        }
        for (int i = ind; i < custloc.length; i++) {
            swap(i, ind, custloc);
            ways(ind + 1, custloc, sx, sy, ex, ey,dis);
            swap(i, ind, custloc);
        }
    }

    private static int getDistance(int sx, int sy, int ex, int ey, int[][] custloc) {
        //distance office -> customer 1st ......customer last -> to home 
        int distance = Math.abs(sx - custloc[0][0]) + Math.abs(sy - custloc[0][1]);
        for (int i = 0; i < custloc.length - 1; i++) {
            distance += Math.abs(custloc[i][0] - custloc[i + 1][0]) + Math.abs(custloc[i][1] - custloc[i + 1][1]);
        }
        distance += Math.abs(ex - custloc[custloc.length-1][0]) + Math.abs(ey - custloc[custloc.length-1][1]);
        return distance;
    }

    private static void swap(int i, int ind, int[][] custloc) {
        int tempx = custloc[i][0];
        int tempy = custloc[i][1];
        custloc[i][0] = custloc[ind][0];
        custloc[i][1] = custloc[ind][1];
        custloc[ind][0] = tempx;
        custloc[ind][1] = tempy;
    }
}
/*
5
0 0 100 100 70 40 30 10 10 5 90 70 50 20
6
88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14
5
0 0 100 100 70 40 30 10 10 5 90 70 50 20
6
88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14
5
0 0 100 100 70 40 30 10 10 5 90 70 50 20
6
88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14
5
0 0 100 100 70 40 30 10 10 5 90 70 50 20
6
88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14
5
0 0 100 100 70 40 30 10 10 5 90 70 50 20
6
88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14
 */
