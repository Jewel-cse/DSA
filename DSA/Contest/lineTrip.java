package Contest;

import java.util.Scanner;

public class lineTrip {
    private static int minTankSize(int[] gstation, int x,int n) {
        int max = gstation[0] ;
        for (int i = 1; i < gstation.length; i++) {
            if (gstation[i] - gstation[i - 1] > max) {
                max = gstation[i] - gstation[i - 1];
            }
        }
        if (2 * (x - gstation[n - 1]) > max) {
            max = 2 * (x - gstation[n - 1]);
        }
        return max;
    }
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t-- > 0) {
            //ready to input
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int[] gasTation = new int[n];
            for (int i = 0; i < n; i++) {
                gasTation[i] = scanner.nextInt();
            }
            System.out.println(minTankSize(gasTation, x, n));
        }
        scanner.close();
    
    }
}
