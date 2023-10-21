public class ContainerWithMostWaterl {
    public static void main(String[] args) {
        int[] h = { 1,1 };
        System.out.println(maxArea(h));
    }
    
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxwater = Integer.MIN_VALUE;
        int temp = 0;
        while (left < right) {
            temp = (right - left) * Math.min(height[left], height[right]);
            if (temp > maxwater) {
                maxwater = temp;
            }
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxwater;
    }
}
