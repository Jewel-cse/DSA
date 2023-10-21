package Strivers;

public class setMatrixzero {
    public static void main(String[] args) {
        int[][] mat = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        
        setZero(mat);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j]+ " ");
            }
            System.out.println();
        }

    }
    static void setZero(int[][]mat){
        int row = mat.length;
        int col = mat[0].length;

        int[][] v = new int[row][col];

        //find zeros
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(mat[i][j] == 0 && v[i][j] != 1){
                    v[i][j] = 1;
                    
                }
            }
        }
        // set zeros
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(v[i][j] == 1){
                    int x =0 ,y = 0;
                    while(x<col){
                        mat[i][x] = 0;
                        x++;
                    }
                    while(y<row){
                        mat[y][j] = 0;
                        y++;
                    }
                    
                }
            }
        }


    }
}
