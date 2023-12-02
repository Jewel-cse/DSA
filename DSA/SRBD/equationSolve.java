package SRBD;

/*<Binary search>
Solve the equation f(k) = a * k + b * k * log2(k) + c * k^3;
Input: a , b , c , x where x is the result of the equation i.e. f(k) = x
Output: find the value of k such that f(k) = x
[NOTE: All value will fit in 64 bit integer]

Sample input/output:
1 2 3 30
k = 2 

2 3 1 84 
k = 4

0 5 3 69
k = 3
*/
import java.util.*;
public class EquationSolve {
   

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tc = scanner.nextInt();
        while (tc-- > 0) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long c = scanner.nextLong();
            long x = scanner.nextLong();

            Long ans = solve(a, b, c, x);
            System.out.println("ans : " + ans);
        }
        scanner.close();
    }

    private static long getans(long a,long b,long c,long k) {
        long ans = a * k + b * k * log(k);
        if (c != 0) {
            ans += c * k * k * k;
        }
        return ans;
    }

    private static long log(long k) {
        return (long) (Math.log(k)/Math.log(2));
    }

    private static Long solve(long a, long b, long c, long x) {
        long low = 0, high = x, mid;
        while (low<= high) {
            mid = low + (high - low) / 2;
            if(getans(a,b,c,mid) == x)
                return mid;
            else if (getans(a, b, c, mid) < x) {
                low = mid +1;
            }
            else
                high = mid - 1;
        }
        return low;
    }
}

    