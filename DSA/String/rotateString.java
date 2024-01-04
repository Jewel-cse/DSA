package String;

public class rotateString {
    public static void main(String[] args) {
        System.out.println(rotateString("abde", "abcde"));
        System.out.println(isRotation("abde", "abcde"));
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
    
    //time; o(2*n), space: o(2n)
    private static boolean isRotation(String s, String g) {
        String con = g + g;
        int i = 0, j = 0;
        
        int m = con.length();

        while (j < m) {
            if (s.charAt(i) == con.charAt(j)) {
                i++;
                j++;
                if (i == s.length())
                    return true;
            } else {
                if (i != 0)
                    i = 0;
                j++;
            }
        }
        return false;
    }
}
