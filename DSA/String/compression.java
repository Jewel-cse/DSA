package DSA.String;

import java.util.ArrayList
import java.util.List;

class compression {

    public static int compress(char[] chars) {
        if (chars.length < 1)
            return 0;
        int left = 0;
        int right = 1;
        int cnt = 1;
        
        List<Character> ls = new ArrayList<>();
        
        while (right < chars.length) {
            if (chars[left] != chars[right]) {
                ls.add(chars[left]);
                ls.add(Character.forDigit(cnt, 10));
                left = right;
                right++;
                cnt = 1;
            } else {
                ++cnt;
                right++;
            }

        }
        ls.add(chars[left]);
        ls.add(Character.forDigit(cnt, 10));
        
        System.out.println(ls.toString());
        return ls.size();
    }
    
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','a','b','a','a','b'}));
    }

}