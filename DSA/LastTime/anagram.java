package LastTime;

import java.util.Arrays;
import java.util.HashMap;

public class anagram {

    //Approach 1: 
    //  TC: O(n) + O(n)    SP: O(s+t)  > number of distinct char in s and t
    public static boolean isAnagram_map(String s, String t) {
        // check the length of two string ,if not equal : false
        if (s.length() != t.length()) {
            return false;
        }
        //create 2 hashmap: add char into hashmap<hashmap by default sort thake>
        HashMap<Character, Integer> hs1 = new HashMap<>();
        HashMap<Character, Integer> hs2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hs1.put(s.charAt(i), hs1.getOrDefault(s.charAt(i), 0));
            hs2.put(t.charAt(i), hs2.getOrDefault(t.charAt(i), 0));
        }

        //System.out.println(hs1.toString());
        //System.out.println(hs2.toString());

        //check any frequncy not similar : if then false
        for (int i = 0; i < s.length(); i++) {
            if (hs1.get(s.charAt(i)) != hs2.get(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    //Approach 2: 
    //sorting and check  TC: n logn+ n logn+ n =~ n log n   SP: O(1)
    public static boolean isAnagram_sort(String s, String t) {
        if(s.length() != t.length())
            return false;
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();

        Arrays.sort(s1);   //n log n
        Arrays.sort(s2); // n log n
        for (int i = 0; i < s2.length; i++) {
            if(s1[i] != s2[i])
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(isAnagram_sort("cat", "tac"));
    }
}
