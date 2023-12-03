package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MColor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //decorate input and make adjacency list
        //int[][] edges = { { 0, 1, 0 }, { 1, 0, 1 }, { 0, 1, 0 } };
        int n = sc.nextInt();
        int numberofcolor = sc.nextInt();
        int[][] edges = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                edges[i][j] = sc.nextInt();
            }
        }
        ArrayList<List<Integer>> adj = buildAdj(edges);
        for (List<Integer> list : adj) {
            System.out.println(list.toString());
        }
        int[] color = new int[n + 1];
        boolean check = graphcoloring(0, adj.size(), numberofcolor, adj, color);
        System.out.println(check);

        sc.close();
    }

    //@@@@@@@@@@@@@@ key point of this algo
    /*
    base case: start node == lastnode+1 then true. means color done@
    start form 1st node,> color the from 1 to m
    if posible go next 
     */
    private static boolean graphcoloring(int node, int lastNode, int m, ArrayList<List<Integer>> adj, int[] color) {
        if (node == lastNode)
            return true;
        for (int clr = 1; clr <= m; clr++) {
            if (possible(clr, node, adj, color)) {
                color[node] = clr;
                if (graphcoloring(node + 1, lastNode, m, adj, color))
                    return true;
                color[node] = 0;
            }
        }
        return false;
    }

    private static boolean possible(int clr, int node, ArrayList<List<Integer>> adj, int[] color) {
        //if adjacent node color same return false...
        for (Integer adjnd : adj.get(node)) {
            if (color[adjnd] == clr)
                return false;
        }

        return true;
    }
    //####################
    private static ArrayList<List<Integer>> buildAdj(int[][] mat) {
        int n = mat.length;
        ArrayList<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != 0) {
                    adj.get(i).add(j);
                }
            }

        }
        return adj;
    }

}
/*

10 2
0 0 0 0 0 0 0 0 0 0 
0 0 0 0 0 1 0 0 0 0 
0 0 0 0 0 1 0 0 0 1 
0 0 0 0 0 1 1 0 0 0 
1 0 0 0 0 0 0 0 0 0 
0 1 1 1 0 0 0 0 0 0 
1 0 0 1 0 0 0 0 0 1 
0 0 0 0 0 0 0 0 1 0 
0 0 0 0 0 0 0 1 0 0 
0 0 1 0 0 0 1 0 0 0 
ans:  False

3 2
0 1 0
1 0 1
0 1 0

ans: yes
 */
