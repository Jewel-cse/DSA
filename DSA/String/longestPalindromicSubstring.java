package String;
public class longestPalindromicSubstring {
    static int maxlen = 0;
    static int low = 0;

    public static void main(String[] args) {
        System.out.println(longestPalindrome("sbabssdfsfj"));
        System.out.println(longestPalindromicsubstring("sbabssdfsfj"));
    }


    //using recursive solution
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

    public static void expandPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxlen < k - j - 1) {
            low = j + 1;
            maxlen = k - j - 1;
        }
    }
    
    //Simple iteration of string 
    private static String longestPalindromicsubstring(String str) {
        if (str == null || str.length() == 1)
            return str;

        //initialize substring
        String longest = str.substring(0, 1);
        int maxlen = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) {
            //while center is i ,i 
            String temp = getmaxPalindromicSubstring(str, i, i);
            if (temp.length() > longest.length()) {
                longest = temp;
                maxlen = temp.length();
            }
            //while center is i ,i +1
            temp = getmaxPalindromicSubstring(str, i, i + 1);
            if (temp.length() > longest.length()) {
                longest = temp;
                maxlen = temp.length();
            }
        }
        System.out.println("Maximum length of palindromic substring: "+maxlen);
        return longest;
    }

    private static String getmaxPalindromicSubstring(String str, int i, int j) {
        while (i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)) {
            i--;
            j++;
        }
        return str.substring(i + 1, j);
    }
    
}
