import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinEffort {
    static class Pair {
        int diff;
        int row;
        int col;

        Pair(int diff, int row, int col) {
            this.diff = diff;  //maximum absolute effort
            this.row = row;
            this.col = col;
        }
        
    }

    private static int minimumEffortPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        //make distance array
        int[][] dis = new int[m][n];
        for (int[] is : dis) {
            Arrays.fill(is, (int) 1e9);
        }
        dis[0][0] = 0;

        PriorityQueue<Pair> q = new PriorityQueue<>((x,y)->x.diff-y.diff);
        q.add(new Pair(0, 0,0));
        
        int[][] d = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
    
        while (!q.isEmpty()) {
            Pair curent = q.poll();
            int diff = curent.diff;
            int x = curent.row;
            int y = curent.col;
            //anser is found
            if (x == m-1 && y == n-1) {
                return diff;
            }
            for (int i = 0; i < 4; i++) {
                int xx = x + d[i][0];
                int yy = y + d[i][1];
                //boundary validation
                if (xx >= 0 && xx < m && yy >= 0 && yy < n) {
                    //indivudal max difference
                    int newEffort = Math.max(diff, Math.abs(grid[xx][yy] - grid[x][y]));
                    //new efffort mini holei pq te add....
                    if (newEffort < dis[xx][yy]) {
                        q.offer(new Pair(newEffort, xx, yy));
                        dis[xx][yy] = newEffort;
                    }
                }
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };

        System.out.println(minimumEffortPath(grid));
    }

    
}
