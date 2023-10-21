import java.util.Arrays;
import java.util.HashMap;

public class smallestPositiveMissing {
    public static void main(String[] args) {
        int[] arr = {0,2,3};
        System.out.println(missingNumber(arr,arr.length));
    }
    static int missingNumber(int arr[], int size)
    {
        // Your code here
        HashMap<Integer,Boolean> map = new HashMap<>();

        Arrays.sort(arr);
        for (int i : arr) {
            if(i>0){
                if(map.get(i) == null){
                    map.put(i,true);    // all positive gulate value: true 
                }
            }
            
        }
        for (int index = 1; index <= size; index++) {
            if(map.get(index)==null){
                return index;                   
            }
        }

        return size+1;
    }
}
