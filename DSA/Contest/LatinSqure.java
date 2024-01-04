package Contest;

import java.util.Scanner;

public class LatinSqure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t-- > 0) {
            //ready to input
            String[] str = new String[3];
            for (int i = 0; i < 3; i++) {
                str[i] = scanner.next();
            }
            //function
            int a = 0, b = 0, c = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (str[i].charAt(j) == 'A')
                        a++;
                    else if (str[i].charAt(j) == 'B')
                        b++;
                    else if (str[i].charAt(j) == 'C')
                        c++;
                }
            }
            if(a == 2)
                System.out.println("A");
            if(b == 2)
                System.out.println("B");
            if(c == 2)
                System.out.println("C");
            
        }
        scanner.close();

    }
}
