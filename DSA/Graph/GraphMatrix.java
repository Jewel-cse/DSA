import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GraphMatrix {
    public static void matrixRep(int n) {
        int[][] nodes = new int[n + 1][n + 1];
        //Arrays.fill(nodes,0);
        Scanner in = new Scanner(System.in);
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                nodes[i][j] = in.nextInt();
            }
        }

        for (int[] is : nodes) {
            System.out.println(Arrays.toString(is));
        }
        in.close();
    }
    ////create adjacency list
    public static ArrayList<ArrayList<Integer>> matrixToadjList(int[][] nodes) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < nodes.length; i++) {
            ArrayList<Integer> ls = new ArrayList<>();
            for (int j = 0; j < nodes[0].length; j++) {
                if (nodes[i][j] == 1) {
                    ls.add(j);
                }
            }
            adj.add(i, ls);
        }
        return adj;
    }
}
