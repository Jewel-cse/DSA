import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bipertite {
    public static boolean isBipartite(int[][]graph) {
        //convert the matrix form to list of adjacency
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            ArrayList<Integer> ls = new ArrayList<>();
            for (int j = 0; j < graph[i].length; j++) {
                ls.add(graph[i][j]);
            }
            adj.add(i, ls);
        }

        //print adjacency list
        for (ArrayList<Integer> arrayList : adj) {
            System.out.println(arrayList.toString());
        }
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        
        for (int i = 0; i < color.length; i++) {
            if (color[i] == -1 && !check(i, adj, color)) {
                return false;
            }
        }
        return true;  
    }

    public static boolean check(int n ,ArrayList<ArrayList<Integer>> adj, int[] color) {
        
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        color[n] = 0; //consider 2 color is 0 and 1
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            for (Integer nd : adj.get(node)) {
                if (color[nd] == -1) {
                    color[nd] = 1 - color[node]; //oposit of node and adj
                    q.add(nd);
                } else if (color[nd] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        //int[][] graph = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
        //int[][] graph = { {}, { 2, 4, 6 }, { 1, 4, 8, 9 }, { 7, 8 }, { 1, 2, 8, 9 }, { 6, 9 }, { 1, 5, 7, 8, 9 },
        //        { 3, 6, 9 }, { 2, 3, 4, 6, 9 }, { 2, 4, 5, 6, 7, 8 } };

        //int[][] graph = { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
        //int[][] graph = { { 4 }, {}, { 4 }, { 4 }, { 0, 2, 3 } };
        int[][] graph = { {}, { 3 }, {}, { 1 }, {} };
        System.out.println(isBipartite(graph));
    }
}
