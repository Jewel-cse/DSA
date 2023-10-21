import java.util.ArrayList;
import java.util.List;

public class kthElementoftwoSortedArray {
    public static void main(String[] args) {
        ArrayList<Integer> ls1 = new ArrayList<>(List.of(1, 2, 3, 5, 6));
        ArrayList<Integer> ls2 = new ArrayList<>(List.of(4, 7, 8, 9, 100));

        System.out.println(kthElement(ls1, ls2, 5, 5, 6));
    }
    //given two list with size ,find kth element
    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        if (m + n < k) {
            return -1;
        }
        int counter = 0;
        int left =0;
        int right = 0;
        int ans = -1;
        while (counter < k) {
            if (arr1.get(left) <= arr2.get(right)) {
                ans = arr1.get(left);
                counter++;
                left++;
                //System.out.println("count for : "+ans+" "+counter);
            }
            else {
                ans = arr2.get(right);
                right++;
                counter++;
                //System.out.println("count for : "+ans+" "+counter);
            }
        }
        return ans;
    }
    
}
