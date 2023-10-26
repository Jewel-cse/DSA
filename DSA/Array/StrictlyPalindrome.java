public class StrictlyPalindrome {
    //find base............
    public static String base(int n, int base) {
        long temp = (long) n;
        StringBuilder sb = new StringBuilder();
        while (temp != 0) {
            sb.append(temp % base);
            temp = temp / base;
        }
        sb.reverse();
        return sb.toString();
    }

    //palindrome check
    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n - 2; i++) {
            String s = base(n, i);
            if (!isPalindrome(s)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        //System.out.println(isStrictlyPalindromic(4));
        System.out.println(base(1000, 998));
    }
}
