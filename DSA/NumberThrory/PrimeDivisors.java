package NumberThrory;

import java.util.ArrayList;
import java.util.List;

public class PrimeDivisors {
    //trial division method : 6k+-1 rule
    //efficient for 32-bit or 64-bit : ~2.1 billion numbers
    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    //provide a list of all prime factors
    public static List<Integer> countPrimes(int n) {
        List<Integer> ls = new ArrayList<>();
        int a = 0;
        int b = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                a = isPrime(i) ? i : 0;
                b = isPrime(n / i) ? n / i : 0;
                if (a != 0) {
                    ls.add(a);
                }
                if (a != b && b != 0) {
                    ls.add(b);
                }
            }
        }
        return ls;
    } 
    

    public static void main(String[] args) {
        System.out.println(countPrimes(2310).toString());
    }
}
