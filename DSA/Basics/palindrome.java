package Basics;

public class palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindromeNum(121342));
    }

    //convert intger to string , then check..##############
    public static boolean isPalindrome(int x) {

        StringBuilder sb = new StringBuilder();
        sb.append(Math.abs(x));
        String s1 = sb.toString();

        int last = s1.length() - 1;
        for (int i = 0; i < s1.length() / 2; i++) {
            if (s1.charAt(i) != s1.charAt(last)) {
                return false;
            }
            last--;
        }
        return true;
    }
    //without convert sting.......###########
    public static boolean isPalindromeNum(int x) {
        int temp = x; //preserve x
        int rev = 0;
        if (x < 0) //consider -ve not palindrome
            return false;
        while (temp != 0) {
            rev = rev * 10 + temp % 10; //calculate reverse number
            temp = temp / 10;
        }
        if (rev != x) //check 
            return false;
        return true;

    }
    
}
