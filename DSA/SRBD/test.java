package SRBD;

import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //row
        int m = sc.nextInt(); //col
        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        //input done
        boolean[][] vis = new boolean[n][m];
        boolean[] flag = { false };
        for (int l = 0; l < n; l++) {
            climb(n - 1, 0, l, graph, vis, flag);
            if (flag[0]) {
                System.out.println(l);
                break;
            }
            for (boolean[] v : vis) {
                Arrays.fill(v, false);
            }
        }
    }

    private static void climb(int r, int c, int l, int[][] graph, boolean[][] vis, boolean[] flag) {
        int row = graph.length;
        int col = graph[0].length;
        if (r < 0 || r >= row || c < 0 || c >= col || vis[r][c]) {
            return;
        }
        if (graph[r][c] == 3) {
            flag[0] = true;
            return;
        }
        vis[r][c] = true;
        //left, right, up and down
        if (c + 1 < col && graph[r][c + 1] != 0 && !vis[r][c + 1])
            climb(r, c + 1, l, graph, vis, flag);
        if (c - 1 >= 0 && graph[r][c - 1] != 0 && !vis[r][c - 1])
            climb(r, c - 1, l, graph, vis, flag);
        for (int h = 1; h <= l; h++) {
            if (r - h >= 0 && graph[r - h][c] != 0 && !vis[r - h][c])
                climb(r - h, c, l, graph, vis, flag);
        }
        for (int h = 1; h <= l; h++) {
            if (r + h < row && graph[r + h][c] != 0 && !vis[r + h][c])
                climb(r + h, c, l, graph, vis, flag);
        }
    }
}
/*
1 0 0 1 1 1 0 1 0 1
0 1 0 0 0 1 1 0 1 1
0 0 0 1 0 1 0 1 1 1
1 1 1 0 1 0 0 0 1 1
1 0 1 0 1 0 3 0 1 0
0 1 0 1 0 0 0 0 0 1
0 0 0 0 0 0 0 0 1 1
0 0 1 0 0 0 0 0 1 0
0 1 0 1 0 1 0 0 0 1
 */
