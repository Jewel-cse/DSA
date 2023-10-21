import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class slidingWindow {
    public static void main(String[] args) {
        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        System.out.println(Arrays.toString(maxSlidingWindow(arr, 3)));

    }
    
    /*
     
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] maxarr = new int[n - k + 1];
    
        for (int i = 0; i < maxarr.length; i++) {
            int temp = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                if (nums[i + j] > temp) {
                    temp = nums[i + j];
                }
            }
            maxarr[i] = temp;
        }
        return maxarr;
    }
     */
    
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] r = new int[n - k + 1];
        int r_index = 0;

        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            //remove index out of range k
            if (!q.isEmpty() && q.peek() == i - k)
                q.poll();  //first element remove

            //peek choto thkle poll korte hobe
            while (!q.isEmpty() && nums[q.peek()] < nums[i]) {
                q.pollLast(); //last insert value remove hobe
            }
            q.offer(i);
            if (i >= k - 1)
                r[r_index++] = nums[q.peek()];
        }
        return r;
    }
}
