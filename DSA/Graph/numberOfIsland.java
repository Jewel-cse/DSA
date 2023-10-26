import java.util.LinkedList;
import java.util.Queue;

public class numberOfIsland {
    public static int numberofislad(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;

        int[][] vis = new int[r][c];

        int cnt = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 1 && vis[i][j] == 0) {
                    bfsOfisland(i, j, mat, vis);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void bfsOfisland(int r, int c, int[][] mat, int[][] vis) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));
        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int nrow = row + i;
                    int ncol = col + j;
                    if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0
                            && mat[nrow][ncol] == 1) {

                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }
    
    ///main function@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    public static void main(String[] args) {
        int[][] grid = {
            {0,1,1,0},
            {0,1,0,1},
            {0,0,1,0},
            {0,0,0,0},
            {1,1,0,1}
        };
        System.out.println(numberofislad(grid));
    }
}
