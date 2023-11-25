import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightwithKstops {
    //this is for queue
    static class tuple {
        int stops;
        int node;
        int cost;

        tuple(int stops, int node, int cost) {
            this.stops = stops;
            this.node = node;
            this.cost = cost;
        }
    }
    //for adjacency list
    static class  pair {
        int desNode;
        int cost;

        pair(int desNode, int cost) {
            this.desNode = desNode;
            this.cost = cost;
        }
    }

    private static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //build a adjacency list of type pair
        //make distance array of size node initialze (1e9)
        //add q
        //get tuple from q.
        //check k > then continue
        //check for adj node cost+weigt< previous and stops<= k
        // return dis[des] if not infinite, else -1;
        //-----------------------------------
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < flights.length; i++) {
            //src,des,cost  >>> src index e (des and cost) save 
            adj.get(flights[i][0]).add(new pair(flights[i][1], flights[i][2]));
        }
        //--------------------------------------
        int[] dis = new int[n];
        Arrays.fill(dis, (int) 1e9);
        
        //---------------------------------
        Queue<tuple> q = new LinkedList<>();
        q.offer(new tuple(0, src, 0));
        dis[src] = 0;

        while (!q.isEmpty()) {
            tuple it = q.poll();
            int stops = it.stops;
            int node = it.node;
            int cost = it.cost;
            if (stops > k)
                continue;
            for (pair itr : adj.get(node)) {
                int des = itr.desNode;
                int weigt = itr.cost;
                if (cost + weigt < dis[des] && stops <= k) {
                    q.add(new tuple(stops + 1, des, cost + weigt));
                    dis[des] = cost + weigt;
                }
            }
        }
        return dis[dst] != (int)1e9?dis[dst]:-1;
    }
    public static void main(String[] args) {
        // n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
        int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
        System.out.println(findCheapestPrice(3, flights, 0, 2, 0));
    }
}
