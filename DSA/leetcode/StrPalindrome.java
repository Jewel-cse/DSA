public class StrPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {
        //space , different character are removed........
        String str = s.trim().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        //char[] arr = str.toCharArray();
        int n = str.length();
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
