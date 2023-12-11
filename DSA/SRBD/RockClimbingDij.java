package SRBD;

import java.util.*;

///@@@@@@@@@@@@@ ULTIMATE BETTER SOLUTION FOR THE VALUE OF ROW, COL >10
public class RockClimbingDij {
    static class Pair {
        int dis, x, y;

        Pair(int dis, int x, int y) {
            this.dis = dis;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] map = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        //get min climb
        boolean[][] vis = new boolean[row][col];
        System.out.println(f(row - 1, 0, map, vis));
    }

    private static int f(int sr, int sc, int[][] map, boolean[][] vis) {

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        q.add(new Pair(0, sr, sc));
        int ans = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            Pair it = q.poll();
            int dis = it.dis;
            int x = it.x;
            int y = it.y;

            vis[x][y] = true;
            ans = Math.max(ans, dis);   // minimum max jump
            if (map[x][y] == 3)
                break;
            //go right
            for (int c = y + 1; c < map[0].length; c++) {
                if (map[x][c] == 0)
                    break;
                if (!vis[x][c]) {
                    q.add(new Pair(0, x, c));
                    break;
                }
            }
            //go left
            for (int c = y - 1; c >= 0; c--) {
                if (map[x][c] == 0)
                    break;
                if (!vis[x][c]) {
                    q.add(new Pair(0, x, c));
                    break;
                }
            }
            //go down
            for (int r = x + 1; r < map.length; r++) {
                if (map[r][y] == 0)
                    continue;
                if (!vis[r][y]) {
                    q.add(new Pair(r - x, r, y));
                    break;
                }
            }
            //go up
            for (int r = x - 1; r >= 0; r--) {
                if (map[r][y] == 0)
                    continue;
                if (!vis[r][y]) {
                    q.add(new Pair(x - r, r, y));
                    break;
                }
            }

        }
        return ans;
    }
}
