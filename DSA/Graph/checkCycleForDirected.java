import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class checkCycleForDirected {
    /*
     * We use topo sort: bcz topo sort is aplicable only directed acyclid graph,
     * after topo sort if the result list size is equal the number of node then we understand there is no cycle and
     * return false other wise false.
     * 
     */
    public static boolean isCycleDirected(int node, ArrayList<ArrayList<Integer>> adj) {
        List<Integer> topoList = topoSortBFS.topoSort(node, adj);
        if (topoList.size() == (node + 1))
            return false;
        return true;
    }
    public static List<Integer> topoSort(int v, ArrayList<ArrayList<Integer>> adj) {

        //Its posible only : Directed Acyclic graph, cycle thaka jabe na
        /*
         * 1. indegree array create
         * 2. queue te add whcit indegree 0
         * 3. indegree decrease using adjacency
         * 
         */
        //@@@@1
        int[] indegree = new int[v + 1];
        for (int i = 0; i < indegree.length; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        //@@@@@@@@@@2
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        //@@@@@@@@3
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.peek();
            topo.add(node); //result
            q.poll();
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.add(it);
            }
        }
        return topo;
    }
}
