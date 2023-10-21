package BitManipulation;

public class countNumberOfSetBits {
    public static void main(String[] args) {
        System.out.println(countSetBits(5));
    }
    
    
    //Count number of set bits in given range (1 to N)
    public static int countSetBits(int n) {
        int d = 2;
        int x = n;
        int count = 0;
        while (x > 0) {
            count += ((n + 1) / d * (d / 2)) + Math.max(((n + 1) % d - (d / 2)), 0);
            d = d * 2;
            x = x / 2;
        }
        return count;
    }
}
