package String;

public class splitBalancedString {
    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
    }

    public static int balancedStringSplit(String s) {
        int balanced = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L')
                count++;
            else if (s.charAt(i) == 'R')
                count--;

            if (count == 0) {
                balanced++;
            }
        }
        return balanced;
    }
}
