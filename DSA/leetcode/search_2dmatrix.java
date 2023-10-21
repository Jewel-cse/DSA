public class search_2dmatrix {
    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(searchMatrix(mat,0));
    }
    public static  boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][cols - 1] > target) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j]== target) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
