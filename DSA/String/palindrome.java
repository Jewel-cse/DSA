package String;

public class palindrome {
    /*
     * app1: iterative way
     * app2: recursive way
     */


    //iterative way
    private static boolean isPalindromeIterative(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    //recursive way
    private static boolean isPalindromeRecursion(String s,int start,int end) {
        if(start>= end)
            return true;
        else if(s.charAt(start) != s.charAt(end))
            return false;
        return isPalindromeRecursion(s, ++start, --end);
    }
    
    //driver code
    public static void main(String[] args) {
        String s = "ojojo";
        System.out.println(isPalindromeIterative(s));
        System.out.println(isPalindromeRecursion(s,0,s.length()-1));
    }
}
