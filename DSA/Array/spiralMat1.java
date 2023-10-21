import java.util.ArrayList;
import java.util.List;

public class spiralMat1 {
    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3 } };
        System.out.println(spiralOrder(mat).toString());

    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> lst = new ArrayList<>(0);

        int left = 0, top = 0;
        int right = matrix[0].length -1;
        int bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {
            //left to right
            for (int i = left; i <= right; i++) {
                lst.add(matrix[top][i]);
            }
            top++;
            //top to bottom
            for (int i = top; i <= bottom; i++) {
                lst.add(matrix[i][right]);
            }
            right--;
            //bottom right to bottom left

            if (top <= bottom) {

                for (int i = right; i >= left; i--) {
                    lst.add(matrix[bottom][i]);
                }
                bottom--;
            }
            //bottom to top
            if (left <= right) {

                for (int i = bottom; i >= top; i--) {
                    lst.add(matrix[i][left]);
                }
                left++;
            }
        }
        return lst;
    }
}
