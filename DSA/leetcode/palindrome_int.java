
import java.util.Scanner;

public class palindrome_int {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        palindrome( n);
        sc.close();
    }
    static void palindrome(int n){
        int last_bit;
        int[] arr = new int[10];
        int start = 0;
        
        //digit seperation
        while(n>0){
            last_bit = n%10;
            n = n/10;
            arr[start] = last_bit;
            start ++;
        }
        //print digit
        for (int i = 0; i < start; i++) {
            System.out.println(arr[i]);
        }
        
        
        //check for palindrome
        int end = start-1;
        start = 0;
        boolean flag = true;
        while (start<end) {
            if (arr[start] != arr[end]) {
                flag = false;
                break;
            }
            start++;
            end--;
        }
        if (flag) {
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
        
        
    }
}
