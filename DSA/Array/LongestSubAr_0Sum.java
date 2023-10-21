import java.util.HashMap;

public class LongestSubAr_0Sum {
    public static void main(String[] args) {
        //System.out.println(getLongestZeroSumSubarrayLength(new int[] { 1, 0, -1, 1 }));
        System.out.println(getLongestZeroSumSubarrLength(new int[] { 1, 0, -1, 1 }));
    }
    
    // two loop : O(n^2) c
    //single loop using prefix sum.........
    public static int getLongestZeroSumSubarrayLength(int[] arr) {
        int len = arr.length;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += arr[j];
                if (sum == 0) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
    
    //optimal : prefix sum....
    public static int getLongestZeroSumSubarrLength(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>(); //prefixSum, index

        int sum = 0;
        int maxlen = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                maxlen = i + 1;
            } else {
                if (map.get(sum) != null) { // if sum exists in map
                    maxlen = Math.max(maxlen, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }
        return maxlen;
    }
    
}
