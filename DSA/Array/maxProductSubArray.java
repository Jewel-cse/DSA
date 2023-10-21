public class maxProductSubArray {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[] { 3, -1, 4 }));
    }
    //3 Loop : n^3,(i->n)(j=i ->n)(k=i->j)
    // 2 loop : n^2
    // from observation  : o(n) ***
    public static int maxProduct(int[] nums) {
        int pre = 1;
        int suff = 1;

        int maxp = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (pre == 0)        //restart prefix -> / <- suffix   // handle 0
                pre = 1;
            if (suff == 0)
                suff = 1;

            pre *= nums[i];            // ---> 
            suff *= nums[n-i-1];       // <---
            maxp = Math.max(maxp, Math.max(pre, suff));
        }
        return maxp;
    }
}
