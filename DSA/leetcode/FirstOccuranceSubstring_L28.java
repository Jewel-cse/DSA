public class FirstOccuranceSubstring_L28 {
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
    }

    public static int strStr(String haystack, String needle) {
        int hlen = haystack.length();
        int nlen = needle.length();
        int hp = 0;
        int np = 0;
        int nIndex = 0;
        while (hp < hlen && np < nlen) {
            if (haystack.charAt(hp) == needle.charAt(np)) {
                hp++;
                np++;
            } else {
                np = 0;
                hp = nIndex + 1;
                nIndex = hp;
            }
        }
        return np == nlen ? nIndex : -1;
    }
}
