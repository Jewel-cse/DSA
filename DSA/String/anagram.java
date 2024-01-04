package String;

import java.util.Arrays;

public class anagram {

    //using sorting ............
    public boolean isAnagram(String s, String t) {
        //sort and check each position
        if (s.length() != t.length()) {
            return false;
        }
        //char array te convert kore nite hobe

        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(s2);
        //check each position
        for (int i = 0; i < s.length(); i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }
    

    //using array haashing
    private static boolean isAnagram2(String s1, String s2) {
        int n = s1.length();
        if(n != s2.length())
            return false;
        int[] hash1 = new int[256];
        int[] hash2 = new int[256];

        for (int i = 0; i < n; i++) {
            hash1[s1.charAt(i)]++;
            hash2[s2.charAt(i)]++;
        }
        for (int i = 0; i < 256; i++) {
            if (hash1[i] != hash2[i])
                return false;
        }
        return true;
    }
    
}
