package BinarySearch;

import java.util.Arrays;

public class peekIn2D {
    public static void main(String[] args) {
        int[][] mat = { {10,20,15},{21,30,14},{7,16,32} };

        System.out.println(Arrays.toString(findPeakGrid_Naive(mat)));
        System.out.println(Arrays.toString(findPeakGrid(mat)));
    }
    //Brouteforce approach : TC > M*N
    public static int[] findPeakGrid_Naive(int[][] mat) {

        int row = mat.length;
        int col = mat[0].length;
        //column check
        for (int i = 0; i < row; i++) { //row
            for (int j = 0; j < col; j++) { //col

                if ((i == 0 || mat[i][j] > mat[i - 1][j]) && (j == 0 || mat[i][j] > mat[i][j - 1]) &&
                        (i == row - 1 || mat[i][j] > mat[i + 1][j]) && (j == col - 1 || mat[i][j] > mat[i][j + 1])) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }
    //Aproach two:       #################### Binary search ################ (mlogn)
    //find the row which contains maximum value in mid column tahole oi column check kora lagbe na
    public static int findrow(int[][] mat, int mid) {
        int maxvalue = Integer.MIN_VALUE;
        int index = 1;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][mid] > maxvalue) {
                maxvalue = mat[i][mid];
                index = i;
            }
        }
        return index;
    }
    public static int[] findPeakGrid(int[][] mat) {
        int low = 0;
        int high = mat[0].length;

        while (low <= high) {
            int mid = (low + high) / 2;   //mid is a column

            int row = findrow(mat, mid);    //after finding mid we have to find the row which contains max in this mid column
            int left = mid - 1 >= 0 ? mat[row][mid - 1] : -1;     //ekta column er max newa means top bottom theke boro
            int right = mid + 1 < mat[0].length ? mat[row][mid + 1] : -1; //so we just check left and right

            if (mat[row][mid] > left && mat[row][mid] > right) {
                return new int[] { row, mid };
            }
            else if(mat[row][mid]<left)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return new int[] { -1, -1 };
    }

}
