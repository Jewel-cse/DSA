package Contest;

import java.util.Scanner;

public class OddONeOUt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t-- > 0) {
            //ready to input
            int[] n = new int[3];
            for (int i = 0; i < 3; i++) {
                n[i] = scanner.nextInt();
            }

            //calculation part
            int ans = 0;
            for (int i = 0; i < 3; i++) {
                ans ^= n[i];
            }
            System.out.println(ans);
        }
    }
}
