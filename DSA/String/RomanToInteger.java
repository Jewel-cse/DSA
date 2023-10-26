package String;

import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("VIVI"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("IV"));

    }

    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);


        int result = 0;
        for (int j = 0; j < s.length(); j++) {
            int current  = map.get(s.charAt(j));
            if(j<s.length() - 1){
                int next = map.get(s.charAt(j+1));
                if(current<next){
                    result -= current;
                }else{
                    result += current;
                }
            }
            result += current;
        }
    
        return result;
    }
}
//M = 1000, CM = 900, XC = 90 and IV = 4