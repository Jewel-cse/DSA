package String;

public class rotateString {
    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "abcde"));
    }

    public static boolean rotateString(String s, String goal) {
        
        StringBuilder sb = new StringBuilder(s);
        
        for (int i = 0; i < s.length(); i++) {
            sb.append(sb.charAt(0)); //last e add
            sb.deleteCharAt(0); //delete first
            if (sb.toString().equals(goal)) {
                //System.out.println(sb.toString());     
                return true;
            }
        }
        return false;
    }
}
