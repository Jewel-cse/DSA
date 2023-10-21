package BinarySearch;

public class search2Dmatrix {
    public static void main(String[] args) {
        int[][] mat = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 } };
        System.out.println(searchMatrix(mat, 20));
        System.out.println(BinarySearch2d(mat,20));
    }

    //     ################## Approach nlogm ############
    //take each row and apply binary search in that row
    //TC: row*log(col)
    public static boolean searchMatrix(int[][] matrix, int target) {

        boolean flag = false;
        
        for (int i = 0; i < matrix.length; i++) {
            flag = searchRow(matrix[i], target);
            if (flag) {
                return true;
            }
        }

        //System.out.println(" " + matrix[0][high]);
        return false;
    }

    public static boolean searchRow(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return true;
            else if (target > nums[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
    
    //the most optimal solution *********************************************************************************
    //look the matrix (0,m-1) and (n-1,0) theke search start kora jabe
    //time COmplexity : O(n+m) atmost...
    public static boolean  BinarySearch2d(int[][] nums,int target){
        int totalRow = nums.length;
        int totalCol = nums[0].length;
        int row = 0;
        int col = totalCol -1;

        while(row<totalRow && col >=0){
            if(nums[row][col] == target)
                return true;
            if(nums[row][col]<target)    //target er ceye choto row++ koro
                row++;
            else    
                col--;
        }
        return false;
    }
}
