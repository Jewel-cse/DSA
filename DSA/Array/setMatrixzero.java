import java.util.Arrays;

public class setMatrixzero {
    
    //Approach 1: With extra memory 
    //TC: O(n*m + n*n*(n+n))  SP:O(n*m)
    static void setZero(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        
        int[][] v = new int[row][col];
        
        //find zeros and mark into tem matrix to 1
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0 && v[i][j] != 1) {
                    v[i][j] = 1;

                }
            }
        }
        // set zeros   TC : n*n*(n+n)
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (v[i][j] == 1) {       /// if temp[i][j] ..set 0 of this column and row
                    int x = 0, y = 0;
                    // set zero row
                    while (x < col) {
                        mat[i][x] = 0;
                        x++;
                    }
                    //set 0 to col
                    while (y < row) {
                        mat[y][j] = 0;
                        y++;
                    }

                }
            }
        }

    }
    
    //Approach 2: optimal(with extra 1 row array and 1 col array)
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] row = new int[n];
        int[] col = new int[m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((row[i] == 1) || (col[j] == 1)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    
    //Best solution
    //use the first row and col for marking 
    //TC : O(n*m + n*m + n+m)   SP: O(1)
    public static void setMatrixzeros(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        
        boolean firstrowMark = false;
        boolean firstColMark = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                firstrowMark = mat[0][j] == 0 ? true : false;
                firstColMark = mat[i][0] == 0 ? true : false;
                if (mat[i][j] == 0) {
                    mat[0][j] = 0; //mark col
                    mat[i][0] = 0; //mark row
                }
            }
        }
        // (1,1) to (row,col)
        //set zeros each column 
        for (int i = 1; i < col; i++) {
            if (mat[0][i] == 0) {
                for (int j = 1; j < row; j++) {
                    mat[j][i] = 0;
                }
            }
        }
        //sert zeros each row
        for (int i = 0; i < row; i++) {
            
            if (mat[i][0] == 0) {
                for (int j = 0; j < col; j++) {
                    mat[i][j] = 0;
                }
            }
        }
        //set zeros at first col and first row
        if (firstColMark) {
            for (int i = 0; i < col; i++) {
                mat[0][i] = 0;
            }
        }
        if (firstrowMark) {
            for (int i = 0; i < row; i++) {
                mat[i][0] = 0;
            }
        }
        

        //print the output

        for (int[] is : mat) {
            System.out.println(Arrays.toString(is));
        }
    }
    
    ///////////////////@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@////////////////////////////
    public static void main(String[] args) {
        int[][] mat = {{0,3,0}};
        /* for (int[] is : mat) {
            System.out.println(Arrays.toString(is));
        } */
        //setZero(mat);
        setMatrixzeros(mat);

    }
}
