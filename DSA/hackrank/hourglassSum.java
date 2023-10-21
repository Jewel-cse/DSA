package hackrank;

import java.util.ArrayList;
import java.util.List;

public class hourglassSum {
    public static void main(String[] args) {
        List<List<Integer> > x  = new ArrayList<List<Integer> >();
        //initialize list
        for (int i = 0; i < 6; i++) {
            x.add(new ArrayList<>());
        }
        //add element
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                x.get(i).add(j);
            }
            
        }
        //System.out.println(x);
        
        System.out.println(hourglaSum(x));
    }
    public static int hourglaSum(List<List<Integer>> arr) {
    // Write your code here
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum = arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2)
                                    +arr.get(i+1).get(j+1)+
                      arr.get(i+2).get(j) + arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2);
                if(sum>max){
                    max = sum;
                }
            }
            
        }
        return max;
    }
}
