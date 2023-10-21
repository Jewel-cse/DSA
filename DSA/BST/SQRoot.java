package BST;

public class SQRoot {
    public static void main(String[] args) {
        System.out.printf("%.3f",sqRoot(4,5));
    }

    public static double sqRoot(int n, int p) { //square root with precision
        
        // perfect root
        double root = 0;
        int s = 0;
        int e = n;
        while (e <= s) {
            int m = s + (e - s) / 2;
            if (m * m == n) {
                return m;
            }
            if (m * m > n) {
                e = m - 1;
            } else
                s = m + 1;
        }
        
        //for precision
        double inc = .1;
        for (int i = 0; i < p; i++) {
            
            while (root * root < n) {
                root += inc;
            }
            root -= inc;
            inc /= 10;
        }


        return root;
    }
    
}
