package String;

public class maximumNestingDepth {
    
    public int maxDepth(String s) {
        int cnt = 0;
        int maxDepth = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
                if (cnt > maxDepth) {
                    maxDepth = cnt;
                }
            }
            if (s.charAt(i) == ')') {
                cnt--;
            }
        }
        return maxDepth;
    }
}
