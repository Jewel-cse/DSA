public class change_evenbit {
    public static void main(String[] args) {
        System.out.println(convertEvenBitToZero(10));
    }
    static long convertEvenBitToZero(long n) {
        // code here
        long x = 715827882;  // 32 bit number tai even position 0 baki gula 1 kora hoyese
        return n & x;
    }
}
