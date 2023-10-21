package BinarySearch;

public class kthMissingPositiveInt {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 4, 7, 11 };
        System.out.println(findKthPositive(nums, 9));
    }
    //tc: o(n)
    public static int find_KthPositive(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k)
                k++;
            else
                break;
        }
        return k;
    }

    //using binary search :log(n)
    public static int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return low + k;
    }
}
