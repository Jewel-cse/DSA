package Contest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class alexa_stack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t > 0) {
            int n = in.nextInt();

            //check
            System.out.println(printF(n).toString());
        
            t--;
        }
    }
    public static List<Integer> printF(int n){
        //int[] arr = new int[n];
        List<Integer> lst = new ArrayList<>(n);
        
        int a = n;
        int counter =0;
        while (counter < n) {
           
            int add = a + (a + 1);
            int mul = 3 * (a + 2);

            if ( mul%add !=0  ) {
                lst.add(a);
                counter++;
            }
            a++;
        }
        return lst;
    }
}
