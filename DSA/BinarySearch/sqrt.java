package BinarySearch;

public class sqrt {
    public static void main(String[] args) {
        System.out.println(sqrtN(12));
    }
    //floor integer of square root
    //maximum integer value of square root
    public static long sqrtN(long N) {
		long low = 1;
        long high = N;
        long ans = 1;

        while (low <= high) {
            long mid = (low + high) / 2;
            if (mid * mid <= N) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
	}
}
