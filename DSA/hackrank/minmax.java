package hackrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class minmax {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(5);
        for (int index = 0; index < 5; index++) {
            arr.add(2*index+1);
        }
        miniMaxSum(arr);
        //System.out.println(arr);
    }
     public static void miniMaxSum(List<Integer> arr) {
        Collections.sort(arr);   // arraylist sort krar jonno collection use kora hoi
        long minimum = 0, maximum = 0;
        for (int i = 0; i < arr.size()-1; i++) {
            minimum += arr.get(i);
        }
        for (int i = 1; i < arr.size(); i++) {
            maximum += arr.get(i);
        }
        System.out.println(minimum+"  "+maximum);
    }
}
