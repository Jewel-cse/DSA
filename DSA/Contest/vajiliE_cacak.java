package Contest;

import java.util.Scanner;

public class vajiliE_cacak {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] a = new int[100];

        while (t > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int x = in.nextInt();
            
            //check
            if (printF(n, k, x))
                System.out.println("yes");
            else
                System.out.println("no");
            t--;
        }
    }

    public static boolean printF(int n, int k, int x) {
            if (k == 0 && x == 0) {
                return true; // Found a valid combination
            }
            if (k == 0 || x <= 0 || n <= 0) {
                return false; // No valid combination possible
            }
        
            return printF(n - 1, k - 1, x - n) || printF(n - 1, k, x);
        }
}
