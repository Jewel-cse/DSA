import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMaze {
    /**
     * Inner class Pair
     */
    static class Pair {
        int distance;
        int row;
        int col;

        Pair(int distance, int row, int col) {
            this.distance = distance;
            this.row = row;
            this.col = col;
        }
        
    }

    private static int shortestPathBinaryMatrix(int src[], int des[], int[][] grid, boolean[][] vis) {
        if(grid[src[0]][src[1]] != 0 || grid[des[0]][des[1]] != 0)
            return -1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, src[0], src[1]));
        vis[src[0]][src[1]] = true;
        int[][] d = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
        int minDis = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Pair curent = q.poll();
            int dis = curent.distance;
            int x = curent.row;
            int y = curent.col;
            for (int i = 0; i < 8; i++) {
                int xx = x + d[i][0];
                int yy = y + d[i][1];
                //boundary validation
                if (isValid(xx, yy, grid, vis)) {
                    if (xx == des[0] && yy == des[1] && minDis > dis + 1)
                        minDis = dis + 1;
                    q.add(new Pair(dis + 1, xx, yy));
                    vis[xx][yy] = true;
                }
            }
        }
        return minDis != Integer.MAX_VALUE ? minDis : -1;
    }
    private static boolean isValid(int xx, int yy, int[][] grid,boolean[][]vis) {
        return xx>=0 && xx<grid.length && yy >=0 && yy < grid[0].length && grid[xx][yy] == 0 && !vis[xx][yy];
    }
    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
        //int[][] grid = { { 1, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        System.out.println(shortestPathBinaryMatrix(new int[]{0,0}, new int[]{grid.length-1,grid[0].length-1}, grid, vis));
    }
}
