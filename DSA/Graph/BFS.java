import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BFS {
    public static ArrayList<Integer> bfsTraversalOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[v + 1];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] = true;
        while (!q.isEmpty()) {
            Integer node = q.poll();
            ans.add(node);
            for (Integer nd : adj.get(node)) {
                if (!vis[nd]) {
                    vis[nd] = true;
                    q.add(nd);
                }
            }
        }
        //System.out.println(ans.toString());
        return ans;
    }
}
