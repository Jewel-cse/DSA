package SRBD;
/*
problem description: It is a well-researched fact that men in a restroom 
generally prefer to maximize their distance from already occupied stalls,
by occupying the middle of the longest sequence of unoccupied places.
Example: 
stalls:     1   2   3   4   5   6   7   8   9   10
            -   -   -   -   -   -   -   -   -   -   <initial seat>
            -   -   -   -   X   -   -   -   -   -   <1st man occupied>
            -   -   -   -   X   -   -   X   -   -   <2nd man occupied>
            -   X   -   -   X   -   -   X   -   -   <3rd man occupied>
            -   X   -   -   X   -   -   X   X   -       ..........
            -   X   -   -   X   X   -   X   X   -       .........
            -   X   X   -   X   X   -   X   X   -
            -   X   X   -   X   X   -   X   X   X
            -   X   X   -   X   X   X   X   X   X
            -   X   X   X   X   X   X   X   X   X
            X   X   X   X   X   X   X   X   X   X



 */
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RestRoom {
    //keep track of start,end and distance
    static class Gap {
        int start;
        int end;
        int distance;

        Gap(int s, int e) {
            start = s;
            end = e;
            distance = end - start;
        }
    }/*
        >>>> design priority queue based on maximum gap and end also
        >>>> find middle from queue
        >>>  assign stalls[make array true]
        >>> insert 2 side gaps 
    
     */
    
    private static void arrangeGuest(boolean[] stalls, int men) {
        //design priority queue
        PriorityQueue<Gap> q = new PriorityQueue<>((a, b) -> {
            if(b.distance != a.distance)
            return b.distance - a.distance;  //maximum distance age priority pabe
            else  //if two distance are equal  ending descending
                return b.end - a.end; //   
        });
        q.add(new Gap(0, stalls.length - 1));
        for (int i = 1; i <= men; i++) {
            Gap g = q.poll();
            int assignStall = g.start + (g.end - g.start) / 2;
            stalls[assignStall] = true; ///assing guest
            if(assignStall >= g.start)
            q.add(new Gap(g.start, assignStall - 1));
            if(assignStall <= g.end)
            q.add(new Gap(assignStall + 1, g.end));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int NumberOfstalls = sc.nextInt();
            int men = sc.nextInt();
            boolean[] stalls = new boolean[NumberOfstalls];
            arrangeGuest(stalls, men);
            System.out.println(Arrays.toString(stalls));
        }
        sc.close();
    }
}
