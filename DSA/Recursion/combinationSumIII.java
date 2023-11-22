package Recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class combinationSumIII {
    private static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();

        generate(1, k, n, new LinkedList<Integer>(), ans);
        return ans;
    }

    private static void generate(int ind, int k, int n, LinkedList<Integer> sublist, List<List<Integer>> ans) {
        if (k < 0 || n<0) {
            return;
        }
        if (k == 0 && n == 0) {
            ans.add(new ArrayList(sublist));
            return;
        }
        
        for (int i = ind; i <= 9; i++) {
            sublist.add(i);
            generate(i + 1, k - 1, n - i, sublist, ans);
            sublist.removeLast();
        }
    }
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7).toString());
    }
}
