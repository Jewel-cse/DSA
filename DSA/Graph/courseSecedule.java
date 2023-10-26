import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class courseSecedule {
    public static int[] canFinish(int v, int[][] prerequisites) {
        
        //create adjacencylist
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        /*
        for (ArrayList<Integer> arrayList : adj) {
            System.out.println(arrayList.toString());
        }
        
        */

         //indegree array...............
         int[] indegree = new int[v];
         for (int i = 0; i < v; i++) {
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
         int count = 0;
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.peek();
            count++;
            topo.add(node); //result
            q.poll();
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.add(it);
            }
        }
        //return count == v;    //for 1
        System.out.println(topo.toString());
        
        // return topo.size() == v;   //for 1
       Collections.reverse(topo);
       int[] ans = new int[topo.size()];
       for (int i = 0; i < topo.size(); i++) {
           ans[i] = topo.get(i);
       }
       
       return ans;
    }
   
    
    public static void main(String[] args) {
        int[][] prerequisites = { {1,0},{2,0},{3,1},{3,2} };
        //canFinish(2, prerequisites);
        System.out.println(Arrays.toString(canFinish(4, prerequisites)));
    }
}
