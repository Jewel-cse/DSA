package String;

public class isomorphic {
    //check if two string is isomorphic
    private static boolean isomorphic(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int[] m1 = new int[128];
        int[] m2 = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            if (m1[s1.charAt(i)] != m2[s2.charAt(i)])
                return false;
            m1[s1.charAt(i)] = i + 1;
            m2[s2.charAt(i)] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isomorphic("paper", "titlw"));
    }
}
