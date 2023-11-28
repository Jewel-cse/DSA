package SRBD;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
https://www.careercup.com/question?id=14989765
http://ideone.com/oXdBaF

Given a 2 D matrix where 1 represent the places where the frog can jump and 0 represent the empty spaces,
the frog can move freely in horizontal direction (on 1’s only) without incurring any cost (jump). 
A vertical jump from a given point of the matrix to other point on the matrix can be taken (on 1’s only) 
with cost as the number of jumps taken.
Given a source and destination, the frog has to reach the destination minimizing the cost (jump).
*/
public class FrogJump2D {
    //make for queue
    static class Place {
        int r, c, distance;

        Place(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            //input sections.................
            int row = sc.nextInt();
            int col = sc.nextInt();
            int[][] mat = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    mat[i][j] = sc.nextInt();
                }

            }

            //go to the function and calculate mindistance..........
            boolean[][] vis = new boolean[row][col];
            int mindistance = findMindistance(0, 0, row-1, col-1, mat,vis);
            System.out.println("Min distance: " + mindistance);
            sc.close();
        }
    }
    private static int findMindistance(int sx, int sy, int ex, int ey, int[][] mat,boolean[][]vis) {
        Queue<Place> q = new LinkedList<>();
        q.add(new Place(sx, sy, 0));
        vis[sx][sy] = true;
        int[][] dir = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } }; // first two is horizontal ,last two is vertical direction
        int ans = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Place it = q.poll();
            int r = it.r;
            int c = it.c;
            int distance = it.distance;
            if (r == ex && c == ey) { // we can optimize......
                ans = Math.min(ans, distance);
            }
            for (int i = 0; i < 4; i++) {
                int xx = r + dir[i][0];
                int yy = c + dir[i][1];

                //validation check
                if (xx >= 0 && xx < mat.length && yy >= 0 && yy < mat[0].length && !vis[xx][yy]) {
                    if (i <= 1) { //horizontal direction, not distance increase
                        q.add(new Place(xx, yy, distance));
                    } else { //horizontal direction, not distance increase
                        q.add(new Place(xx, yy, distance + 1));
                    }
                    vis[xx][yy] = true;
                }
            }
        }
        return ans != Integer.MAX_VALUE ? ans:-1; //-1 means not possible...
    }
}
