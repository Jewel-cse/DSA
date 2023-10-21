package Contest;

import java.util.Scanner;

public class increasinSEq {
    public static void main(String[] args) {
       

        int[] a = new int[100];
        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        

        while (t > 0) {
            //input portion
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            int i = 0;
            int j = 1;
            while (i < n) {
                if (a[i] != j) {
                    i++;
                    j++;
                } else if (a[i] == j) {
                    j++;
                }
    
            }
            j--;
            System.out.println(j);


            t--;
        }
    }      
        
}
