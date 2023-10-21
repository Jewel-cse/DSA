import java.util.LinkedList;
import java.util.Queue;

public class RotateOrange {
    public static void main(String[] args) {
        //int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        
        if (grid == null || grid.length == 0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int freshCnt = 0;
        Queue<int[]> q = new LinkedList<>();

        //queue te rotate orange er position and countfresh orange + rotate orange
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j });
                }
                if (grid[i][j] != 0)
                    freshCnt++;
            }
        }
        System.out.println(freshCnt);
        if (freshCnt == 0)
            return 0;
        //
        int countMinute = 0;
        int newFreshCount = 0;

        int[] drow = { -1, 1, 0, 0 };
        int[] dcol = { 0, 0, -1, 1 };
        while (!q.isEmpty()) {
            int size = q.size();
            newFreshCount += size;
            for (int i = 0; i < size; i++) {
                int[] rotatePosition = q.poll();
                for (int j = 0; j < 4; j++) {
                    int newrotateRow = rotatePosition[0] + drow[j];
                    int newrotateCol = rotatePosition[1] + dcol[j];
                    if (newrotateRow < 0 || newrotateRow >= rows || newrotateCol < 0 || newrotateCol >= cols
                            || grid[newrotateRow][newrotateCol] == 0 || grid[newrotateRow][newrotateCol] == 2)
                        continue;
                    grid[newrotateRow][newrotateCol] = 2;
                    q.offer(new int[] { newrotateRow, newrotateCol });
                }
        
            }
            if (q.size() != 0) {
                countMinute++;
                System.out.println(countMinute);
            }
        }
        return (freshCnt == newFreshCount) ? countMinute : -1;
    }
}
