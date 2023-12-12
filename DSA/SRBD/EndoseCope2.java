package SRBD;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//ULTIMATE BETTER SOLUTIN  WITH LOWER SPACE COMPLEXITY 
public class EndoseCope2 {
    static class Pair {
        int x, y, len;

        Pair(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
    static int row, col;
    static int[][] arr;
    static boolean[][] vis;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            row = scanner.nextInt(); //map row
            col = scanner.nextInt(); //map col
            int x = scanner.nextInt(); //endoscope row
            int y = scanner.nextInt(); //endoscope col
            int l = scanner.nextInt(); //endoscope length

            arr = new int[row][col];
            vis = new boolean[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
            int ans = countPipeForEndoscope(x, y, l);
            System.out.println("Number of pipe can visit : "+ans);
        }
        scanner.close();
    }

    private static int countPipeForEndoscope(int x, int y, int length) {
        int numberOfpipeCanvisit = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y, 1)); //initial length 1
        vis[x][y] = true;
        while (!q.isEmpty()) {
            Pair it = q.poll();
            int r = it.x;
            int c = it.y;
            int len = it.len;

            if (len < length) {
                //left
                if (isValid(r, c - 1) && rightOpend(r, c - 1) && leftOpend(r, c)) {
                    numberOfpipeCanvisit++;
                    q.add(new Pair(r, c - 1, len + 1));
                    vis[r][c - 1] = true;
                }
                //right
                if (isValid(r, c + 1) && rightOpend(r, c) && leftOpend(r, c + 1)) {
                    numberOfpipeCanvisit++;
                    q.add(new Pair(r, c + 1, len + 1));
                    vis[r][c + 1] = true;
                }
                //up
                if (isValid(r - 1, c) && upOpend(r, c) && downOpend(r - 1, c)) {
                    numberOfpipeCanvisit++;
                    q.add(new Pair(r - 1, c, len + 1));
                    vis[r - 1][c] = true;
                }
                //down
                if (isValid(r + 1, c) && downOpend(r, c) && upOpend(r + 1, c)) {
                    numberOfpipeCanvisit++;
                    q.add(new Pair(r + 1, c, len + 1));
                    vis[r + 1][c] = true;
                }
            }
        }
        return numberOfpipeCanvisit;
    }
    
    // check for moving condition 
    private static boolean rightOpend(int r, int c) {
        return arr[r][c] == 1 || arr[r][c] == 3 || arr[r][c] == 4 || arr[r][c] == 5;
    }
    private static boolean leftOpend(int r, int c) {
        return arr[r][c] == 1 || arr[r][c] == 3 || arr[r][c] == 6 || arr[r][c] == 7;
    }
    private static boolean upOpend(int r, int c) {
        return arr[r][c] == 1 || arr[r][c] == 2 || arr[r][c] == 4 || arr[r][c] == 7;
    }

    private static boolean downOpend(int r, int c) {
        return arr[r][c] == 1 || arr[r][c] == 2 || arr[r][c] == 5 || arr[r][c] == 6;
    }

    //check booundary and vis
    private static boolean isValid(int r, int c) {
        return r >= 0 && r < arr.length && c >= 0 && c < arr[0].length && !vis[r][c];
    }
}
