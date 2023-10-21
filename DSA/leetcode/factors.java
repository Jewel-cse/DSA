import java.util.ArrayList;
import java.util.List;

public class factors {
    public static void main(String[] args) {
        //System.out.println(factorlist(20).toString());
        System.out.println(factorlistSQ(20));
    }
    //O(N) : brute force........
    public static List<Integer> factorlist(int n) {
        List<Integer> ls = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                ls.add(i);
            }
        }
        return ls;
    }
    //O(Sq(n)) 
    public static List<Integer> factorlistSQ(int n) {
        List<Integer> ls = new ArrayList<>();
        int l = (int) Math.sqrt(n);
        int temp = 0;
        for (int i = 1; i <= l; i++) {
            if (n % i == 0) {
                ls.add(i);
                temp = n / i;
                ls.add(temp);
            }
        }
        return ls;
    }

}
