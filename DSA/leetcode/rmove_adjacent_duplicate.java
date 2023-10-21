import java.util.Stack;

public class rmove_adjacent_duplicate {
    public static void main(String[] args) {
    
        String str = "leet**cod*e";
        System.out.println((str));
    }
    //method
    public String removeDuplicates(String s) {

        Stack st = new Stack<Character>();
        int len = s.length();
        st.push(s.charAt(0));
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) != ) {
                st.push(s.charAt(i));
            }
            else {
                st.pop();
            }
        }
    }
        
}
