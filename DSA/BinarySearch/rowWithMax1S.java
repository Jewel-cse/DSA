package BinarySearch;

public class rowWithMax1S {

    public static void main(String[] args) {
        int[][] mat = { { 0, 0, 0, 1, 1, 1 }, { 0, 0, 0, 1, 1, 1 }, { 0, 0, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 } };
        System.out.println(maximumOnesRow(mat, mat.length, mat[0].length));

    }

    //using upper bound find the first occourance of() 1 -1) place
    public static int maximumOnesRow(int[][] mat, int n, int m) { //n row, m col
        int Maxcount = -1;
        for (int i = 0; i < n; i++) {
            int count = m - upperbound(mat[i], 1);
            if (count > Maxcount) {
                Maxcount = count;
            }
        }
        return Maxcount;
    }
    public static int upperbound(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int firstOccrance = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                firstOccrance = mid;
                high = mid - 1; //find <--next lessOrequal target
            } else {
                low = mid + 1;

            }
        }
        return firstOccrance;
    }
}
