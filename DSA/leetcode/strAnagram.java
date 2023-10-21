import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class strAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "aganara"));

    }

    public static boolean isAnagram(String s, String t) {

        //sort and check each position
        if (s.length() != t.length()) {
            return false;
        }
        //char array te convert kore nite hobe

        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        
        Arrays.sort(s1);
        Arrays.sort(s2);
       
        for (int i = 0; i < s.length(); i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }
}
