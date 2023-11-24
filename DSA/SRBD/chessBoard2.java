package SRBD;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class chessBoard2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int m = scanner.nextInt(); //row
            int n = scanner.nextInt(); //column
            int[][]arr = new int[m][n];
            boolean[][]vis = new boolean[m][n];

            System.out.println("position of first knight: ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println("position of target knight: ");
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();

            int ans = bfs_minDistanceToCatch(new int[]{x,y},new int[]{x1,y1},m,arr,vis);
            System.out.println(ans);
        }
        scanner.close();
    }

    private static int bfs_minDistanceToCatch(int[] k1, int[] k2, int m, int[][] arr,boolean[][] vis) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(k1[0], k1[1], 0));
        vis[k1[0]][k1[1]] = true;
        int[] dx = {2,2,1,-1,-2,-2,1,-1};
        int[] dy = {-1,1,2,2,-1,1,-2,-2};
        while (!q.isEmpty()) {
            int r = q.peek().x;
            int c = q.peek().y;
            int distance = q.peek().distance;
            q.poll();
            for (int i = 0; i < 8; i++) {
                int xx = r + dx[i];
                int yy = c + dy[i];
                //validation 
                if (xx >= 0 && yy >= 0 && xx < m && yy < m && ! vis[xx][yy] && xx != k2[0] && yy != k2[1] ) {
                    q.add(new Pair(xx, yy, distance + 1));
                    vis[xx][yy] = true; 
                } else if (xx == k2[0] && yy == k2[1]) {  //i am on position of other knight
                    return distance + 1;
                }
            }

        }
        
        return -1;
    }

    static class Pair {
        int x;
        int y;
        int distance;

        Pair(int x, int y, int d) {
            this.x = x;
            this.y = y;
            distance = d;
        }
    }
}
