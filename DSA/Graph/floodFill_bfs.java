import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class floodFill_bfs {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int[][] vis = new int[m][n];

        //for 4-direction
        int[] h = { -1, 0, 1, 0, 0 };
        int[] v = { 0, -1, 0, 1, 0 };

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        while (!q.isEmpty()) {
            int r = q.peek().first;
            int c = q.peek().second;
            q.poll();
            for (int i = 0; i < h.length; i++) {
                int nr = r + h[i];
                int nc = c + v[i];
                if (nr>=0 && nr<m && nc>= 0 && nc<n&& vis[nr][nc] != 1 && image[nr][nc] != 0) {
                    image[nr][nc] = color;
                    vis[nr][nc] = 1;
                    q.add(new Pair(nr, nc));
                }

            }
        }
        return image;
    }
    public static void main(String[] args) {
        //int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int[][] image = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        floodFill(image, 0, 0, 0);
        for (int[] is : image) {
            System.out.println(Arrays.toString(is));
        }
    }
}
