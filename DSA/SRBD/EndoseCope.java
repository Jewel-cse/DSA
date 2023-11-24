package SRBD;

import java.util.*;

class EndoseCope {
    //create new data type for pipe
    static class Point {
        boolean up, down, left, right;

        public Point() {
            this.up = this.down = this.left = this.right = false;
        }
    }

    static int n, m;
    static int[][] arr;
    static boolean[][] vis;
    static Point[][] pipe;

    //boundary validation 
    static boolean isValid(int x, int y) {
        return x < n && y < m && x >= 0 && y >= 0 && !vis[x][y];
    }
    //BFS technique for count number of pipe
    static int countPipeForEndoscope(int x, int y, int l) {
        int ans = 1;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y,1});
        vis[x][y] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
            int level = current[2];
            if (level<l) {
                if (isValid(r + 1, c) && pipe[r + 1][c].up && pipe[r][c].down) {
                    q.offer(new int[]{r + 1, c,level+1});
                    vis[r + 1][c] = true;
                    ans++;
                }
                if (isValid(r - 1, c) && pipe[r - 1][c].down && pipe[r][c].up) {
                    q.offer(new int[]{r - 1, c,level+1});
                    vis[r - 1][c] = true;
                    ans++;
                }
                if (isValid(r, c + 1) && pipe[r][c + 1].left && pipe[r][c].right) {
                    q.offer(new int[]{r, c + 1,level+1});
                    vis[r][c + 1] = true;
                    ans++;
                }
                if (isValid(r, c - 1) && pipe[r][c - 1].right && pipe[r][c].left) {
                    q.offer(new int[]{r, c - 1,level+1});
                    vis[r][c - 1] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
    ////@@@@@@@@@ Main function @@@@@@@@@@@
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            n = scanner.nextInt(); //map row
            m = scanner.nextInt(); //map col
            int x = scanner.nextInt(); //endoscope row
            int y = scanner.nextInt(); //endoscope col
            int l = scanner.nextInt(); //endoscope length

            arr = new int[n][m];
            vis = new boolean[n][m];
            pipe = new Point[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = scanner.nextInt();
                    pipe[i][j] = new Point();   //just initailize pipe
                }
            }
            makePipe(arr, pipe); // build pipe using arr
            int ans = countPipeForEndoscope(x, y, l);
            System.out.println(ans);
        }
        scanner.close();
    }

    private static void makePipe(int[][] arr, Point[][] pipe) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                switch (arr[i][j]) {
                    case 1:
                        pipe[i][j].left = pipe[i][j].right = pipe[i][j].up = pipe[i][j].down = true;
                        break;
                    case 2:
                        pipe[i][j].up = pipe[i][j].down = true;
                        break;
                    case 3:
                        pipe[i][j].left = pipe[i][j].right = true;
                        break;
                    case 4:
                        pipe[i][j].right = pipe[i][j].up = true;
                        break;
                    case 5:
                        pipe[i][j].right = pipe[i][j].down = true;
                        break;
                    case 6:
                        pipe[i][j].left = pipe[i][j].down = true;
                        break;
                    case 7:
                        pipe[i][j].left = pipe[i][j].up = true;
                        break;
                }
            }
        }
    }
}


/*
2 > test case number

5 6 2 1 3 >>> height, width ,vertical loc ,hor loc, length of endoscope
0 0 5 3 6 0 
0 0 2 0 2 0 
3 3 1 3 7 0 
0 0 0 0 0 0 
0 0 0 0 0 0 

ans: 5

5 6 2 2 6    >>>>
3 0 0 0 0 3 
2 0 0 0 0 6 
1 3 1 1 3 1 
2 0 2 0 0 2 
0 0 4 3 1 1

ans: 15
*/
