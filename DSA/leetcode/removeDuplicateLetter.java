import java.util.HashSet;

public class removeDuplicateLetter {
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }

    public static String removeDuplicateLetters(String s) {
        
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!hs.contains(s.charAt(i))) {
                hs.add(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : hs) {
            sb.append(character);
        }

        return sb.toString();
    }
}
