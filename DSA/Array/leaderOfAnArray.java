import java.util.ArrayList;
import java.util.List;

public class leaderOfAnArray {
    public static void main(String[] args) {
        System.out.println(superiorElements(new int[] { 1, 2, 6, 3, 2 }).toString());
    }
    
    // O(n)
    //add into list: if all the element of right side is less than curent element.
    public static List< Integer > superiorElements(int []a) {
        List<Integer> ls = new ArrayList<>();
        int right = a.length-1;
        int max = a[right];
        ls.add(max);

        for(int i =right-1 ; i>=0;i--){
            if(a[i] > max){
                max =  a[i];
                ls.add(max);
            }
        }
    return ls;
    }
}
