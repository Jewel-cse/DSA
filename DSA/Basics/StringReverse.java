package Basics;

import java.util.Arrays;

public class StringReverse {
    public static void main(String[] args) {
        String s = "hello salam";
        
        //System.out.println(reverse(s));

        //System.out.println(reverseNum(12345));

        //System.out.println(decToBinary(15));

        //System.out.println(perfectNum(2131));

        System.out.println(Arrays.toString(topTwo(new int[]{1,1})));

    }

    //@@@@@@@@@@@@@@@  string reverse using recursion@@@@
    //call for 1st index and add 0th to last
    private static String reverse(String s) {
        if (s.isEmpty())
            return s;
        return reverse(s.substring(1)) + s.charAt(0);
    }
    

    //@@@@@ reverse a number
    private static int reverseNum(int n) {
        int num = n;
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }
    
    //@@@@@@ decimal to binary 
    private static String decToBinary(int decimal) {
        StringBuilder b = new StringBuilder();
        while (decimal > 0) {
            b.insert(0, decimal % 2);
            decimal /= 2;
        }

        return b.toString();
    }
    

    //// @@@@@@@@@ perfect number
    private static boolean perfectNum(int num) {
        if (num <= 1)
            return false;
        int sum = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) {
                    sum += num / i;
                }
            }
        }
        return sum == num;
    }
    

    /// @@@@@@@ top two maximum in array
    private static int[] topTwo(int[] num) {
        if (num.length < 2)
            return new int[] { -1, -1 };

        int max = num[0];
        int second = Integer.MIN_VALUE;

        for (int i = 0; i < num.length; i++) {
            if (num[i] > max) {
                second = max;
                max = num[i];
            } else if (num[i] > second && num[i] < max) {
                second = num[i];
            }
        }
        return new int[] { max, second };
    }
}
