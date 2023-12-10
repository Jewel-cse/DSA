package SRBD;

/*
https://www.geeksforgeeks.org/samsung-interview-experience-set-40-campus-white-box-testing/
https://www.geeksforgeeks.org/samsung-rd-sri-noida-on-campus-interview-experience/

Company  A  is discarding product numbers that contain few specific digits a specific number of time or 
more than that. You are given a range and you need to find product numbers that are possible.

For instance, consider a range from 24 to 12943 and the prohibited digits are 1, 3, and 5.
The condition specifies that these digits should not occur 
three or more times within any product number.
Here's a breakdown of the conditions for the given example:

##For two-digit numbers (24 to 99), all numbers are valid because they don't meet the criteria of containing the 
prohibited digits 1, 3, or 5, three or more times.
##For three-digit numbers (100 to 999), some numbers such as 111, 113, 115, 311, 331, 333, 511, 533, and 555 
are not valid as they contain the prohibited digits 1, 3, or 5 three or more times.
##For four-digit numbers (1000 to 9999), any numbers that contain the invalid three-digit numbers mentioned 
earlier (like 111, 113, etc.) are also considered invalid. For instance, 11223 is invalid because it contains 113, 
which violates the criteria.

Eg: 11223 is not valid, 11222 is valid.

@@@@@@@@@@@@@@@@@@
Intuition: 
 from a to b:
    : make digit frequency of number
    : calculate forbidden frequencies 
    : compare given count if less then ok count++
*/
import java.util.Scanner;
public class omniousNumber {
    static int numberOminous(int a, int b, int k, int[] delNos, int n) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            int temp = i;
            int[] digitArray = new int[10];

            while (temp > 0) {
                digitArray[temp % 10]++;
                temp /= 10;
            }

            int forbiddenK = 0;
            for (int j = 0; j < n; j++) {
                forbiddenK += digitArray[delNos[j]];
            }

            if (forbiddenK < k) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // range(a,b) , k = count, n = number of digit
        int a = scanner.nextInt();  
        int b = scanner.nextInt();
        int k = scanner.nextInt();
        int n = scanner.nextInt();

        int[] delNos = new int[n];
        for (int i = 0; i < n; i++) {
            delNos[i] = scanner.nextInt();
        }

        System.out.println(numberOminous(a, b, k, delNos, n));

        scanner.close();
    }
}

