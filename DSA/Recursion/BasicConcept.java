package Recursion;

import java.util.ArrayList;
import java.util.List;

public class BasicConcept {
    //public static int sum = 0;

    
    //                        *************** simple recursion  ******************
    
    
    //print name n times
    public static void f_name(int n) {
        if (n == 0)
            return;
        System.out.println("Jewel");
        f_name(n - 1);
    }
    //print 1-n backtracking recursion
    public static void printNumber(int n) {
        if (n == 0)
            return;
        System.out.println(n);  // n to 1
        printNumber(n - 1);
        //System.out.println(n);  // 1 to n
        
        
    }



    //            ###########################       functional recursion  ################
    // sum of 1 to n
    public static int sumOfnNumbers(int n) {
        int sum = 0;
        if (n == 0)
            return 0;
            sum = n + sumOfnNumbers(n - 1);
        return sum;
    }
    
    // factorial
    public static int factorial(int n) {
        int fact = 1;
        if (n == 1)
            return 1;
            fact = n * factorial(n - 1);
        return fact;
    }

    // reverse array using recursion
    //ekta certain index range reverse hobe of an array
    
    public static void reverse(int[] arr, int left, int right) {
        if (left >= right)
            return;

        int temp = arr[right];
        arr[right] = arr[left];
        arr[left] = temp;
        left++;
        right--;
        reverse(arr, left, right);
    }

    //palindrome check of an array
    public static boolean palindrome(char[] arr, int i) {

        if (i >= arr.length / 2)
            return true;
        if (arr[i] != arr[arr.length - i - 1]) {
            return false;
        }
        return palindrome(arr, i + 1);
    }
    
    // fibonacci number generate
    //  nth fibonacci number koto??
    // 0 1 1 2 3 5  :  4 th fibonacci = 3; startin 0 index....
    public static int fibonacci(int n) {
        if (n <= 1)
            return n;

        return fibonacci(n - 1) + fibonacci(n - 2);

    }
    
    // printing all sub sequence using recursion
    public static void prinF(int index, List<Integer> lst, int[] arr, int n) {
        if (index == n) {
            int sum = 0;
            for (int i : lst) {
                sum += i;
            }
            System.out.println(sum+ " : " + lst.toString());
            //System.out.println(lst.toString());
            return;
        }
        lst.add(arr[index]);
        prinF(index + 1, lst, arr, n);     // peak element
        lst.remove(lst.size() - 1);        // list er last element delete korte hobe perticular time
        prinF(index + 1, lst, arr, n);     //not peak element
        
        
    }
    
    // ###################              main function  ####################
    
    
    public static void main(String[] args) {
        //f_name(4);
        //printNumber(4);
        //System.out.println(sumOfnNumbers(3));
        //System.out.println(factorial(4));
    
        int[] arr = { 3,1,2};
        /*
        //reverse(arr, 2, 5);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        
        String str = "adam";
        System.out.println(palindrome(str.toCharArray(), 0));
         
        System.out.println(fibonacci( 9));
        */
        List<Integer> lst = new ArrayList<>();
        prinF(0, lst, arr, arr.length);

    }
}