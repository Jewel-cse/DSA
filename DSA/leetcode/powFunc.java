public class powFunc {
    public static void main(String[] args) {
        System.out.println(myPow(-4, 3));
    }

    // idea: 5^10
    //       = (5x5)^5
    //       x = 25,    ans = 5x5 = 25,n = 5-1 = 4
    //       x = 25*25,n= 2,
    //       x = 625*625, n = 1
    //                 ans = 25* 625 * 625, n =0
    //
    public static double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n;
        if (nn < 0)
            nn = (-1) * nn;
        while (nn > 0) {
            if (nn % 2 == 1) {
                ans = ans * x;
                nn = nn - 1;
            } else {
                x = x * x;
                nn = nn / 2;
            }
        }
        if(n<0) return (double)(1.0)/(double)ans ;
        return ans;
    }
}
