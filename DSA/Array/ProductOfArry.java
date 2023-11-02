import java.util.Arrays;

public class ProductOfArry {
    //brute force approach1: division
    public static int[] productExceptSelf_naive(int[] nums) {
        long prod = 1;
        for (int i = 0; i < nums.length; i++) {
            prod = prod * nums[i];

        }
        int[] out = new int[nums.length];
        for (int i = 0; i < out.length; i++) {
            if(nums[i]!=0)
                out[i] = (int) prod / nums[i];
            else   
                out[i] = (int) prod;
        }

        return out;
    }
    
    //Aproach 2: leftproduct and right product
    public static int[] productExceptSelf_better(int[] nums) { // 1 2 3 4 5
        int n = nums.length;

        //prefix product 
        int[] left = new int[n]; //    1 1 2  6 24            
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        System.out.println(Arrays.toString(left));

        //suffix product 
        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        System.out.println(Arrays.toString(right));

        //output product
        int[] out = new int[n];
        for (int i = 0; i < out.length; i++) {
            out[i] = left[i] * right[i];
        }
        return out;
    }
    //most optimal solution
    public static int[] productExceptSelf_optimal(int[] nums) {     // 1  2  3  4
        int n = nums.length;
        int[] out = new int[n];
        //prfix prod 
        out[0] = 1;
        for (int i = 1; i < n; i++) { //left     1  1  2  6
            out[i] = out[i - 1] * nums[i - 1];
        }
        
        //right theke multiply korte korte .....
        int r = 1;
        for (int i = n-1; i >= 0; i--) {
            out[i] = out[i] * r;
            r = r * nums[i];              //         24   12  8   6
        }
        System.out.println(Arrays.toString(out));
        
        return out;
    }


    //driver code
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf_optimal(nums)));
        //System.out.println(Arrays.toString(productExceptSelf_better(nums)));
    }
}