package SRBD;

/*
/*
https://www.geeksforgeeks.org/samsung-interview-experience-set-39-campus-r-d-noida/
https://www.careercup.com/page?pid=samsung-interview-questions

A Doctor travels from a division to other division where divisions are connected like a graph(directed graph) and 
the edge weights are the probabilities of the doctor going from that division to other connected division but the 
doctor stays 10mins at each division now there will be given time and had to find the division in which he will be 
staying by that time and is determined by finding division which has high probability.

Input is number of test cases followed by the number of nodes, edges, time after which we need to find the division 
in which he will be there, the edges starting point, end point, probability.

Note: If he reaches a point where there are no further nodes then he leaves the lab after 10 mins and the traveling 
time is not considered and during that 10min at 10th min he will be in next division, so be careful

2
6 10 40 
1 2 0.3 1 3 0.7 3 3 0.2 3 4 0.8 2 4 1 4 5 0.9 4 4 0.1 5 6 1.0 6 3 0.5 6 6 0.5
6 10 10 
1 2 0.3 1 3 0.7 3 3 0.2 3 4 0.8 2 4 1 4 5 0.9 4 4 0.1 5 6 1.0 6 3 0.5 6 6 0.5

6 0.774000  
3 0.700000
*/
import java.util.Scanner;

public class DoctorsPobability {

    /*  if a goes to b > P(x) and b goes to c >P(y) 
     *            then a goes to c >> P(x)*P(y)
     */
    private static void docProb(double[][] graph, int nodes, int time, int curNode, double p, double[] answer) {
        //time  <= 0 holei answer update and return. 
        if (time <= 0) {
            answer[curNode] += p;
            return;
        }
        //time-- by 10 and p * probability....
        for (int i = 1; i <= nodes; i++) {
            if (graph[curNode][i] != 0) {
                p *= graph[curNode][i];
                docProb(graph, nodes, time - 10, i, p, answer);
                p /= graph[curNode][i];  //back korle probability back korte hobe
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t-- > 0) {
            //ready to input
            int nodes = scanner.nextInt();
            int edges = scanner.nextInt();
            int time = scanner.nextInt();

            double[][] arr = new double[nodes + 1][nodes + 1];
            for (int i = 1; i <= nodes; i++) {
                for (int j = 1; j <= nodes; j++) {
                    arr[i][j] = 0;
                }
            }

            //take input
            int from, to;
            double prob;
            for (int i = 0; i < edges; i++) {
                from = scanner.nextInt();
                to = scanner.nextInt();
                prob = scanner.nextDouble();
                arr[from][to] = prob;
            }
            //call function for probability
            double[] answer = new double[nodes + 1];
            docProb(arr, nodes, time, 1, 1.0, answer);

            double finalProb = 0.0;
            int finalDivision = 0;

            //maximum probability wala node and probability
            for (int i = 1; i <= nodes; i++) {
                if (answer[i] > finalProb) {
                    finalProb = answer[i];
                    finalDivision = i;
                }
            }

            System.out.printf("%d %.6f\n", finalDivision, finalProb);
        }
        scanner.close();
    }
}


