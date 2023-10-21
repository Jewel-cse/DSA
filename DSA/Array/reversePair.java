import java.util.ArrayList;


public class reversePair {
    //static int count = 0;
    public static void main(String[] args) {
        int[] nums = { 2147483647,2147483647,2147483647,2147483647,2147483647,2147483647 };

        //System.out.println(Arrays.toString(nums));
        System.out.println(reversePairs(nums));
    }
    //************************** */
    public static int reversePairs(int[] nums) {

        return mergeSort(nums, 0, nums.length - 1);
    }

    
    public static int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if (low >= high)
            return count;
        int mid = (low + high) / 2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += pair(arr, low, mid, high);
        merge(arr, low, mid, high);

        return count;
    }

    public static int pair(int[] arr,int low,int mid,int high) {
        int count = 0;
        int right = mid+1;
        for (int i = low; i <= mid; i++) {
            
            while (right <= high && (long)arr[i] > 2L * arr[right]) {
                    right++;
            }
            count += (right - (mid + 1));
            
        }
        return count;
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        ArrayList<Integer> ls = new ArrayList<>();
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                ls.add(arr[left]);
                left++;
            } else {
                ls.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            ls.add(arr[left]);
            left++;
        }
        while (right <= high) {
            ls.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = ls.get(i - low);
        }
    }
    
}
