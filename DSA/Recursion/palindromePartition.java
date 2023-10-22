package Recursion;

import java.util.ArrayList;
import java.util.List;

public class palindromePartition {
    //palindrome check
    public static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
    //main function for palindrome partition 
    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        f(s, 0, new ArrayList<String>(), ans);
        return ans;
    }

    //
    public  static void f(String s, int index, List<String> ds, List<List<String>> ans) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                ds.add(s.substring(index, i + 1));
                f(s, i + 1, ds, ans);
                ds.remove(ds.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(partition("aab").toString());
    }
}
