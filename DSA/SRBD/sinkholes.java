package SRBD;


/*
https://www.geeksforgeeks.org/samsung-competency-test-25-aug-19/
	
	Q.There is a large plot with various sinkholes present. 
	Since one sinkhole can combine with another sinkhole, it is required to get
	at most one sinkhole while occupying the plot. You have to find the maximum 
	square-area formed with at most one sinkhole present.
	If there are two plots with the same area then print the one with 
	lesser sinkhole present otherwise if the sinkholes are also same then print
	anyone. For each case, you have to print the bottom leftmost coordinate and 
	top rightmost point. Please keep in mind that the plot starts with (1, 1).

	Time limit= 1sec and Memory limit– 256Mb

	Input: First line will give the number of test cases. For each test case, we
	will be given the size of the plot matrix N x M (where 1<=N, M<=1000). Next
	line will give the number of sinkholes present in the matrix K (1<=K<=N+M). 
	Next, K-lines will give the coordinates of the sinkholes.

	Output: For each test case, you have to print the number of the test case
	and the coordinates of the resultant square.
	i.e. #i xb yb xt yt (ith test case, xb=bottomost left x-coordinate, 
	yb=bottomost  left y-coordinate, xt= topmost right x-coordinate,
	yt= topmost right y-coordinate)
	
  *	time complexity of my approach = O(n*m*log(min(m,n))) *

@@@Example:
@@@@@@@@ cordinate starts from bottom to top
i/p:
1          > testcase
6 6        > size of plot matrix
4          > number of sinkholes
1 1        >sinkholes cordinate
3 3
4 4
6 6

o/p:
#1 3 4 1 6
*/

import java.util.Scanner;

public class sinkholes {

    static int xb, yb, xt, yt;

    static int fun(int[][] dp, int N, int M, int mid) {
        int minsum = Integer.MAX_VALUE;
        for (int i = 0; i <= N - mid; i++) {
            for (int j = 0; j <= M - mid; j++) {
                /*
                dp
                (+)    -
                -    +
                
                 */
                int sum = dp[i + mid][j + mid] - dp[i + mid][j] - dp[i][j + mid] + dp[i][j];
                if (sum < minsum) {
                    minsum = sum;
                    if (minsum <= 1) { //save the cordinates
                        xb = i + mid;
                        yb = j + 1;
                        xt = i + 1;
                        yt = j + mid;
                    }
                }
            }
        }
        return minsum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] A = new int[N][M];
        
        int K = scanner.nextInt();
        for (int i = 0; i < K; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            A[x - 1][y - 1] = 1;
        }
        //make sinkholes in plot 
        int[][] dp = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                /*
                -dp+A    dp(+)
                dp(+)    **dp
                 */
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + A[i - 1][j - 1];
            }
        }


        // Applying binary search
        int l = 1, r = Math.min(M, N);
        int ones;
        while (l < r) {
            int mid = (l + r) / 2;
            ones = fun(dp, N, M, mid);
            if (ones > 1) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        // Output
        System.out.println(xb + " " + yb + " " + xt + " " + yt);
        scanner.close();
    }
}
/*
6 6  
4  
1 1
3 3
4 4
6 6
 */
