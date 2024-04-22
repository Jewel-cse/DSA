//package String;

import java.util.Arrays;

public class SearchPattern_Z_algo {
    private static  void indexOfPatternInText(String pat,String text){
        int patlen = pat.length();
        int txtlen = text.length();

        String newStr = pat +"@"+text;
        int n = newStr.length();
        int[] z = new int[n];

        int i = patlen+1;
        while (i<n) {
            int left = 0;
            int right = i;
            if(pat.charAt(left) == newStr.charAt(right)) {
                int k = right;
                while (k<n && left<patlen && newStr.charAt(k) == pat.charAt(left)) {
                    left++;
                    k++;
                }
                z[i] = left;
            }
            i++;
        }
        System.out.println(Arrays.toString(z));

        for(i= pat.length()+1;i<n;i++){
            if(z[i] == pat.length()){
                //index of text which pattern are found- 0_based index
                System.out.println(i-pat.length()-1);
            }
        }
    }
    public static void main(String[] args) {
        //z-algorithm: tc (m+n) : length of patern and text.
        indexOfPatternInText("pat", "patopatg");
    }
}
