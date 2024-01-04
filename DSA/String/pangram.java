package String;

public class pangram {
    private static boolean isPangram(String s) {
        boolean[] vis = new boolean[26];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            //check upper case
            //check lower case
            //check other
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                index = s.charAt(i) - 'A';
            else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                index = s.charAt(i) - 'a';

            else
                continue;
            vis[index] = true;
        }

        for (int i = 0; i < 26; i++) {
            if (!vis[i])
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        String s = "The quick brown fox jumps over the lazy dog";
        String s1 = "The quick brown fox jumps over ";
        System.out.println(isPangram(s));
        System.out.println(isPangram(s1));
    }
}
