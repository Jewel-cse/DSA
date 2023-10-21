import java.util.Arrays;

public class prime_seive {
    public static void main(String[] args) {
        System.out.println(countPrimes(2));
    }

    //how many prime number bellow n;
    public static int countPrimes(int n) {
        boolean[] arr = seive(n);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (arr[i]) {
                count++;
            }
        }
        return count;
    }
    //seive function 
    public static boolean[] seive(int n) {
        boolean[] arr = new boolean[n + 1];
        if (n < 2) {
            return arr;
        }
        
        Arrays.fill(arr, 2,n+1,true);
        
        int sqrtOf = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrtOf; i++) {
            if (arr[i] == true) {
                for (int j = 2; j < n; j++) {
                    if (i * j <= n) {
                        arr[i * j] = false;
                    }
                    else
                        break;
                }
                
            }
        }
        return arr;
    }
}
