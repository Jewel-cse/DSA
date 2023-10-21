package String;

public class largestOddInString {
    public static void main(String[] args) {
        System.out.println(largestOddNumber("5322276666"));
    }

    public static String largestOddNumber(String str) {
        int i;
        for ( i = str.length() - 1; i >= 0; i--) {
            int x = (int) str.charAt(i);
            if (x % 2 == 1) {
                break;
                //substring position 0 to i
            }
        }
        return str.substring(0, i + 1);
    }
}
