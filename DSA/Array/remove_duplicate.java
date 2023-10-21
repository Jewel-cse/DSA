import java.util.Arrays;

public class remove_duplicate {
    public static void main(String[] args) {
        int[] A = { 1, 2, 2, 2, 2, 0, 0, 0, 3, 4, 4, 4 };
        /*
         
        int N = A.length;
        int n = remove_dupli(A, N);

        for (int i = 0; i < n; i++) {
            System.out.print(A[i] + " ");
        }
         */
        //2nd problem
        System.out.println(removeDuplicates(A));

    }
    /// remove duplicate I
    static int remove_dupli(int A[], int N) {
        // code here
        Arrays.sort(A);
        int[] arr = new int[N];
        int index = 0, duplicate = 0;
        for (int i = 0; i < N - 1; i++) {
            if (A[i] != A[i + 1]) {
                arr[index++] = A[i];
            } else {
                duplicate++;
            }
        }
        arr[index] = A[N - 1];

        for (int i = 0; i < arr.length; i++) {
            A[i] = arr[i];
        }
        return (N - duplicate);
    }
    
    ///remove duplicate II (at most twice)
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 3)
            return nums.length;
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            nums[j++] = nums[i++];
            if (i < nums.length && nums[i] == nums[j - 1])
                nums[j++] = nums[i++];
            while (i < nums.length && nums[i] == nums[j - 1])
                i++;
        }
        return j;
    }
    
}
