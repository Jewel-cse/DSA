public class count_sorted_rows {
    public static void main(String[] args) {
        int row = 4,col = 3;
        int[][] mat = {{1,2,3},{2,2,1},{23,22,21},{2,2,2}};
        
        System.out.println(sortCounnt(row,col,mat));
    }
    static int sortCounnt(int N,int M,int[][]mat){
        int count = 0;
        int temp;
        for (int row = 0; row < N; row++) {
            int asc = 1,desc = 1;
            temp = mat[row][0];
            for (int col = 1; col < M ; col++) {
                
                if (temp<=mat[row][col]) {
                    asc += 1;
                    
                }
                if (temp>=mat[row][col]) {
                    desc += 1;
                }
                temp = mat[row][col];
            }
            if(asc == M || desc == M){
                count += 1;
            }
        }
        
        return count;
    }
    
}
