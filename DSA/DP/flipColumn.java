package DP;

import java.util.Scanner;

public class flipColumn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //input sections
        int r = sc.nextInt();
        int c = sc.nextInt();
        int k = sc.nextInt();
        int[][] mat = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        //System.out.println(countOnes(mat));
        //
        //traverse 1st row
        //if 0 then toggle column ,
        //if last index e jai then check available  is odd
        //if odd > not posible
        //if even > then count rows contains all 1s
        int mxcont = 0;
        for (int i = 0; i < r; i++) {
            int cnt = 0;
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 0 && k > 0) {
                    //toggle column j
                    //k --
                    toggle(j, mat);
                    k--;
                }
                if (j == c - 1 && k % 2 == 0) {
                    cnt = countOnes(mat);
                }
            }
            if (cnt > mxcont)
                mxcont = cnt;
        }
        System.out.println(mxcont);
    }

    //@@@@@@@@@@ Count the number of rows which are all 1
    private static int countOnes(int[][] mat) {
        int rowCnt = 0;
        for (int[] is : mat) {
            int cnt = 0;
            for (int i = 0; i < is.length; i++) {
                cnt += is[i];
            }
            if (cnt == is.length) {
                rowCnt += 1;
            }
        }
        return rowCnt;
    }
    //@@@@ toggle the column
    private static void toggle(int j, int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            mat[i][j] = 1 - mat[i][j];
        }
    }
}
