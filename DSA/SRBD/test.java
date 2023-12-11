package SRBD;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
/*

15x20
1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 
1 0 1 0 1 0 1 0 1 3 0 0 1 0 1 0 1 0 1 0 
1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 
1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 
1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 
1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 
1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 
1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 
1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 
1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 
1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 
1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 
1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 
1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 
1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 
 */



public class test {
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
        int test = sc.nextInt();
        while (test-- > 0) {

            int row = sc.nextInt();
            int col = sc.nextInt();

            int[][] graph = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }
            //input done
            boolean[][] vis = new boolean[row][col];
            
           System.out.println(f(row - 1, 0, graph, vis));
        }

        sc.close();
    }

    private static int f(int r, int c, int[][] graph, boolean[][] vis) {
        
        PriorityQueue<Pair> p = new PriorityQueue<>((a,b)->a.dis - b.dis);
        p.add(new Pair(0, r, c));
        
        int ans = Integer.MIN_VALUE;
        while (!p.isEmpty()) {
            Pair it = p.poll();
            int dis = it.dis;
            int x = it.x;
            int y = it.y;
            vis[x][y] = true;

            ans = Math.max(ans, dis);
            if (graph[x][y] == 3) {
                break;
            }

            //go right
            for (int i = y + 1; i < graph[0].length; i++) {
                if (graph[x][i] == 0)
                    break;
                if (!vis[x][i]) {
                    p.add(new Pair(0, x, i));
                    break;
                }
            }
            //go left
            for (int i = y - 1; i >= 0; i--) {
                if (graph[x][i] == 0)
                    break;
                if (!vis[x][i]) {
                    p.add(new Pair(0, x, i));
                    break;
                }
            }
            //go down
            for (int i = x + 1; i < graph.length; i++) {
                if (graph[i][y] == 0)
                    continue;
                if (!vis[i][y]) {
                    p.add(new Pair(Math.abs(i - x), i, y));
                    break;
                }
            }
            //go up
            for (int i = x - 1; i >= 0; i--) {
                if (graph[i][y] == 0)
                    continue;
                if (!vis[i][y]) {
                    p.add(new Pair(Math.abs(i - x), i, y));
                    break;
                }
            }

        }
        return ans;
    }
    
}
