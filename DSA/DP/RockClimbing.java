package DP;

import java.util.Arrays;
import java.util.Scanner;

public class RockClimbing {

    public static int climbRock(int r, int c, int[][] map, int[][] dp) {
        if (r == 0) {
            return map[r][c];
        }
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        //up left
        int upright;
        int upleft;
        int up = upleft = upright = (int) 1e9;
        if (r > 0 && c - 1 >= 0) {
            upleft = map[r][c] + climbRock(r - 1, c - 1, map, dp);
        }
        //up 
        if (r > 0) {
            up = map[r][c] + climbRock(r - 1, c, map, dp);
        }
        //up right
        if (r > 0 && c + 1 < map[0].length) {
            upright = map[r][c] + climbRock(r - 1, c + 1, map, dp);
        }
        return dp[r][c] = Math.min(upleft, Math.min(up, upright));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            int[][] map = new int[row][col];
            int[][] dp = new int[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }
            for (int[] is : dp) {
                Arrays.fill(is, -1);
            }
            int minDifficulty = Integer.MAX_VALUE;
            for (int c = 0; c < map[0].length; c++) {
                minDifficulty = Math.min(minDifficulty, climbRock(row - 1, c, map, dp));
            }
            System.out.println(minDifficulty);
        }
        scanner.close();
    }
}
/*
 Find the minimum dangervalue of path(start last row --> 1st row)
 4 5
 2 8 9 5 8
 4 4 6 2 3
 5 7 5 6 1
 3 2 5 4 8
 ans : 12
 */
