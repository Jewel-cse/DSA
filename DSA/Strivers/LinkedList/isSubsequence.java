package Strivers.LinkedList;

public class isSubsequence {
    public static void main(String[] args) {
        String s = "";
        String t = "ahbgdc";
        System.out.println(s.length());
        System.out.println(isSubsequence(s,t));
    }
    public  static  boolean isSubsequence(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen == 0)
            return true;
        int spointer = 0;
        int tpointer = 0;
        while (spointer < slen && tpointer < tlen) {
            if (s.charAt(spointer) == t.charAt(tpointer)) {
                spointer++;
                tpointer++;
            } else {
                tpointer++;
            }

            if (spointer == (slen)) {
                    return true;
        }
        }
        return false;
    }
}
