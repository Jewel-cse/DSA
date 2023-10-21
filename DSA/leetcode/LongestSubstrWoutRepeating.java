import java.util.HashSet;

public class LongestSubstrWoutRepeating {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));

    }
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        
        int len = 0;
        int l =0;
        int r = 0;

        while (r < s.length()) {
            if (!hs.contains(s.charAt(r))) {
                hs.add(s.charAt(r));
                if ((r - l + 1) > len)
                    len = r - l + 1;
                r++;
            } 
            else {
                hs.remove(s.charAt(l));
                l++;
            }
        }
        return len;
    }
}
