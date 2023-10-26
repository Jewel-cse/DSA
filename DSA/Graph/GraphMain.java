import java.util.ArrayList;
import java.util.Scanner;

public class GraphMain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int node = in.nextInt();
        in.nextLine();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        //adj.add(new ArrayList<>());

        //add all the adjacecny list
        for (int i = 0; i <= node; i++) {
            System.out.println("Enter a list separate by  space for node " + i);
            String s = in.nextLine();
            String[] strArr = s.split(" ");

            ArrayList<Integer> ls = new ArrayList<>();
            for (String elmt : strArr) {
                try {
                    int n = Integer.parseInt(elmt);
                    ls.add(n);
                } catch (Exception e) {
                    System.out.print("An error occurred: " + e.getMessage());
                }
            }
            adj.add(ls);
        }
        in.close();

        //print the adjacency list
        for (int i = 0; i <= node; i++) {
            System.out.println(adj.get(i));
        }
        /*
        *
        ///matrix representaion of graph
        //GraphMatrix.matrixRep(node);
        
        
        //bfs traversal@@@@@@@@@@@
        System.out.println("Bfs traversal of graph");
        System.out.println(BFS.bfsTraversalOfGraph(node, adj).toString());
        
        //dfs traversal @@@@@@@@@@@@@@@
        System.out.println("DFS traversal of graph");
        System.out.println(DFS.bfsOfGraph(node, adj).toString());
        
        
        
        // detect cycle @@@@@@@@@@@@@@
        System.out.println(checkCycle.checkForCycle(adj, node));
        
        

        // @@@@@@@@@@@@ topo sort kahns algo bfs
        //System.out.println(topoSortBFS.topoSort(node, adj).toString());

        */
        //@@@@@@@ check cycle in directed graph
        System.out.println(checkCycleForDirected.isCycleDirected(node, adj));

    }

}