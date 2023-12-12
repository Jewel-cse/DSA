package SRBD;

import java.util.Scanner;

public class TravellingSalesMan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            //input sections
            int n = sc.nextInt();
            int[][] mat = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            //call for output
            int[] city = new int[n - 1];
            for (int i = 0; i < n - 1; i++)
                city[i] = i + 1;
            int[] min = new int[1];
            min[0] = (int) 1e9;
            findmincost(0, city, min, mat);
            System.out.println(min[0]);
        }
        sc.close();
    }

    private static void findmincost(int ind, int[] city, int[] min, int[][] mat) {
        //base case.................
        if (ind >= city.length) {

            //got a sequence
            int cost =  mat[0][city[0]];
            
            for (int i = 0; i < city.length - 1; i++) {
                cost += mat[city[i]][city[i + 1]];
            }
            cost += mat[city[city.length - 1]][0];
            // take minimum
            min[0] = Math.min(min[0], cost);
            //System.out.println(Arrays.toString(city));
            return;
        }
        //my recursion
        for (int i = ind; i < city.length; i++) {
            swap(i, ind, city);
            findmincost(ind + 1, city, min, mat);
            swap(i, ind, city);
        }
    }

    private static void swap(int i, int j, int[] city) {
        int temp = city[j];
        city[j] = city[i];
        city[i] = temp;
    }
}
