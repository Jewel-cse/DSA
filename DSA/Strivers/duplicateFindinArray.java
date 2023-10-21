package Strivers;

import java.util.Arrays;
import java.util.HashMap;

public class duplicateFindinArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2333,3, 2333 };
        //System.out.println(frequencyArr(arr));
        //System.out.println(findDuplicateWithsortingapproach( arr));
        System.out.println(findduplicate_hashmap(arr));
        

    }
    // ways are: hashmap, sorting, frequency array 

    // freq: discalimer .
    //we dont know the maximum value of array
    // so we cannot define the feq array size
    public static int frequencyArr(int[] arr) {
        int[] freq = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            if (freq[arr[i]] == 0)
                freq[arr[i]]++;
            else {
                return arr[i];
            }
        }
        return 0;
    }
    
    //sorting approach : complexity: (nlogn + n)
    public static int findDuplicateWithsortingapproach(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[i + 1]) {
                return arr[i];
            }
        }
        return 0;
    }

    // using hashmap
    public static int findduplicate_hashmap(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<Integer,Boolean>();
        for (int i = 0; i < arr.length; i++) {
           
            if (map.get(arr[i]) == null) {
                map.put(arr[i], true);
                
            } else {
                return arr[i];
            }
        }
        return 0;
    } 
}
