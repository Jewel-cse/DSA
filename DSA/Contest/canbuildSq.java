package Contest;

import java.util.Scanner;

public class canbuildSq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t-- > 0) {
            //ready to input
            int n = scanner.nextInt();
            int[] el = new int[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                el[i] = scanner.nextInt();
                sum += el[i];
            }
            String s = isexist(sum) ? "yes" : "no";
            System.out.println(s);
        }
        scanner.close();

    }

    private static boolean isexist(long sum) {
        long low = 1;
        long high = sum;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid == sum) {
                return true;
            } else if (mid * mid < sum)
                low = mid + 1;

            else
                high = mid - 1;
        }
        return false;
    }
}
