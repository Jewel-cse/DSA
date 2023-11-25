package SRBD;

public class equationSolve {
    //calculate log2 base function
    public static int log2(int x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Input must be a positive integer");
        }
        return (int) (Math.log(x) / Math.log(2));
    }
    //calculate is zero
    private static long isZero(long a, long b, long c, long x, int k) {
        return  (a*k+b*k*log2(k)+c*k*k*k - x);
    }
    //solve equation
    private static int solve(long a, long b, long c, long x) {
        int low = 1;
        int high  = Integer.MAX_VALUE;
        if(a<10 && b<10 && c>0)
            high = 1000;
        else if(a<100 && b <100 && c>0)
            high = 10000000;
        //now search for k value
        while (low<=high) {
            int k = low + (high - low) / 2;
            if(isZero(a,b,c,x,k) == 0)
                return k;
            else if(isZero(a, b, c, x, k)<0)
                low = k + 1;
            else
                high = k - 1;
        }
        return 0;
    }

    ////main function....................
    public static void main(String[] args) {
        //long a = 128, b = 123, c = 5, x = 10;
        long a = 1, b = 1, c = 1, x = 400;
        //long a = 12, b = 88, c = 7, x = 2344;
        System.out.println(solve(a, b, c, x));
    }
    //5*k+5*k*log2 k + 5*k*k*k = 10
}
