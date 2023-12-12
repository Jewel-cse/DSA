package SRBD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/*  detect cycle in graph:
    vist + path add : if node is exists in path then it has a cycle
    create list from index where node exists in pathlist to last : cycle list
    all the list store another list
            
    take one by one list and sum of node store corresponding index
    min sum index sort and return 
    */
    
public class DetectNPrintSmallestcycleDirected {
    
    // DFS CYCLE DETECT AND CREATE CYCLE LIST
    //need node,adj, vis[],pathList,cycleList
    private static int mx = (int) 1e9;
    private static void findCycleList(int node, List<List<Integer>> adj, boolean[] vis, List<Integer> pathList,
            List<List<Integer>>cyList) {
        
        vis[node] = true;
        pathList.add(node);
        for (Integer adjnode : adj.get(node)) {
            if (!vis[adjnode]) {
                findCycleList(adjnode, adj, vis, pathList, cyList);
            } else if (pathList.contains(adjnode)) { //means cycle exists
                List<Integer> clist = new ArrayList<>(pathList.subList(pathList.indexOf(adjnode), pathList.size()));
                int sum = addelement(clist);
                if (sum < mx) {
                    if (!cyList.isEmpty()) { // values contains large sum
                        cyList.clear(); //so remove it  
                    }
                    //and add hashmap to smallest cycle list
                    mx = sum;
                    Collections.sort(clist);
                    cyList.add(clist);
                }
            }
        }
        vis[node] = false;
        pathList.remove(pathList.size() - 1);
    }
    private static int addelement(List<Integer> clist) {
        int sum = 0;
        for (Integer element : clist) {
            sum += element;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(); //number of node
            int NOfedge = sc.nextInt(); //number of edge

            int[][] edges = new int[n + 1][2]; // 0 node included
            //create adjacency dummy list
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                adj.add(new ArrayList<>());
            }
            //take input edges and put adj list
            for (int i = 0; i < NOfedge; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                adj.get(edges[i][0]).add(edges[i][1]); //directed graph
            }
            //find the cycle
            boolean[] vis = new boolean[n + 1];
            List<Integer> pathList = new ArrayList<>();
            List<List<Integer>> cycleList = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                if (!vis[i]) {
                    findCycleList(i, adj, vis, pathList, cycleList);
                }
            }
            for (Integer element : cycleList.get(0)) {
                System.out.print(element + " ");
            }

        }
        sc.close();
    }

}
/*
test case

5 5
1 2 2 4 4 5 5 3 3 2
ans: 2 3 4 5 

5 5
2 4 2 3 4 3 1 5 5 1
ans: 1 5

7 8
1 2 2 3 2 4 4 5 5 6 6 2 3 7 3 6
 */
