package BinarySearch;

public class findNthRoot {



    public static void main(String[] args) {
        System.out.println(NthRoot(2, 16));
    }
    


    //when mid = 10^9 and n = 10
    //its cz overflow so this method does not use in nthroot.
    public static int power(int mid, int n) { //mid*mid*....n times
        int ans = 1;
        while (n > 0) {
            if (mid % n == 1) {
                ans = ans * mid;
                n = n - 1;
            } else {
                mid = mid * mid;
                n = n / 2;
            }
        }
        return ans;
    }
    
    //when its over to m then stop,means that mid is not posible ,eleminate the right half
    //return 1 : if m   : ureka
    //return 2 : if >m  :over,high = mid-1
    //return 0: if<m    :low = mid+1
    public static int pow(int mid, int n, int m) {
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            if (ans > m)
                return 2;
        }
        if (ans == m)
            return 1;
        return 0;
    }

    //nth root main logic
    public static int NthRoot(int n, int m) {
        int low = 1;
        int high = m;
        while (low <= high) {
            int mid = (low + high) / 2;

            int midN = pow(mid, n, m);
            if (midN == 1) {
                return mid;
            } else if (midN == 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
