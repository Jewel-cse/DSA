package SRBD;

import java.util.Arrays;
public class testCrow {
        public static int minStonesForWorstCase(int[] overflow, int n, int k) {
            if (k <= 0 || k > n) {
                return -1; // Invalid input for k
            }
    
            Arrays.sort(overflow); // Sort the overflow array in ascending order
    
            int result = 0;
            for (int i = n - 1; i >= n - k; i--) {
                int min = overflow[i];
                for (int j = 0; j < n; j++) {
                    overflow[j] -= min;
                    result += min;
                }
            }
    
            return result;
        }
    
        public static void main(String[] args) {
            int[] overflow = {5, 58};
            int n = 2;
            int k = 1;
    
            int stonesRequired = minStonesForWorstCase(overflow, n, k);
    
            if (stonesRequired != -1) {
                System.out.println("Minimum stones required for worst case: " + stonesRequired);
            } else {
                System.out.println("Invalid input for k.");
            }
        }
    }
    


