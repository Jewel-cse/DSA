import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class findProvinces {
    public static int findNumOfProvinces(int[][] num, int n) {
        // Write your code here.
        int provinces = 0;
        boolean[] vis = new boolean[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // create a list from matrix
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> ls = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (num[i][j] == 1) {
                    ls.add(j);
                }
            }
            adj.add(i, ls);
        }
        //dispaly the adjacency list
        for (ArrayList<Integer> arrayList : adj) {
            System.out.println(arrayList.toString());
        }

        //visit 
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) { /// joto ta unvisited node pawa jabe toto ta provinces
                provinces++;
                travereBFS(adj, vis,i);
                System.out.println(Arrays.toString(vis));
            }
        }

        return provinces;
    }

    //bfs traverse korle sob connected gula visited hobe
    public static void travereBFS(ArrayList<ArrayList<Integer>> adj, boolean[] vis,int vertex) {
        Queue<Integer> q = new LinkedList<>();
        q.add(vertex);
        vis[vertex] = true;
        while (!q.isEmpty()) {
            Integer node = q.poll();
            for (Integer nd : adj.get(node)) {
                if (!vis[nd]) {
                    q.add(nd);
                    vis[nd] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        //int[][] roads = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
        int[][] roads = {{1, 1, 0, 0 },
            {1, 1, 0, 0 },
            {0, 0, 1, 1} ,
            { 0, 0, 1, 1 } };
        System.out.println(findNumOfProvinces(roads, roads.length));

    }
}
