import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfwaysToreachDestination {
    static class Pair {
        int distance;
        int node;
    
        public Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }
    public static int countPaths(int n, int[][] roads) {
        //start 0 and end n-1
        ArrayList<List<Pair>> adj = buildAdj(roads);
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.distance-y.distance );
        int[] dist = new int[n];
        int[] ways = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            ways[i] = 0;
        }
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));

        // Define modulo value
        int mod = (int)(1e9 + 7);

        // Iterate through the graph with the help of priority queue
        // just as we do in Dijkstra's Algorithm.
        while (pq.size() != 0) {
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            for (Pair it : adj.get(node)) {
                int adjNode = it.node;
                int edW = it.distance;
                
                // This ‘if’ condition signifies that this is the first
                // time we’re coming with this short distance, so we push
                // in PQ and keep the no. of ways the same.
                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    pq.add(new Pair(dis + edW, adjNode));
                    ways[adjNode] = ways[node];
                } 

                    // If we again encounter a node with the same short distance
                    // as before, we simply increment the no. of ways.
                    else if (dis + edW == dist[adjNode]) {
                        ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                    }
                System.out.print(ways[adjNode]+" ");
            }
        }
        // Finally, we return the no. of ways to reach
        // (n-1)th node modulo 10^9+7.
        return ways[n - 1] % mod;
    }

    
    private static ArrayList<List<Pair>> buildAdj(int[][] roads) {
        ArrayList<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < roads.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            
            for (int j = 0; j < roads[0].length; j++) {
                adj.get(i).add(new Pair(roads[i][j], j));
               // adj.get(j).add(new Pair(roads[i][j], i));
            }
        }
        
        return adj;
    }
    public static void main(String[] args) {
        int[][] roads = { { 0, 6, 7 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 3, 3 }, { 6, 3, 3 }, { 3, 5, 1 }, { 6, 5, 1 },
                { 2, 5, 1 }, { 0, 4, 5 }, { 4, 6, 2 } };
        
        int ans = countPaths(7, roads);
        System.out.println(ans);
    }
}
