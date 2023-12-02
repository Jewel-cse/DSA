package SRBD;

import java.util.Scanner;

public class MrLeeOfficeVisit {
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();   //number of office to visit
            int[][] mat = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            int[] office = new int[n-1];
            for (int i = 0; i < n-1; i++) {
                office[i] = i + 1;
            }
            //System.out.println(Arrays.toString(office));
            int[] ans = new int[1];
            ans[0] = (int) 1e9;
            ways(0, office, mat,ans);
            System.out.println("Minimum airfare: "+ans[0]);
        }
        sc.close();
    }
    ///@@@@@@@ Parmutation problem.@@@@@@@@@@@@@
    private static void ways(int ind, int[] office, int[][] mat,int[]ans) {
        if (ind == office.length) {
            //get a ways > calculate a cost and compare
            if(mat[0][office[0]] == 0 ||mat[office[office.length - 1]][0] == 0)
                return;  //path not exists
            int cost =  mat[0][office[0]];
            for (int i = 0; i < office.length - 1; i++) {
                if (mat[office[i]][office[i + 1]] == 0)
                    return; //path not exists
                cost += mat[office[i]][office[i + 1]];
            }
            cost += mat[office[office.length - 1]][0];
            //System.out.println(Arrays.toString(office) + " Cost : "+ cost);   //print office
            if (cost < ans[0])
                ans[0] = cost;
            return;
        }
        for (int i = ind; i < office.length; i++) {
            swap(i, ind, office);
            ways(ind + 1, office, mat,ans);
            swap(i, ind, office);
        }
    }

    private static void swap(int i, int ind, int[] office) {
        int temp = office[i];
        office[i] = office[ind];
        office[ind] = temp;
    }
}
/*
2
5
0 14 4 10 20
14 0 7 8 7
4 5 0 7 16
11 7 9 0 2
18 7 17 4 0
5
9 9 2 9 5
6 3 5 1 5
1 8 3 3 3
6 0 9 6 8
6 6 9 4 8

Example of Output

30
18

 */
