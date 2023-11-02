package String;

import java.util.HashSet;

public class reverseVowel {

    public static String reverseVowels(String s) {
        HashSet<Character> hs = new HashSet<>();
        hs.add('A');
        hs.add('E');
        hs.add('I');
        hs.add('O');
        hs.add('U');
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');

        int left = 0;
        int right = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);
        while (left < right) {
            boolean lContains = hs.contains(s.charAt(left));
            boolean rContains = hs.contains(s.charAt(right));
            if (!rContains)
                right--;
            if (!lContains)
                left++;
            if (lContains && rContains) {
                sb.setCharAt(left, s.charAt(right));
                sb.setCharAt(right, s.charAt(left));
                left++;
                right--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(reverseVowels(s));
    }
}

