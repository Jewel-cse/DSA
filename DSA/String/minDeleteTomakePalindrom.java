package String;

public class minDeleteTomakePalindrom {
    private static int longestpalindromesubstr(String str) {
        if(str.length() == 1)
            return 1;
        int plen = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) {
            
            //while center i
            int len = palindromLen(str, i, i);
            if(len>plen)
                plen = len;
            
            len = palindromLen(str, i, i+1);
            if(len>plen)
                plen = len;
            
        }
        return plen;
    }

    private static int palindromLen(String str, int i, int j) {
        while (i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)) {
            i--;
            j++;
        }
        return j - (i + 1);
    }
    
    private static int mindeleteoToMakePalindrome(String s) {
        int strlen = s.length();
        int plen = longestpalindromesubstr(s);
        return strlen - plen;
    }
    
    //main code
    public static void main(String[] args) {
        System.out.println(mindeleteoToMakePalindrome("aba"));    
    }
}
