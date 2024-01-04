import java.util.Arrays;

public class FenwickTree {
    //update: log n
    //query : log n
    //rang sum: log n

    //need new array: BIT[n+1];
    //given an array , and range find the sum
    //update range range

    private static int BIT[];

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        constructBIT(arr);
        System.out.println(Arrays.toString(BIT));
        System.out.println(rageSum(2, 4));
    }

    //@@@@@@@@@@@ the other function @@@@@@@@@@@@@@
    private static void constructBIT(int[] arr) {
        int n = arr.length;
        BIT = new int[n + 1]; //initialize with 0
        
        for (int i = 0; i < n; i++) {
            update(n, i, arr[i]);
        }

    }

    private static void update(int n, int ind, int value) {
        ind++;
        while (ind <= n) {
            BIT[ind] += value;
            ind += ind & (-ind); // go right : 2's -> and -> add
        }
    }

    private static int prefixSum(int ind) {
        ind++;
        int sum = 0;
        while (ind > 0) {
            sum += BIT[ind];
            ind -= ind & (-ind);
        }

        return sum;
    }
    
    private static int rageSum(int l, int r) {
        return prefixSum(r) - prefixSum(l - 1);
        // l = 0 holeo prefixSum funciton e ++ kore calculate kore
    }
}
