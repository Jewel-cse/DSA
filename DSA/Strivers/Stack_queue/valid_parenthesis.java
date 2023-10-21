import java.util.Stack;

public class valid_parenthesis {
    public static void main(String[] args) {
        String str = "[])";
        System.out.println(isValid(str));
    }
    
    public static boolean isValid(String s) {
        Stack <Character> st = new Stack<>();
        char[] str = s.toCharArray();

        char ch = 'N';
    
        for (int i = 0; i < s.length(); i++) {
            
            if (str[i] == '(' || str[i] == '{' || str[i] == '[') {
                st.push(str[i]);
            }
            else {
                switch (str[i]) {
                    case ')':
                        ch = '(';
                        break;
                    case '}':
                        ch = '{';
                        break;
                    case ']':
                        ch = '[';
                        break;
                }
                if (st.empty() || ch != st.pop() ) {
                    return false;
                }                
            }
        }
        
        return st.isEmpty();
    }
}
