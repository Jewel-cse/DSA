package SRBD;

import java.util.Arrays;
import java.util.Scanner;

public class SpaceShipBomb_DP {
    //exploide bomb
    private static void exploidBomb(int row, char[][] mat) {
        if(row <0 )
            return;
        int uplimit = Math.max(0, row - 4);
        for (int i = row; i >=uplimit; i--) {
            for (int j = 0; j < 5; j++) {
                if(mat[i][j] =='2')
                    mat[i][j] = '0';
            }
        }
    }

    private static int findmaxCoin(int row, int Spos, int bomb, char[][] mat,int[][]dp) {
        if(row<=0 || Spos <0 || Spos >=5)
            return 0;
        int ans = 0;
        //not move, left , right

        if (row > 0 && mat[row - 1][Spos] != '2') {  //not move
            if (dp[row - 1][Spos] != -1) {
                ans = Math.max(ans, (mat[row - 1][Spos] == '1' ? 1 : 0) + dp[row-1][Spos]);
            }else
                ans = Math.max(ans, (mat[row - 1][Spos] == '1' ? 1 : 0) + findmaxCoin(row - 1, Spos, bomb, mat,dp));
        }
        if (Spos - 1 >= 0 && mat[row - 1][Spos - 1] != '2') { //left move
            if (dp[row - 1][Spos - 1] != -1) {
                ans = Math.max(ans, (mat[row - 1][Spos-1] == '1' ? 1 : 0) + dp[row-1][Spos-1]);    
            }else
                ans = Math.max(ans, (mat[row - 1][Spos-1] == '1' ? 1 : 0) + findmaxCoin(row - 1, Spos-1, bomb, mat,dp));
        }
        if (Spos + 1 <= 4 && mat[row - 1][Spos + 1] != '2') {
            if (dp[row - 1][Spos + 1] != -1) {
                ans = Math.max(ans, (mat[row - 1][Spos + 1] == '1' ? 1 : 0) + dp[row-1][Spos+1]);
            }else
                ans = Math.max(ans, (mat[row - 1][Spos + 1] == '1' ? 1 : 0) + findmaxCoin(row - 1, Spos + 1, bomb, mat,dp));
        } 
        else if (ans == 0 && bomb > 0) {
            exploidBomb(row - 1, mat);
            ans = dp[row - 1][Spos] != -1 ? dp[row - 1][Spos] : findmaxCoin(row - 1, Spos, bomb - 1, mat, dp);
        }
        dp[row][Spos] = ans;
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int tno = 0;
        while (t-- > 0) {
            int row = sc.nextInt();
            char[][] mat = new char[row][5];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < 5; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }
            tno++;
            System.out.println("# " + tno + " : maximum coin : " + findmaxCoin_dp(row, 2, 1, mat));
        }
        sc.close();
    }

    private static int findmaxCoin_dp(int row, int c, int bomb, char[][] mat) {
        
        int[][] dp = new int[row+1][5];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return findmaxCoin(row, c, bomb, mat,dp);
    }
}
    


