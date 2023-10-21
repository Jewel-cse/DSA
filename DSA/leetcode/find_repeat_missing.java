
import java.util.HashMap;

public class find_repeat_missing {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4,6,7,8,9,10,10,11,12};
        int[] result = new int[2];
        result = findTwoElement(arr,arr.length);

        for (int i  = 0 ;i<2;i++) {
            System.out.print(result[i]+" ");    
        }
    }
    static int[] findTwoElement(int arr[], int n) {
        // code here
         
        HashMap<Integer,Boolean> map = new HashMap<>();
        int[] result = new int[2];
        for (int i : result) {
            if (map.get(i)==null) {
                map.put(i, true);
            }
            else{
                arr[0] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            if (map.get(i) == null) {
                arr[1] = i;
                break;
            }
        }
        return result;

        
    }
}
