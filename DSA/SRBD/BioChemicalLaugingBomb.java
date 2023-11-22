package SRBD;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BioChemicalLaugingBomb {


    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr, level;
    static int n, m;

    static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    //bfs function which take input cordinate and traverse and time count
    static int bfs(int sx, int sy) {
        int ans = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { sx, sy });
        arr[sx][sy] = 2;   // 2 means already visited
        level[sx][sy] = 1;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];

                if (isValid(xx, yy) && arr[xx][yy] == 1) {
                    q.offer(new int[] { xx, yy });
                    arr[xx][yy] = 2;
                    level[xx][yy] = level[x][y] + 1;
                    ans = level[xx][yy];
                }
            }
        }
        return ans;
    }

    //main funcion with number of test case...
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            m = scanner.nextInt(); //row
            n = scanner.nextInt(); //column
            arr = new int[m][n];
            level = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            int ans = bfs_mine(x - 1, y - 1,arr);
            System.out.println(ans);
        }
        scanner.close();
    }

    ////////////// without extra matirix.......
    ////@@@@@@@ time is calculated using ans variable.......
    private static int bfs_mine(int sx, int sy,int[][]graph) {
        Queue<int[]> q = new LinkedList<>();
        int initialTime = 1;
        q.offer(new int[] { sx, sy, initialTime });
        graph[sx][sy] = 2; // means traverse
        int[] dx = { 0, 0, 1, -1 };  //move only four side
        int[] dy = { 1, -1, 0, 0 };
        int ans = 0;
        while (!q.isEmpty()) {
            int[] curent = q.poll();
            int x = curent[0];
            int y = curent[1];
            int time = curent[2];
            /* if (x == 0 && time > ans) {
                ans = time;
                System.out.println(ans);
            } */
 
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx >= 0 && xx < graph.length && yy >= 0 && yy < graph[0].length && graph[xx][yy] == 1) {
                    q.offer(new int[] { xx, yy, time + 1 });
                    graph[xx][yy] = 2;
                    ans = time + 1;
                }
            }

        }
        return ans;

    }
}
