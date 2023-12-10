package SRBD;

import java.util.Scanner;
public class StringCompression {

    public static void mergeAlpha(char[] str) {
        int lenString = str.length;
        int[] hash = new int[26];

        for (int i = 0; i < lenString; i++) {
            char letter = str[i];
            i++;

            int temp = 0;
            while (i < lenString && str[i] >= '0' && str[i] <= '9') {
                temp = (temp * 10) + (str[i] - '0');
                i++;
            }
            i--;

            hash[letter - 'a'] += temp;
            System.out.println(hash[letter-'a']);
        }

        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0) {
                char temp = (char) (i + 'a');
                System.out.print(temp + " " + hash[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] s = input.toCharArray();
        mergeAlpha(s);
        scanner.close();
    }
}
