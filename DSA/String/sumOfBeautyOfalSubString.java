package String;

import java.util.Collections;
import java.util.HashMap;


public class sumOfBeautyOfalSubString {
    public static void main(String[] args) {
        System.out.println(beautySum("aabcbaa"));
    }

    // this approach : time complexity high...............*********************
    public static int beautySum(String s) {
        //generate substring
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                //summation of beauty value of each substring
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                sum += BeautyValue(map);   
            }
        }
        return sum;
    }

    public static int BeautyValue(HashMap<Character, Integer> map) {

        int max = Collections.max(map.values());
        int min = Collections.min(map.values());

        return max - min;
    }
    

    //Best approach  reducing time complexity...............##############

    public static int beautySumUsingArray(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] letter = new int[26];
            for (int j = i; j < s.length(); j++) {
                letter[s.charAt(j) - 'a']++;
                int beauty = beautyValue(letter);
                sum += beauty;
            }
        }
        return sum;
    }

    public static int beautyValue(int[] arr){
        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min && arr[i] != 0) {
                min = arr[i];
            }
        }
        return max - min;
    }
}
