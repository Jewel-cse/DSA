public class maxXor {

    //TC: o(n^2), time limit exceeded..................
    public static int findMaximumXOR(int[] nums) {

        int max = 0;
        //int m = 0, n = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int x = nums[i] ^ nums[j];
                if (x > max) {
                    //m = nums[i];
                    //n = nums[j];
                    max = x;
                }
            }
        }
        //System.out.println(m+" "+n);
        return max;
    }
    public static void main(String[] args) {
        int[] num = { 14,70,53,83,49,91,36,80,92,51,66,70 };
        System.out.println(findMaximumXOR(num));
    }
}
