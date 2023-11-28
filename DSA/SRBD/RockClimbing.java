package SRBD;

import java.util.Arrays;
import java.util.Scanner;

public class RockClimbing {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //input area..............
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] map = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        //function call and calculation part...
        boolean[][] vis = new boolean[row][col];
        boolean[] flag = { false };
        for (int level = 0; level < row; level++) {
            minDifficulty(row - 1, 0, map, vis, level,flag);
            //if its get minimum difficulty
            if (flag[0]) { //got min difficulty ,lets print
                System.out.println(level);
                break;
            }
            //fills false in vis array
            for (boolean[] bs : vis) {
                Arrays.fill(bs, false);
            }
        }
        sc.close();
    }

    private static void minDifficulty(int r, int c, int[][] map, boolean[][] vis, int level, boolean[] flag) {
        int row = map.length;
        int col = map[0].length;
        //base case
        if(r<0 || r >= row || c < 0 || c>=col)
            return;
        if (vis[r][c])
            return;
        
        //do visit
        vis[r][c] = true;
        //if get destination ,simply return    
        if (map[r][c] == 3) {
            //System.out.println("min level : "+level);
            flag[0] = true;
            return;
        }
        //check destination at right
        if(c+1< col && map[r][c+1] != 0 && !vis[r][c+1] )
            minDifficulty(r, c + 1, map, vis, level, flag);
            
        //check destination left
        if(c-1>=0 && map[r][c-1] != 0 && !vis[r][c-1] )
            minDifficulty(r, c - 1, map, vis, level,flag);
        
        //check for up
        for (int h = 1; h <= level; h++) {
            if (r - h >= 0 && map[r - h][c] != 0 && !vis[r - h][c])
                minDifficulty(r - h, c, map, vis, level,flag);
        }
        //check for down
        for (int h = 1; h <= level; h++) {
            if (r + h <row && map[r + h][c] != 0 && !vis[r + h][c])
                minDifficulty(r + h, c, map, vis, level,flag);
        }
        
    }
}
/*
5 8
1 1 1 1 0 0 0 0
0 0 0 3 0 1 1 1
1 1 1 0 0 1 0 0
0 0 0 0 0 0 1 0
1 1 1 1 1 1 1 1
ans: 2
 */
