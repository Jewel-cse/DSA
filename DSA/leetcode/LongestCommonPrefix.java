import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] s = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(s));
    }
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int index = 0;
        String s0 = strs[0];
        String sLast = strs[strs.length - 1];
        StringBuilder sb = new StringBuilder();
        while (index < s0.length() && index < sLast.length()) {
            if (s0.charAt(index) == sLast.charAt(index)) {
                sb.append(s0.charAt(index));
                index++;
            } else
                break;
        }
        return sb.toString();
    }
}
