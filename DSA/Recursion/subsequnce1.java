package Recursion;

import java.util.ArrayList;
import java.util.List;

public class subsequnce1 {
    
    public static void prinF(int index, List<Integer> lst,List<List<Integer>> temp ,int[]arr) {
        if (index == arr.length) {
            System.out.println(lst.toString());
            temp.add(new ArrayList<>(lst));
            return;
        }
        prinF(index + 1, lst,temp, arr); //not peak element
        lst.add(arr[index]); 
        prinF(index + 1, lst,temp, arr); // peak element
        lst.remove(lst.size() - 1); // list er last element delete korte hobe perticular time
        
        
    }
    

    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();
        List<List<Integer>> temp = new ArrayList<>();

        int[] arr = {1,2,3};
        System.out.println(temp.toString());
        prinF(0, lst, temp, arr);
    }
}
