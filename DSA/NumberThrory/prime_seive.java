package NumberThrory;
import java.util.Arrays;

public class prime_seive {

    public static void main(String[] args) {
        //System.out.println(countPrimes(2));
        /*  boolean[] prime = seive(100);
        for (int i = 0; i <= 100; i++) {
          if(prime[i])
              System.out.print(i+" ");
        */

        bitwiseSeive(300);
    }

    //----------------------- Seive -------------------------
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
    //seive function  : o(n Log (log n)), memory : o(n)
    public static boolean[] seive(int n) {
        boolean[] arr = new boolean[n + 1];
        if (n < 2) {
            return arr;
        }
        //initialize all value with true prime 
        Arrays.fill(arr, 2, n + 1, true);

        for (int primeIndex = 2; primeIndex * primeIndex <= n; primeIndex++) {
            if (arr[primeIndex]) {//true means this is prime , delete its multiple from prime list
                for (int multipleOfPrime = primeIndex
                        * primeIndex; multipleOfPrime <= n; multipleOfPrime += primeIndex) {
                    arr[multipleOfPrime] = false;
                }
            }
        }

        return arr;
    }
    
    // We can optimize the space : using@@@@@@@@@@@@@  bitwise seive 
    // bit 0 means prime;   set one for multiple of prime
    private static void bitwiseSeive(int n) {
        int[] status = new int[n / 32 + 1];
        
        int sqn = (int) Math.sqrt(n);
        for (int prime = 3; prime <= sqn; prime += 2) {
            if (isPrimeIndex(status[prime / 32], prime % 32)) { //get prime 
                for (int i = prime * prime; i <= n; i += 2*prime) { // set 1 for multiple of prime
                    status[i/32] = setNotPrime(status[i / 32], i % 32);
                }
            }
        }
        //print the seive
        System.out.println(status[1]);
        System.out.print(2 +" ");
        for (int i = 3; i <= n; i+= 2) {
            if(isPrimeIndex(status[i/32], i%32))
                System.out.print(i+" ");
        }
    }

    private static boolean isPrimeIndex(int value, int pos) {
        return (value & (1<<pos)) == 0;
    }

    private static int setNotPrime(int previousValue, int pos) {
        return previousValue = (previousValue | (1 << pos));  //set 1 for not prime  in pos of index/32
    }


}
