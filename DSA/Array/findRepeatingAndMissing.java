import java.util.Arrays;

public class findRepeatingAndMissing {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMissingRepeatingNumbers(new int[]{1,2,3,2})));
    }
    public static int[] findMissingRepeatingNumbers(int []a) {
        Arrays.sort(a);                                //nlogn

        int missing = -1;
        int duplicate = -1;
        //find double
        int n = a.length;
        int sum = a[0];
        for (int i = 1; i < n; i++) {                //n
            sum += a[i];
            if (a[i] == a[i - 1]) {
                duplicate = a[i];
            }
        }
        
        sum -= duplicate;
        //find missing
        int totalSum = n * (n + 1) / 2;
        
        missing = totalSum - sum;

        return new int[] { duplicate,missing };
    }
}
