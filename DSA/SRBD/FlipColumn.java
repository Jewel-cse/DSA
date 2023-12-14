package SRBD;

import java.util.Scanner;

public class FlipColumn {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        int k = sc.nextInt();

        int[][] mat = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        //input done
        int mxcount = 0;
        for(int i = 0;i<r;i++){
            int cnt = 0;
            for(int j = 0;j<c;j++){
                if(mat[i][j] == 0 && k>0){
                    k--;
                    toggle(j,mat);
                }
                if(j == c-1 && k%2 == 0){
                    cnt =  onesRow(mat);
                }
            }
            if(cnt>mxcount)
                mxcount = cnt;
        }
        System.out.println(mxcount);
    }
    private static void toggle(int j ,int[][]mat){
        for( int i = 0;i<mat.length;i++){
            mat[i][j] = 1-mat[i][j];
        }
    }
    private static int onesRow(int[][]mat){
        int cnt = mat.length;
        for(int[] m:mat){
            for(int i = 0;i<m.length;i++){
                if(m[i] == 0){
                    cnt--;
                    break;
                }
            }
        }
        return cnt;
    }
}
