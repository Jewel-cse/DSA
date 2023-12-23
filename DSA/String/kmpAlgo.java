package DSA.String;

import java.util.Arrays;

public class kmpAlgo {
    
    static int[] createLPS(String pattern) {
        int left = 0, right = 1;
        int len = pattern.length();
        int[] lps = new int[len];

        while (right < len) {
            if (pattern.charAt(left) == pattern.charAt(right)) {
                lps[right] = left + 1;
                left++;
                right++;
            } else {
                if (left != 0)
                    left = lps[left - 1];
                else {
                    lps[right] = 0;
                    right++;
                }
            }

        }
        System.out.println(Arrays.toString(lps));
        return lps;
    }

    static void getMatch(String txt, String pattern) {
        int[] lps = createLPS(pattern);
        int tindex = 0, pindex = 0;
        int tlen = txt.length();
        int plen = pattern.length();
        
        while (tindex < tlen) {
            if (txt.charAt(tindex) == pattern.charAt(pindex)) {
                //System.out.println("equal");
                tindex++;
                pindex++;
            }
            if (pindex == plen) {
                System.out.println(pattern + " is found  at index " + (tindex - pindex));
                pindex = lps[pindex - 1];
            }
            else if (tindex < tlen && txt.charAt(tindex) != pattern.charAt(pindex)) {
                //System.out.println("not equal");
                if(pindex != 0)
                    pindex = lps[pindex - 1];
                else 
                    tindex++;
            }
        }
    }
    
    public static void main(String[] args) {
        String pattern = "abababc";
        String txt = "abcabcabababcabababc";
        getMatch(txt, pattern);
    }
}
