package String;


public class removeOuterParenthesis {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
    }
    public static String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' && cnt == 0) {
                cnt++;
            } else if (s.charAt(i) == '(' && cnt >= 1) {
                sb.append(s.charAt(i));
                cnt++;
            } else if (s.charAt(i) == ')' && cnt > 1) {
                sb.append(s.charAt(i));
                cnt--;
            } else if (s.charAt(i) == ')' && cnt == 1) {
                cnt--;
            }
        }
        return sb.toString();
    }
}
