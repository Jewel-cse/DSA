package String;

public class countWithKdiffChar {
    public static void main(String[] args) {
        System.out.println(countSubStrings("aacfssa", 3));
    }

    public static int countSubStrings(String str, int k) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            int[] ar = new int[26];
            for (int j = i; j < str.length(); j++) {
                ar[str.charAt(j) - 'a']++;
                int distinctChar = countChar(ar);
                if (distinctChar == k) {
                    count++;
                    System.out.println(str.substring(i, j + 1));
                }
            }
        }
        return count;
    }

    public static int countChar(int[] ar) {
        int cnt = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] != 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
