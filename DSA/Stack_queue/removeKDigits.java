package Stack_queue;

import java.util.Stack;

public class removeKDigits {
    public static String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        //current<peek: pop and k--
        for (int i = 0; i < num.length(); i++) {
            while (!st.empty() && k > 0 && (int) num.charAt(i) < st.peek()) {
                k--;
                st.pop();
            }
            st.push(num.charAt(i));
        }
        //ensure k number of digits remove
        while (k > 0 && !st.empty()) {
            st.pop();
            k--;
        }
        //make string       
        StringBuilder sb = new StringBuilder();
        while (!st.empty()) {
            sb.append(st.pop());
        }
        
        //reverse string
        sb.reverse();
        //leading zoros are removed
        int startIndex = 0;
        while (startIndex < sb.length() && sb.charAt(startIndex) == '0') 
            startIndex++;
    

        //output
        return sb.substring(startIndex) != "" ? sb.substring(startIndex).toString() : "0";
        
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("10200", 1));
    }
}
