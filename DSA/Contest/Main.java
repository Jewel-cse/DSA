package Contest;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int f(int a, int b, int c) {
        int min = Math.min(a, Math.min(b, c));
        int max = Math.max(a, Math.max(b, c));
        int mid = a + b + c - min - max;

        return gcd(min, mid);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = scanner.nextInt();
            }

            HashSet<List<Integer>> processedTriplets = new HashSet<>();
            int sum = 0;

            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        List<Integer> triplet = Arrays.asList(ar[i], ar[j], ar[k]);
                        Collections.sort(triplet);

                        if (!processedTriplets.contains(triplet)) {
                            int gcd = f(ar[i], ar[j], ar[k]);
                            sum += gcd;
                            processedTriplets.add(triplet);
                        }
                        else {
                            
                        }
                    }
                }
            }

            System.out.println(sum);
        }

        scanner.close();
    }
}
