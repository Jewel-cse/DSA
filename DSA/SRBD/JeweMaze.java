package SRBD;

import java.util.Arrays;
import java.util.Scanner;


/*
 * // Problem Id: https://blog.csdn.net/lihenair/article/details/17227667
/*
Sample Input:
2
5
0 0 0 2 0
2 1 0 1 2
0 0 2 2 0
0 1 0 1 2
2 0 0 0 0
6
0 1 2 1 0 0
0 1 0 0 0 0
0 1 2 1 2 1
0 2 0 1 0 2
0 1 0 1 0 1
2 0 2 1 0 0

Sample Output:
# 1: 6
3 0 3 3 3 
3 1 3 1 3 
3 0 3 2 3 
3 1 3 1 3 
3 3 3 0 3 
# 2: 4
3 1 2 1 0 0 
3 1 3 3 3 0 
3 1 3 1 3 1 
3 2 3 1 3 2 
3 1 3 1 3 1 
3 3 3 1 3 3 
*/
/*
   Input: 
        :take n size, matrix,vis,path, ans initialize
        :send it to dfs with first element and number of jewel>value
 * Base case:
 *      : if x,y reach to last then check the collect jewel is greater or not
 *      :if greated then collect it and path save from visited matrix
 * 
 * recurtion: 
 *      : move 4 position from a point , check validity,
 *      : if valid, visit, call for next with collect jewel exists or not
 *      : backtrack > unvisit
 */
public class JeweMaze {

    static int n;
    static int[][] dir = { { -1, 0 }, { +1, 0 }, { 0, +1 }, { 0, -1 } };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int no = 1;
        while (t-- > 0) {
            n = sc.nextInt();
            int[][] mat = new int[n][n];
            int[][] path = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            // call dfs
            boolean[][] vis = new boolean[n][n];
            //check for 00 index
            int[] ans = new int[1];
            ans[0] = Integer.MIN_VALUE;
            int value = mat[0][0] == 2 ? 1 : 0;
            vis[0][0] = true;
            dfs(0, 0, value, mat, vis, path, ans);
            System.out.println("# " + no++ + " " + ans[0]);
            for (int[] i : path) {
                System.out.println(Arrays.toString(i));
            }
        }
        sc.close();
    }

    private static void dfs(int sx, int sy,int value, int[][] mat, boolean[][] vis, int[][] path,int[]ans) {
    
        //if it reaches last last element , check ans and update path matrix
        if (sx == n - 1 && sy == n - 1) {
            if (value > ans[0]) {
                ans[0] = value;
                //pathsave
                for (int i = 0; i < mat.length; i++) {
                    for (int j = 0; j < mat[0].length; j++) {
                        if (vis[i][j])
                            path[i][j] = 3;
                        else
                            path[i][j] = mat[i][j];
                    }
                }
            }
            return;
        }
        //go for the 4 direction if it is not visited 
        //have jewel ? value +1 if have
        //call with values
        //backtracking
        for (int i = 0; i < dir.length; i++) {
            int xx = sx + dir[i][0];
            int yy = sy + dir[i][1];
            if (isvalid(xx, yy, mat, vis)) {
                vis[xx][yy] = true;
                // if this position have jewel add 1 other wise not add to ans
                int isJewel = mat[xx][yy] == 2 ? 1 : 0;
                dfs(xx, yy, value + isJewel, mat, vis, path,ans);
                vis[xx][yy] = false;
            }
        }
        
    }


    private static boolean isvalid(int xx, int yy, int[][] mat, boolean[][] vis) {
        return xx >= 0 && xx < mat.length && yy >= 0 && yy < mat[0].length && mat[xx][yy] != 1 && !vis[xx][yy];
    }
}
