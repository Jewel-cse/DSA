package SRBD;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class CycleUndirected {
    static class Pair {
        int node;
        int parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
    //@@@make adjacency list from graph.........
    private static List<List<Integer>> buildAdj(int n,int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }
    //cycle detection @@@ BFS TECHNIQUE
    private static boolean checkCycle_BFS(int src, List<List<Integer>> adj, boolean[] vis) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));
        vis[src] = true;
        while (!q.isEmpty()) {
            int node = q.peek().node;
            int parent = q.peek().parent;
            q.poll();
            for (Integer adjnd : adj.get(node)) {
                if (!vis[adjnd]) {
                    vis[adjnd] = true;
                    q.add(new Pair(adjnd, node));
                } else if (adjnd != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    //cycle detection @@@@@@@@@  DFS TECHNIQUE
    private static boolean checkCycle_DFS(int node, int parent, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for (Integer adjnd : adj.get(node)) {
            if (!vis[adjnd]) {
                if (checkCycle_DFS(adjnd, node, adj, vis))
                    return true;
            }
            else if (adjnd != parent)
                return true;
        }
        return false;
    }

    /// check for the cycle of @@@@@@@ UNDIRECTED graph
    private static boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V]; //node start from 0 to n-1
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                //if (checkCycle_BFS(i, adj, vis))
                if(checkCycle_DFS(i, -1, adj, vis))
                    return true;
            }
        }
        return false;
    }
    
    
    ///@@@@@@@@@@@@@@ MAIN FUNCTION 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int v = sc.nextInt();   //number of vertics
            int edge = sc.nextInt();  // number of edges
            int[][] edges = new int[edge][2];
            for (int i = 0; i < edge; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }
            List<List<Integer>> adj = buildAdj(v, edges);
            for (List l : adj) {
                System.out.println(l.toString());
            }
            System.out.println(isCycle(v, adj));
        }
    }
}
