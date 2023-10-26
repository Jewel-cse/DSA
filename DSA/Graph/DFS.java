import java.util.ArrayList;

public class DFS {
    //recursive function
    public static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans) {
        vis[node] = true;
        ans.add(node);
        for (Integer it : adj.get(node)) {
            if (!vis[it])
                dfs(it, vis, adj, ans);
        }
    }
    
    //call recursive
    public static ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[v + 1];
        
        //non empty diye suru korar jonno
        for (int i = 0; i < adj.size(); i++) {
            if (!adj.get(i).isEmpty()) {
                dfs(i, vis, adj, ans);
                break;
            }
        }
        //dfs(0, vis, adj, ans);
        return ans;
    }

    
}
