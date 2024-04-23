public class maximumProductSubArray {
    public static int subarrayWithMaxProduct(int []arr){
        // Write your code here.

        int n = arr.length;
        int pre = 1;
        int suf = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            if(pre == 0)    pre = 1;
            if(suf == 0)    suf = 1;

            pre *= arr[i];
            suf *=arr[n-i-1];

            max = Math.max(max, Math.max(pre,suf));
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(subarrayWithMaxProduct({1,2,-3,4,5}));
    }
}
