package NumberThrory;

public class factorial {
    static int counter= 0;
    private static final int mx = 500;
    //iterative way : o(n)
    private static int factorialIterative(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++)
            res *= i;
        return res;
    }
    
    //using recursion : o(n)
    private static int factorialRecursive(int n) {
        if (n < 2)
            return 1;
        return n * factorialRecursive(n - 1);
    }
    
    //@@@@@@@@@@@@   how to handle large number  @@@@@@@@@@@@@@@@@@@
    private static int muliplyAndGetSize(int x, int[] res, int size) {
        int carry = 0;
        for (int i = 0; i < size; i++) {
            int prod = x * res[i] + carry;
            res[i] = prod % 10;
            carry = prod / 10;
            counter++;
        }
        while (carry > 0) {
            res[size] = carry % 10;
            carry = carry / 10;
            size++;
        }

        return size;
    }
    
    private static void factorialOflargeNumber(int n) {
        int[] res = new int[mx];
        res[0] = 1;
        int size = 1;
        //mulitply each i with array and get size
        for (int i = 2; i <= n; i++) {
            size = muliplyAndGetSize(i, res, size);
        }

        //print array with reverse manner
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(res[i]);
        }
    }
    //@@@@@@@@@   Using BigInteger we can easily handle large number  @@@@@@@@@

    public static void main(String[] args) {
        int n = 23;
        //System.out.println(factorialIterative(12));
        //System.out.println(factorialRecursive(12));
        factorialOflargeNumber(n);
        System.out.println();
        System.out.println("counter : "+counter);
        double x = Math.pow(n, 1.49);
        double y = n*Math.log10(n);

        System.out.println(x + " --- "+y);
    }
}
