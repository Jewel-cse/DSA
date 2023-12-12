package SRBD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BiColoring {
    // this method take input edges and provide the adjacency list
    private static List<List<Integer>> buildAdj(int[][] edges) {
        int vertics = edges.length+1; // no of vertics = number of edge + 1
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertics; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u); //for undirected graph
        }
        return adj;
    }

    private static boolean isBicolorable(List<List<Integer>> adj) {
        int[] color = new int[adj.size()];
        Arrays.fill(color,-1);
        for (int i = 0; i < color.length; i++) {
            if (color[i] == -1 && !isBipartite(i, adj, color))
                return false;
        }
        return true;
    }

    private static boolean isBipartite(int i, List<List<Integer>> adj, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i] = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (Integer nd : adj.get(node)) {
                if (color[nd] == -1) {
                    color[nd] = 1 - color[node];
                    q.add(nd);
                }
                else if(color[nd] == color[node])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t, vertics;
        t = sc.nextInt();
        while (t-->0) {
            
            vertics = sc.nextInt();
            int edges[][] = new int[vertics][2];
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < vertics+1; i++)
                adj.add(new ArrayList<>());
            for (int i = 0; i < vertics; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                
                adj.get(edges[i][0]).add(edges[i][1]);   //undirected graph
                adj.get(edges[i][1]).add(edges[i][0]);
            }
            //int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 4 }, { 3, 5 }, { 4, 5 } };

            /* 
             for (List<Integer> list : aj) {
             System.out.println(list.toString());
             }
             */
            boolean isBicolorable = isBicolorable(adj);
            System.out.println(isBicolorable ? "BICLORABLE" : "NOT BICOLORABLE");
        }
    }

}
