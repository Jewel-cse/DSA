package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {
    public static List<String> ratMaze(int[][] mat) {
        int n = mat.length;
        //direction down,left,right,up
        int[] di = { 1, 0, 0, -1 };
        int[] dj = { 0, -1, 1, 0 };
        //visited matriz
        int[][] vis = new int[n][mat[0].length];
        //output string move
        List<String> res = new ArrayList<>();

        if (mat[0][0] == 1) {
            solve(0, 0, mat, n, vis, di, dj, "", res);
        }
        
        return res;
    }

    private static void solve(int row, int col, int[][] mat, int n, int[][] vis, int[] di, int[] dj, String move,
            List<String> res) {
        if (row == n - 1 && col == n - 1) {
            res.add(move);
            return;
        }

        String dir = "DLRU";
        for (int i = 0; i < 4; i++) {
            int nexti = row + di[i];
            int nextj = col + dj[i];
            //boundary check
            if (nexti >= 0 && nexti < n && nextj >= 0 && nextj < n && vis[nexti][nextj] != 1
                    && mat[nexti][nextj] == 1) {
                vis[row][col] = 1;
                solve(nexti, nextj, mat, n, vis, di, dj, move + dir.charAt(i), res);
                vis[row][col] = 0;
            }
        }        

        
    }

    public static void main(String[] args) {
        
        int[][] maze = {{1, 1, 1},
                        {1, 0, 1},
                { 1, 1, 1 } };
                    
        System.out.println(ratMaze(maze).toString());
    }
}
