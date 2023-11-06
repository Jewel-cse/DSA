package Recursion;

import java.util.HashMap;
import java.util.List;

public class LettercCombination {
    public static List<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap<>();
        String[] s = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        for (int i = 2; i <= 9; i++) {
            map.put(i, s[i - 2]);
        }
        //System.out.println(map.toString());

    }
    
    public static void main(String[] args) {
        letterCombinations("23");
    }
}
