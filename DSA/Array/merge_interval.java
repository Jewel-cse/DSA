package Strivers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class merge_interval {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        System.out.println(merge(intervals).toString());
    }

    public static List<List<Integer>> merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // interval sort 

        List<List<Integer>> lst = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            // list empty and not overlaping interval shuru hole list e edd korbo
            if (lst.isEmpty() || lst.get(lst.size() - 1).get(1) < intervals[i][0]) {
                lst.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            } else {
                //right ta maximum nebo
                lst.get(lst.size() - 1).set(1, Math.max(lst.get(lst.size() - 1).get(1), intervals[i][1]));
            }
        }
        
        return lst;

    }
}
