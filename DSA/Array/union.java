import java.util.ArrayList;
import java.util.List;

public class union {
    public static void main(String[] args) {
        System.out.println(unionOfSortedArr(new int[] { 3,3, 4, 5 ,6, 7, 8, 9, 9, 9 }, new int[] { 2, 4, 10, 10,  }).toString());
    }

    //we can solve this problem : 1. using HashSet, two pointer......
    public static List<Integer> unionOfSortedArr(int[] ar1, int[] ar2) {
        List<Integer> ls = new ArrayList<>();

        int len1 = ar1.length;
        int len2 = ar2.length;

        int left = 0;
        int right = 0;
        
        if (ar1[left] <= ar2[right]) {
            ls.add(ar1[left++]); 
        } else
            ls.add(ar2[right++]);
        
        while (left < len1 && right < len2) {
            if (ar1[left] <= ar2[right]) {
                
                if (ar1[left] != ls.get(ls.size()-1) ) {
                    ls.add(ar1[left++]);
                }
                else    
                    left++;
            } else {
                if (ar2[right] != ls.get(ls.size()-1)) {
                    ls.add(ar2[right++]);
                }
                else
                    right++;
            }
        }
        while (left < len1) {
            if(ar1[left] != ls.get(ls.size()-1))
                ls.add(ar1[left]);
            left++;
        }
        while (right < len2) {
            
            if (ar2[right] != ls.get(ls.size() - 1))
                ls.add(ar2[right]);
            
            right++;
        }
        return ls;
    }
}
