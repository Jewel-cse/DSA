package SRBD;
/*
Sample Input:
2

5
0 0 0 2 0
2 1 0 1 2
0 0 2 2 0
0 1 0 1 2
2 0 0 0 0
6
0 1 2 1 0 0
0 1 0 0 0 0
0 1 2 1 2 1
0 2 0 1 0 2
0 1 0 1 0 1
2 0 2 1 0 0

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test {

    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberofnode = sc.nextInt();
        int numberofEdge = sc.nextInt();

        int[][] edges = new int[numberofEdge][2];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numberofnode + 1; i++) {
            adj.add(new ArrayList<>());
        }
        //take input edges
        for (int i = 0; i < numberofEdge; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();

            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]); //done adjacency list
        }

        //is bicolorable
        System.out.println("Is bicolorable graph : " + isbicolorable(adj));
        //check cycle for undirected graph
        System.out.println("Has cycle of the graph: " + isCycle(numberofnode, adj));
    }
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ CICYLE OF UNDIRECTED @@@@@@@@@@@@@@@@@@@@@
    private static boolean isCycle(int numberofnode, ArrayList<ArrayList<Integer>> adj) {
        //need vis,v,adj
        boolean[] vis = new boolean[numberofnode];
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                if (HasCycle(i, -1, adj, vis))
                    return true;
            }
        }
        return false;
    }

    private static boolean HasCycle(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for (Integer adjnd : adj.get(node)) {
            if (!vis[adjnd]) {
                if (HasCycle(adjnd, node, adj, vis))
                    return true;
                else if (adjnd != parent)
                    return true;
            }
        }
        return false;
    }
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    //////////////@@@@@@@@@@@@@@ IS BICOLORABLE @@@@@@@@@@@@@@@@@@@@@@@@@@@@
    private static boolean isbicolorable(ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[adj.size()];
        Arrays.fill(color, -1);
        for (int i = 0; i < color.length; i++) {
            if (color[i] == -1 && !isBipartite(i, adj, color))
                return false;
        }
        return true;
    }

    private static boolean isBipartite(int i, ArrayList<ArrayList<Integer>> adj, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i] = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (Integer adjNode : adj.get(node)) {
                if (color[adjNode] == -1) { //not visited
                    color[adjNode] = 1 - color[node];
                    q.add(adjNode);
                } else if (color[adjNode] == color[node])
                    return false;
            }
        }
        return true;
    }
    
}
