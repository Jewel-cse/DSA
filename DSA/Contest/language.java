package Contest;

import java.util.Scanner;

public class language {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t-- > 0) {
            //ready to input
            int n = scanner.nextInt();
            String s = scanner.next();

            StringBuilder sb = new StringBuilder(s);
            int dot = 0;
            for (int i = 2; i < n - 1; i++) {
                if (s.charAt(i + 1) == 'a' || s.charAt(i + 1) == 'e')
                    sb.insert(i + dot++, '.');
            }

            System.out.println(sb.toString());
        }
        scanner.close();
    }
}
