package Contest;

import java.util.Scanner;

public class Short_sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String str = sc.next();
            //System.out.println(short_sort(str));
            if (short_sort(str)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            t--;
        }
        sc.close();
    }

    public static boolean short_sort(String str) {
        if (str.equals("bca") || str.equals("cab")) {
            //System.out.println("no");
            return false;
        } else if (str.length() == 3 && str.contains("a") && str.contains("b") && str.contains("c")) {
            //System.out.println("yes");
            return true;
        }
        return false;
    }
}

/*
 * abc
acb
bac
bca
cab
cba
 */
