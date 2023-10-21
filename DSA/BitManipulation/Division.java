package BitManipulation;

public class Division {
    
    //this method provide the integer value of quetiont
    public static int divide(int dividend, int divisor) {
        long a = dividend;
        long b = divisor;
        //if divisor =1 then return dividend
        if (divisor == 1) {
            return dividend;
        }
        //store the sign of both
        boolean dividendIsNegetive = false, divisorIsNegetive = false;
        if (dividend < 0) {
            a *= -1;
            dividendIsNegetive = true;
        }
        if (divisor < 0) {
            b *= -1;
            divisorIsNegetive = true;
        }
        //find qutiont
        long q = 0;
        for (int i = 30; i >= 0 ; i--) {
            if ((b << i) <= a) {
                a -= (b << i);          //a = a- b*2^i
                q |= (1 << i);          //q er ith bit set
            }
        }
        if ((divisorIsNegetive && dividendIsNegetive) || (!dividendIsNegetive && !divisorIsNegetive)) {
            return (int)q;
        }
        return  -1 *(int) q;
    }
    

    
    public static void main(String[] args) {
        System.out.println(divide(50, 3));
    }
}


