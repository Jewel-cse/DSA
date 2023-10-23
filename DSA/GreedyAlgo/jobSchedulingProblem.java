package GreedyAlgo;

import java.util.Arrays;
import java.util.Comparator;

public class jobSchedulingProblem {
    public static void jobScheduling(int[][] jobs) {
        //Arrays.sort(jobs, Comparator.comparingInt(row -> row[2]));    //asceding
        Arrays.sort(jobs, new Comparator<int[]>() {              //sort accroding to profit> column2  descending
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[2], o1[2]);
            }
        });
        /*

         for (int[] is : jobs) {
             System.out.println(Arrays.toString(is));
         }
         */
        
        //find maximum deadline
        int maxDeadLine = -1;
        for (int i = 0; i < jobs.length; i++) {
            if (jobs[i][1] > maxDeadLine) {
                maxDeadLine = jobs[i][1];
            }
        }

        //result array create
        int[] result = new int[maxDeadLine+1];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }

        int numberOfJob = 0;
        int profit = 0;
        for (int i = 0; i < jobs.length; i++) {
            //deadline tai result er index 
            //result array will be contain job id

            int index = jobs[i][1];
            while (index > 0) {
                if (result[index] == -1) {
                    result[index] = jobs[i][0]; //job id scheduled
                    numberOfJob++;
                    profit += jobs[i][2];
                    break;
                } else {
                    index--;
                }
            }
        }
        System.out.println(numberOfJob+" "+profit);
        //return new int[] { numberOfJob, profit };

    }
    public static void main(String[] args) {
        jobScheduling(new int[][]{{1, 2, 30},
            {2, 2, 40},
            {3 ,1, 10},
            {4 ,1, 10}});
    }
}
