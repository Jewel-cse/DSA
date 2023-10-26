package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sortCharByString {
    
    public static void main(String[] args) {
        System.out.println(frequencySort("Iamjewelrana"));
        System.out.println(Arrays.toString(sortArrayByfreq(new int[]{1,1,2,2,2,3})));
    }

    public static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, Comparator.comparing(Map.Entry::getValue));
        Collections.reverse(entryList);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entryList) {
            //System.out.println(entry.getKey() + " " + entry.getValue());
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
    //sort arrray by increasing frequency
    public static int[] sortArrayByfreq(int[] ar) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < ar.length; i++) {
            map.put(ar[i], map.getOrDefault(ar[i], 0) + 1);
            
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, Comparator.comparing(Map.Entry::getValue));
        
        int[] res = new int[ar.length];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : entryList) {
            for (int i = 0; i < entry.getValue(); i++) {
                res[index++] = entry.getKey();
            }
        }

        return res;
    }
}
