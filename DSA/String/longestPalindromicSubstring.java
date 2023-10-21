package String;
public class longestPalindromicSubstring {
    static int maxlen = 0;
    static int low = 0;

    public static void main(String[] args) {
        System.out.println(longestPalindrome("sbabssdfsfj"));
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;
        for (int i = 0; i < len - 1; i++) {
            expandPalindrome(s, i, i); // odd length palindrome ex : aba
            expandPalindrome(s, i, i+1); // even length palindrome  ex: aa

        }
        return s.substring(low, low + maxlen);   /////// start theke print korbe/
    }

    public static void expandPalindrome(String s,int j,int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxlen < k - j - 1) {
            low = j + 1;
            maxlen = k-j-1;
        }
    }
}
