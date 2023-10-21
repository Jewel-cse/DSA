public class thirdMax {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3};
        System.out.println(_thirdMax(nums));
    }
    public static int _thirdMax(int[] nums) {
        int n = nums.length;

        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        

        for (int i = 0; i < n; i++) {
            if (nums[i] > largest) {
                third = second;
                second = largest;
                largest = nums[i];
                //System.out.println(largest+" "+second);
            }
            else if (nums[i] < largest && nums[i] > second) {
                third = second;
                second = nums[i];
            }
            else if (nums[i] < second && nums[i] > third) {
                third = nums[i];
            }
            
        }
        
        return third == Integer.MIN_VALUE ? largest : third;
    }
}
