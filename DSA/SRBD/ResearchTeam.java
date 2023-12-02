package SRBD;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//problem statement: https://www.careercup.com/question?id=5707238197952512
public class ResearchTeam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            //take number of size
            int gridSize = sc.nextInt();
            int numberOfrareElement = sc.nextInt();

            //store rare element
            int[][] rare = new int[numberOfrareElement][2];
            for (int i = 0; i < numberOfrareElement; i++) {
                rare[i][0] = sc.nextInt();
                rare[i][1] = sc.nextInt();
            }
            //take grid 
            int[][] grid = new int[gridSize][gridSize];
            for (int i = 0; i < gridSize; i++) {
                for (int j = 0; j < gridSize; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            //replace rare element into grid
            for (int i = 0; i < numberOfrareElement; i++) {
                grid[rare[i][0] - 1][rare[i][1] - 1] = 5;
            }
            //strt from 00 to all rare element
            int[][] dis = new int[gridSize][gridSize];
            boolean[][] vis = new boolean[gridSize][gridSize];
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < gridSize; i++) {
                for (int j = 0; j < gridSize; j++) {
                    if (grid[i][j] != 0) {
                        dis[i][j] = getmaxdistance(i, j, numberOfrareElement, grid, vis);
                        //System.out.print(dis[i][j] + " ");
                        if (dis[i][j] != 0)
                            min = Math.min(dis[i][j], min);
                        clearVis(vis);
                    }
                }
            }
            System.out.println("minimum : " + min);
        }
        sc.close();
    }

    private static void clearVis(boolean[][] vis) {
        for (boolean[] bs : vis) {
            Arrays.fill(bs, false);
        }
    }

    private static int getmaxdistance(int x, int y, int numberOfrareElement, int[][] grid, boolean[][] vis) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { x, y, 0 });
        vis[x][y] = true;
        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        int ans = 0;  //find max
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
            int d = current[2];
            if (numberOfrareElement < 0)
                break;
            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                //check for validity
                if (isValid(nr, nc, grid, vis) && numberOfrareElement > 0) {
                    if (grid[nr][nc] == 5)
                        numberOfrareElement--; // 1 ta peye gesi find less
                    vis[nr][nc] = true;
                    q.add(new int[] { nr, nc, d + 1 });

                    if (numberOfrareElement == 0) {
                        ans = d + 1 > ans ? d + 1 : ans;
                    }
                }
            }

        }
        return ans;
    
    }

    private static boolean isValid(int nr, int nc, int[][] grid, boolean[][] vis) {
        return nr>=0 && nr<grid.length && nc >= 0 && nc <grid[0].length && grid[nr][nc] != 0 && !vis[nr][nc];
    }
}
/*

7 == test number ;
5 2
4 3
3 4
1 1 0 0 0
1 1 0 0 0
1 1 1 1 1
1 1 1 0 1
1 1 1 1 1
ans :  1

8 2
5 6
6 4
1 1 1 1 1 1 0 0
1 1 1 1 1 1 1 0
1 1 0 1 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 1 1 1 0
1 1 1 1 1 1 1 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
ans : 2

10 3
8 2
5 3
7 1
0 0 0 1 1 1 1 1 1 0
1 1 1 1 1 1 1 1 1 0
1 0 0 1 0 0 0 0 1 0
1 1 1 1 1 1 1 1 1 1
1 1 1 1 0 1 0 0 1 1
1 1 1 1 0 1 0 0 1 1
1 1 1 1 0 1 0 0 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 0 0 1 0 0 1 1
1 1 1 1 1 1 1 1 1 1
ans: 2

15 4
11 15
15 9
1 2
14 3
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 0 1 1 1 1 1 1 1 1 1 1 1 0 1
1 0 1 0 0 0 1 0 0 0 0 1 1 0 1
1 0 1 0 0 0 1 0 0 0 0 1 1 0 1
1 0 1 1 1 1 1 1 1 1 1 1 1 1 1
1 0 1 0 0 0 1 0 0 0 0 1 1 0 1
1 0 1 0 0 0 1 1 1 1 1 1 1 1 1
1 0 1 0 0 0 1 0 0 0 0 1 1 0 1
1 0 1 0 0 0 1 0 0 0 0 1 1 0 1
1 0 1 0 0 0 1 0 0 0 0 1 1 0 1
1 0 1 0 0 0 1 0 0 0 0 1 1 0 1
1 0 1 0 0 0 1 0 0 0 0 1 1 0 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
0 0 1 0 0 0 1 1 1 1 1 1 1 0 1
0 0 1 1 1 1 1 1 1 1 1 1 1 1 1
ans : 12

20 4
13 6
20 4
1 2
17 16
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0
1 0 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0
1 0 1 0 0 0 0 0 0 0 1 0 0 1 1 0 0 0 0 0
1 0 1 0 0 0 0 0 0 0 1 0 0 1 1 0 0 0 0 0
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0
1 0 1 0 0 0 0 0 0 0 1 0 0 1 1 1 0 0 0 0
1 0 1 0 0 0 0 0 0 0 1 0 0 1 1 1 0 0 0 0
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 0 1 0 0 0 0 0 0 0 1 0 0 1 1 1 0 0 1 1
1 0 1 0 0 0 0 0 0 0 1 0 0 1 1 1 0 0 1 1
1 0 1 0 0 0 0 0 0 0 1 0 0 1 1 1 0 0 1 1
1 0 1 0 0 0 0 0 0 0 1 0 0 1 1 1 0 0 1 1
1 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 1 1
1 0 1 0 0 0 0 0 0 0 1 0 0 0 1 1 0 0 1 1
1 0 1 0 0 0 0 0 0 0 1 0 0 0 1 1 0 0 1 1
1 0 1 0 0 0 0 0 0 0 1 0 0 0 1 1 0 0 1 1
1 0 1 0 0 0 0 0 0 0 1 0 0 0 1 1 0 0 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 0 0 0
ans : 15

5 2
2 1
3 5
1 0 1 1 1
1 1 1 0 1
0 1 1 0 1
0 1 0 1 1
1 1 1 0 1
ans: 4


3 2
1 1
3 3
1 1 1
1 1 1
1 1 1
ans: 2


*/
