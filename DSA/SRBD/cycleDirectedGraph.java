package SRBD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cycleDirectedGraph {
    ///////@@@@@@@@ build adjacency list for @@@@@@@@@ directed graph
    private static List<List<Integer>> buildAdjforDirectedGraph(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        return adj;
    }
    ///@@@@@@@@@@@ dfs technique for detection cycle of directed graph...........
    private static boolean isCycle_dfs(int node, int parent, List<List<Integer>> adj, boolean[] vis, boolean[] pathVis) {
        vis[node] = true;
        pathVis[node] = true;
        for (Integer adjnd : adj.get(node)) {
            if (!vis[adjnd]) {
                if (isCycle_dfs(adjnd, node, adj, vis, pathVis))
                    return true;
            } else if (pathVis[adjnd])
                return true;
        }
        pathVis[node] = false;  // extra path visited array 
        return false;
    }
    private static boolean detectCycle(int n, List<List<Integer>> adj) {
        boolean[] vis = new boolean[n];
        boolean[] pathVis = new boolean[n];
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                if (isCycle_dfs(i, -1, adj, vis, pathVis))
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            int edge = sc.nextInt();
            int[][] edges = new int[edge][2];
            for (int i = 0; i < edge; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }
            List<List<Integer>> adj = buildAdjforDirectedGraph(n, edges);
            //need vis and pathvisited aray
            System.out.println(detectCycle(n,adj));
        }
    }
    
}
