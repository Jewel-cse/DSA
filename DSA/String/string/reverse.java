package String.string;

public class reverse {
    
    /*
     * 4 way in java to reverse string
     * .using charArry() method
     * .using charAt(int index)
     * .using java.lang.StringBuffer : reverse()
     * .               .StringBuilder: reverse()
     * 
     */

    public static String reverseString(String s) {
        int len = s.length();
       // char[] cr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
     public static void main(String[] args) {
        System.out.println(reverseString("null"));
     }
}
