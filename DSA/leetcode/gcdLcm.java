public class gcdLcm {
    public static void main(String[] args) {
        int a = 52;
        int b = 123;
        System.out.println(gcd(a, b));
        System.out.println(lcm(a, b));
    }

    // GCD calculation : Euclid method
    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    
    //lcm = a*b/gcd(a,b)
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    
}
