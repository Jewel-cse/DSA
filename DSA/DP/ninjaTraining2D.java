package DP;

import java.util.Arrays;

//in coding ninja : ninja training problem 
//At coder :  vacation
public class ninjaTraining2D {

   
    //@@@@@@@@@@@@ recursion  @@@@@@@@@@@@@@@@@@@@@@@@@@
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public static int ninjaTraining(int points[][]) {
        //if point[3][3] > f(2,3)
        return f(points.length-1, points[0].length, points);
    }
    // maximum points earn , if two  consecutive day does not same activity
    private static int f(int day, int last, int[][] points) {
        //base case 
        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i < points[0].length; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, points[day][i]);
                }
            }
            return maxi;
        }
        //top to bottom:: 
        // if task in not last task then add it find 0 to current day
        int maxi = 0;
        for (int i = 0; i < points[0].length; i++) {
            if (i != last) {
                int earnPoints = points[day][i] + f(day - 1, i, points);
                maxi = Math.max(maxi, earnPoints);
            }
        }
        return maxi;
    }

    //@@@@@@@@@@@@@@@@@@@@@@ Memoization @@@@@@@@@@@@@@@@@@@
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    private static int ninjaTraining_memo(int[][] points) {
        int days = points.length;
        int tasks = points[0].length;
        int[][] dp = new int[days][tasks+1];   // ekta column beshi nite hobe
        for (int[] is : dp) {                  //for non task of last day er previous 
            Arrays.fill(is, -1);
        }
        /* for (int[] is : dp) {
            System.out.println(Arrays.toString(is));
        } */
        return  vacation_memo(days - 1, tasks, points, dp);
    }

    private static int vacation_memo(int day, int last, int[][] points, int[][] dp) {
        if(dp[day][last] != -1)
            return dp[day][last];
        //base case first day : 0
        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i < points[0].length; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, points[0][i]);
                }
            }
            return dp[day][last] = maxi;
        }
        int maxi = 0;
        for (int i = 0; i < points[0].length; i++) {
            if (i != last) {
                int totalPoint = points[day][i] + vacation_memo(day - 1, i, points, dp);
                maxi = Math.max(maxi, totalPoint);
            }
        }
        return dp[day][last] =  maxi;
    }
    
    
    ///@@@@@@@@@@@@@@@  Tabulization @@@@@@@@@@@@@@@@@@@@@@
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2
    private static int vacation_tabu(int[][] points) {
        int n = points.length;
        int[][] dp = new int[n][4];
        //base case first day : 0

        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][1], points[0][0]);

        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0; // Initialize the maximum points for the current day and last activity
                // Consider each possible task for the current day
                for (int task = 0; task <= 2; task++) {
                    if (task != last) { // Ensure that the current task is different from the last
                        // Calculate the points for the current activity and add it to the maximum points from the previous day
                        int activity = points[day][task] + dp[day - 1][task];
                        // Update the maximum points for the current day and last activity
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }
        return dp[n - 1][3];
    }
    
    /// @@@@@@@@@@@@@  space optimization @@@@@@@@@@@@@@
    //  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    private static int vacation_tabu_space(int[][] points) {
        int n = points.length;

        //base case first day : 0

        int[] prev = new int[4];
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][1], points[0][0]);

        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            int[] temp = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0; // Initialize the maximum points for the current day and last activity
                // Consider each possible task for the current day
                for (int task = 0; task <= 2; task++) {
                    if (task != last) { // Ensure that the current task is different from the last
                        // Calculate the points for the current activity and add it to the maximum points from the previous day
                        // Update the maximum points for the current day and last activity
                        temp[last] = Math.max(temp[last], points[day][task] + prev[task]);
                    }
                }
            }
            prev = temp;
        }
        return prev[3];
    }

    /*
     * @@@@@@@@@@@@@@  Main function @@@@@@@@@@@@@@@@
     * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
     */

    public static void main(String[] args) {
        //int[][] point = { { 1, 2, 5 }, { 3, 1, 1 }, { 3, 3, 3 } };
        int[][] point = {{10, 40, 70},
                        {20, 50, 80},
                { 30, 60, 90 } };
        System.out.println(ninjaTraining(point));
        System.out.println(ninjaTraining_memo(point));
        System.out.println(vacation_tabu(point));
        System.out.println(vacation_tabu_space(point));
    }
}
