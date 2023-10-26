import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class checkCycle {
    public  static boolean isCycle(int sr, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, -1));
        vis[sr] = true;
        while (!q.isEmpty()) {
            int node = q.peek().first;
            int parent = q.peek().second;
            q.poll();
            for (Integer adjcnt : adj.get(node)) {
                if (!vis[adjcnt]) {
                    vis[adjcnt] = true;
                    q.add(new Pair(adjcnt, node));
                } else if (parent != adjcnt) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj,int n) {

        boolean[] vis = new boolean[n+1];
        for (int i = 0; i <= n; i++) {
            if (!vis[i] && isCycle(i, adj, vis)) {
                return true;
            }
        }
        return false;
    }
   
}
