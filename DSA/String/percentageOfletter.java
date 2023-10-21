package String;

import java.util.HashMap;

public class percentageOfletter {

    public static void main(String[] args) {
        System.out.println(percentageLetter("foobar", 'o'));
    }
    public static  int percentageLetter(String s, char letter) {
        HashMap<Character, Integer> map = new HashMap<>();
        //frequency count
        int total = s.length();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        if (!map.containsKey(letter)) {
            return 0;
        }
        return (int) map.get(letter)*100 / total;
    }
}
