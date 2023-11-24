package Contest;

import java.util.Arrays;
import java.util.Scanner;

public class ChipRabin {
    private static int minTime(int[] ribbon) {
        int n = ribbon.length;
        int max = Arrays.stream(ribbon).max().getAsInt();
        if(n == 0)
            return 0;
        else if(n == 1 && ribbon[0] != 0)
            return max - 1;
        

    }
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t-- > 0) {
            //ready to input
            int n = scanner.nextInt();
            int[] ribbon = new int[n];
            for (int i = 0; i < n; i++) {
                ribbon[i] = scanner.nextInt();
            }
            System.out.println(minTime(ribbon));
        }
        scanner.close();
    
    }
}
