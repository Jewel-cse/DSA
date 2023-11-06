package String;

public class reverseKpartition {
    public static String reverseStr(String s, int k) {
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < len; i += 2 * k) {
            if(i+k-1 < len)
                reverse(sb, i, i + k - 1);
            else
                reverse(sb, i, len-1);
        }
        return sb.toString();
    }
    public static void reverse(StringBuilder s , int start,int end){
        while (start < end) {
            char temp = s.charAt(end);
            s.setCharAt(end, s.charAt(start));
            s.setCharAt(start,temp);
    
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        String s = "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
        System.out.println(reverseStr(s, 39));
    }
}
