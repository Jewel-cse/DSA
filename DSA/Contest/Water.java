package Contest;

import java.util.Scanner;

public class Water {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            String s = scanner.next();
            int l = 0, k = 3;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '.') {
                    l++;
                    k--;
                    if (k == 0) {
                        break;
                    }
                } else {
                    k = 3;
                }
            }
            
            if (k == 0) {
                System.out.println(2);
            } else {
                System.out.println(l);
            }
        }
        scanner.close();
    }
}
