package Contest;

import java.util.Scanner;

public class subsegment {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] a = new int[100];

        while (t > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            for (int i = 0; i < n; i++)
                a[i] = in.nextInt();

            //check
           System.out.println(printF(a,k,n));
            t--;
        }
    }

    public static String printF(int[]a, int k,int n){
        for (int j = 0; j < n; j++) {
            if (a[j] == k) {
                return "yes";

            }
        }
        return "No";
    }
}
