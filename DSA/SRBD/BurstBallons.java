package SRBD;

import java.util.Arrays;

/*
    Different variants of Burst Baloons:
    >>  calculate left * (current)* right
    >>  calculate left * right,but no sigle element left , >> i ==1 && j == n : score add .... 
    >>  calculate left* (current)* right, but only one element left >>  calculate mx score...

    Problem Statement #### 1 :
    You are given n balloons, indexed from 0 to n – 1.
    Each balloon is painted with a number on it represented by an array. 
    You are asked to burst all the balloons.
    If you burst the ith balloon, you will get arr[i – 1] * arr[i] * arr[i + 1] coins.
    If i – 1 or i + 1 goes out of the array’s bounds, then treat it as if there is a balloon
    with a 1 painted on it.
 */
public class BurstBallons {
    
    //Problem #1: https://www.codingninjas.com/studio/problems/mining-diamonds_4244494
    //https://leetcode.com/problems/burst-balloons/description/
    private static int getMax(int i, int j, int[] nums, int[][] dp) {
        if (i > j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int mscore = Integer.MIN_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int score = nums[i - 1] * nums[ind] * nums[j + 1] + getMax(i, ind - 1, nums, dp)
                    + getMax(ind + 1, j, nums, dp);
            if (score > mscore)
                mscore = score;
        }
        //System.out.println("-------" + mscore);
        return dp[i][j] = mscore;
    }
    //Problem statement ## 2 ::https://www.hackerrank.com/contests/target-samsung-13-nov19/challenges/burst-balloons-1/problem

    //@@@@@@@@@@ get for the maximum cost..............
    private static int getScore(int i,int j,int jlast,int[]b){
        if(i>j) return 0; //  overlapping 
        int mxscore = Integer.MIN_VALUE;
        for(int ind = i;ind<=j;ind++){
            int score = getScore(i,ind-1,jlast,b)+ getScore(ind+1,j,jlast,b);
            if(i == 1 && j == jlast) //no ballon availableleft and right side , 
                score += b[ind];
            else    
                score += b[i-1]*b[j+1] ;
            //get maximum
            if(mxscore<score)   mxscore = score;
        }
        return mxscore;
    }
    /*     @@@@@@@@@@ Problem 3 @@@@@@@@@@@@@@@
    Here the last one Ballon that is left after bursting all others
    will left as it is. It will not add up with maximum score.
    Sample Input 1:
    3
    1 2 3
    Sample Input 2:
    2
    1 5
    Sample Input 3:
    4
    3 1 5 8

    Sample Output 1: 9
    Sample Output 2: 5
    Sample Output 3: 159
    */
    
    
    //@@@@@@@@@@ get for the maximum cost..............
    private static int getScore3(int i,int j,int jlast,int[]b){
        if(i>j) return 0; //  overlapping 
        int mxscore = Integer.MIN_VALUE;
        for(int ind = i;ind<=j;ind++){
            int score = getScore3(i,ind-1,jlast,b)+ getScore3(ind+1,j,jlast,b);
            if(i == 1 && j == jlast) //ONLY ONE BALOON LEFT, 
                mxscore = Math.max(mxscore, score);
            else {
                score += b[i-1]*b[ind]*b[j+1] ;
                mxscore = Math.max(mxscore, score);
            }    
        }
        return mxscore;
    }
    
    //@@@@@@@@@@ template functon for calll above functions..........
    public static int maxCoins(int[] arr) {
        int n = arr.length;
        //create a new array with boundary values
        int[] nums = new int[n + 2];
        System.arraycopy(arr, 0, nums, 1, n);
        nums[0] = nums[n + 1] = 1;

        //create dp array
        int[][] dp = new int[n + 1][n + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        //return getMax(1, n, nums, dp);
        return getScore(1, n, n, nums);
        //return getScore3(1, n, n, nums);
    }
    //@@@@@@@@@  MAIN @@@@@@@@
    public static void main(String[] args) {
        int[] num = { 3,1,5,8};
        //int[] num = { 1, 0, 5, 4, 4, 0, 4, 3, 5, 3 };
        System.out.println(maxCoins(num));
    }
}
