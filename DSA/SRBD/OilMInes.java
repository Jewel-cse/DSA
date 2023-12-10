package SRBD;
/*
https://www.careercup.com/question?id=5740719907012608
https://stackoverflow.com/questions/39673898/divide-array-into-k-contiguos-partitions-such-that-sum-of-maximum-partition-is-m/39675396
https://www.careercup.com/question?id=5730470801702912
*/

/*
@@@ Problem Statement 1: 
There is an island surrounded by oil mines. You will be given n companies and m oil mines having values.
You have to distribute the mines to "n" companies in fair manner. Remember the companies can have oil 
mines adjacent to each other and not in between of each others.After distributing them compute the 
difference of oil mines from the company getting highest and company getting lowest. This number 
should be minimum.(then only the distribution can be termed as fair).

@@@ Problem statement 2: 
How to divide a circular array into k group of contiguous element such that difference
between maximum sum and minimum sum is minimum. Each group have contiguous element of
array. For e.g If the array is as follow.@@@@@ [6 13 10 2] and k=2 then o/p should be 
18(6+10+2)-13=5. As array is circular 6,10,2 are contiguous element of array.
For e.g If the array is as follow.@@@@@ [6 13 2 10] and k=2 then o/p should be 
16(6+10)-15(13+2)=1. As array is circular 6,10 are contiguous element of array.
For e.g If the array is as follow. @@@@@[100 92 133 201 34 34 34 94 108] and k=4 then group
as follow 208(108,100), 225(92,133), (201), 196(34,34,34,94) so 225-196=29

Input 
2 
2 4 
6 13 10 2 
2 4 
6 10 13 2 

output 
5 
1
*/
import java.util.Scanner;
public class OilMInes {
    static int companies, mines;
    static int mxx = Integer.MAX_VALUE;
    static int minn = Integer.MIN_VALUE;

    //find min and max 
    static int min(int x, int y) {
        return (x >= y) ? y : x;
    }

    static int max(int x, int y) {
        return (x >= y) ? x : y;
    }

    static void calculateOilMines(int i, int[] oilMines, boolean[] visited, int minV, int maxV, int sum,
            int nodes, int[] ANS) {
        // Base Case
        if (visited[i]) {
            int newMin = min(sum, minV);
            int newMax = max(sum, maxV);

            if (nodes == companies - 1) {
                ANS[0] = min(ANS[0], newMax - newMin);
            }
            return;
        }

        // Main Case
        visited[i] = true;
        int j = (i + 1) % mines;

        calculateOilMines(j, oilMines, visited, minV, maxV, sum + oilMines[i], nodes, ANS);

        int newMin = min(sum, minV);
        int newMax = max(sum, maxV);

        calculateOilMines(j, oilMines, visited, newMin, newMax, oilMines[i], nodes + 1, ANS);

        visited[i] = false;
    }

    //@@@@@@@@@@@@@@ MAIN FUNCTION @@@@@@@@@@@@
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            companies = scanner.nextInt();
            mines = scanner.nextInt();
            int[] oilMines = new int[mines];
            boolean[] visited = new boolean[mines];

            for (int i = 0; i < mines; i++) 
                oilMines[i] = scanner.nextInt();
            

            int[] ANS = new int[1];
            ANS[0] = mxx;
            for (int i = 0; i < mines; i++) {
                calculateOilMines(i, oilMines, visited, mxx, minn, 0, 0, ANS);
            }

            System.out.println(ANS[0]);
        }
        scanner.close();
    }

}
