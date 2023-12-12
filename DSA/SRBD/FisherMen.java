package SRBD;

/*problem statement: https://www.hackerrank.com/contests/target-samsung-13-nov19/challenges/fisherman
 */

import java.util.*;

public class FisherMen {

//create gate type of class which contain gate location and men
    static class Gate {
        int loc;
        int men;

        Gate(int loc, int men) {
            this.loc = loc;
            this.men = men;
        }
    }
    

    private static void solve(int gate1, int gate2, int gate3, int distance, int currentGate, boolean[] vis,int[]ans,Gate[] gates) {
        //current distance greater then ans, no need to forward
        if (distance > ans[0])
            return;

        //base case : if men in the gate is zero pass next gate,finaly min(ans,distance)
        if (gates[currentGate].men == 0) {
            if (currentGate == gate1)
                currentGate = gate2;
            else if (currentGate == gate2)
                currentGate = gate3;
            else {
                ans[0] = Math.min(ans[0], distance);
                return;
            }
        }
        //searching for vacant spot of left and right
        int l = findLeft(gates[currentGate].loc, vis);
        int r = findRight(gates[currentGate].loc, vis);

        int costl = Math.abs(gates[currentGate].loc - l) + 1;
        int costr = Math.abs(gates[currentGate].loc - r) + 1;

        boolean goLeft = true, goRight = true;
        if (costl > costr)
            goLeft = false;
        if (costr > costl)
            goRight = false;

        if (goLeft) {
            vis[l] = true;
            gates[currentGate].men--;
            solve(gate1, gate2, gate3, distance + costl, currentGate, vis,ans,gates);
            //backtracking 
            vis[l] = false;
            gates[currentGate].men++;
        }
        if (goRight) {
            vis[r] = true;
            gates[currentGate].men--;
            solve(gate1, gate2, gate3, distance + costr, currentGate, vis,ans,gates);
            //backtracking 
            vis[r] = false;
            gates[currentGate].men++;
        }
    }

    private static int findLeft(int loc, boolean[] vis) {
        for (int i = loc; i > 0; i--) {
            if (!vis[i])
                return i;
        }
        return Integer.MAX_VALUE;
    }

    private static int findRight(int loc, boolean[] vis) {
        for (int i = loc + 1; i < vis.length; i++) {
            if (!vis[i])
                return i;
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //input section.........................
        int n = sc.nextInt();//number of spots 10
        int numberOfGate =3;
        int[] ll = new int[numberOfGate+1];
        int[] mens = new int[numberOfGate+1];
        for (int i = 1; i <= numberOfGate; i++) { //location
            ll[i] = sc.nextInt();
        }
        for (int i = 1; i <= numberOfGate; i++) { // men per gate
            mens[i] = sc.nextInt();
        }
        Gate[] gates = new Gate[numberOfGate+1]; //bcz index start from 1
        for (int i = 1; i <= numberOfGate; i++) { //bind loc and mens
            gates[i] = new Gate(ll[i],mens[i]);
        }
        // calculation section .....................
        boolean[] vis = new boolean[n + 1]; // 1 2 ....10 > spots
        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;

        solve(1, 2, 3, 0, 1, vis,ans,gates);
        solve(1, 3, 2, 0, 1, vis,ans,gates);
        solve(2, 1, 3, 0, 2, vis,ans,gates);
        solve(2, 3, 1, 0, 2, vis,ans,gates);
        solve(3, 2, 1, 0, 3, vis,ans,gates);
        solve(3, 1, 2, 0, 3, vis,ans,gates);
        System.out.println(ans[0]);
        
        sc.close();
    }
}
/* TestCases
6 = testcase
10
4 5
6 2
10 2

10
8 5
9 1
10 2

24
15 3
20 4
23 7

39
17 8
30 5
31 9

60
57 12
31 19
38 16

10
1 4 9
4 4 2
 
outputs:::
18
25
57
86
339
27

*/
