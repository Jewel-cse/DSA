
public class rmove_adjacent_duplicate {
    public static void main(String[] args) {
    
        String str = "leet**cod*e";
        System.out.println(removeDuplicates(str));
    }
    //method
    public static String removeDuplicates(String s) {

        StringBuilder sb  = new StringBuilder();
        int len = s.length();
        int cnt = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '*') {
                cnt++;
            } else if (cnt == 0) {
                sb.append(s.charAt(i));
            } else
                cnt--;

        }
        sb.reverse();
        System.out.println(sb.toString());
        return sb.toString();
    }
        
}
