package Basics;

import java.util.Arrays;

public class test {
    private static int setNotPrime(int previousValue, int pos) {
        return (previousValue | (1 << pos)); //not kore  in pos bit 
    }

    public static void main(String[] args) {
        int[] s = { 4};
        s[1 / 32] = setNotPrime(s[1 / 32], 1 % 32);

        System.out.println(Arrays.toString(s));
        
    }
}
