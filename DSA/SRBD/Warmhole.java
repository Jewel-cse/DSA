package SRBD;

import java.util.Scanner;
/*
Probelm description: https://www.hackerrank.com/contests/target-samsung-13-nov19/challenges/warmholes/problem
    Technique: (DFS)
        :start each warmhole 
            > start - wfront-wend - end
            > start - w end - wfront - end
            >take only minimun cost
*/

public class Warmhole {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int numberOfWH = sc.nextInt();
            int stx = sc.nextInt();
            int sty = sc.nextInt();
            int endx = sc.nextInt();
            int endy = sc.nextInt();

            int[][] w = new int[numberOfWH][5];
            for (int i = 0; i < numberOfWH; i++) {
                w[i][0] = sc.nextInt(); //wh start cordinate
                w[i][1] = sc.nextInt();
                w[i][2] = sc.nextInt(); //wh end cordinate
                w[i][3] = sc.nextInt();
                w[i][4] = sc.nextInt(); //cost wh
            }
            //find minimum cost
            boolean[] vis = new boolean[numberOfWH];
            int ans[] = new int[1];
            ans[0] = (int) 1e9;
            Mincost(stx, sty, endx, endy, 0, w, vis, ans);
            System.out.println(ans[0]);
        }
        sc.close();
    }

    private static void Mincost(int sx, int sy, int ex, int ey, int value, int[][] w, boolean[] vis, int[] ans) {
        ans[0] = Math.min(ans[0], dis(sx, sy, ex, ey) + value);
        for (int i = 0; i < w.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                //start - wfront-wend - des
                int temp1 = dis(sx, sy, w[i][0], w[i][1]) + value + w[i][4];
                Mincost(w[i][2], w[i][3], ex, ey, temp1, w, vis, ans);
                // start - wend - wfront - des
                int temp2 = dis(sx, sy, w[i][2], w[i][3]) + value + w[i][4];
                Mincost(w[i][0], w[i][1], ex, ey, temp2, w, vis, ans);
                //now backtrak
                vis[i] = false;
            }
        }
    }

    private static int dis(int sx, int sy, int ex, int ey) {
        return Math.abs(sx - ex) + Math.abs(sy - ey);
    }
}
/*
1
3
0 0 100 100
1 2 120 120 16
2 5 120 100 21
6 8 150 180 16

ans : 48
 */
