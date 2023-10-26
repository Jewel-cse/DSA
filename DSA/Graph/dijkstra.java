import java.util.ArrayList;
import java.util.PriorityQueue;

public class dijkstra {
    //Calculate the shortest path using priority queue
    //v = total vertics , s = start
    public static int[] shortestPath_pq(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s) {

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.first - y.first); //first= distance, second = node
        int[] dis = new int[v];
        for (int i = 0; i < v; i++)
            dis[i] = (int) 1e9;

        dis[s] = 0;
        pq.add(new Pair(0, s));
        while (pq.size() != 0) {
            int distace = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeWt = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                if (distace + edgeWt < dis[adjNode]) {
                    dis[adjNode] = distace + edgeWt;
                    pq.add(new Pair(dis[adjNode], adjNode));
                }
            }
        }
        return dis;
    }
    
    //Set is used: for unique data and ascending order....
   
}
