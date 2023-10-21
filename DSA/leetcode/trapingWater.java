public class trapingWater {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(arr));
    }
    
    public static int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int maxleft = 0;
        int maxright = 0;
        int res = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxleft)
                    maxleft = height[left];
                else {
                    res += maxleft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxright)
                    maxright = height[right];
                else
                    res += maxright - height[right];
                right--;
            }
        }
        return res;
    }
}
