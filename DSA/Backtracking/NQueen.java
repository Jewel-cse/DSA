package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Nqueen1: PRINT THE POSSIBLE SOLUTION
 * Nqueen2: HOW MANY DISTINCT SOLUTION
*/
public class NQueen {
    /*
     * solveNqn(n)
     * bfs(firstCol,board,res)
     * validate(board,row,col)
     * construct(board)
     */
    private static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        // create board
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '_';
            }
        }
        dfs(0, board, res);
        return res;
    }

    private static void dfs(int col, char[][] board, List<List<String>> res) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (validate(board,row,col)) {
                board[row][col] = 'Q';
                dfs(col + 1, board, res);
                board[row][col] = '_';     //its over now backtracking @@@@
            }
        }
    }
    //construct the output string list from char[][] array
    private static List<String> construct(char[][] board) {
        List<String> ansOne = new ArrayList<String>();
        for (int i = 0; i < board.length; i++) {
            ansOne.add(Arrays.toString(board[i]));
        }
        return ansOne;
    }

    private static boolean validate(char[][] board, int row, int col) {
        int dupRow = row;
        int dupCol = col;
        //upper left diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }
        row = dupRow;
        col = dupCol;
        //left 
        while (col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            col--;
        }
        
        row = dupRow;
        col = dupCol;
        //left bottom diagonal
        while (row<board.length && col>=0) {
            if(board[row][col] == 'Q')
                return false;
            row++;
            col--;
        }
        return true;
    }
    // main function
    public static void main(String[] args) {
        List<List<String>> ans = solveNQueens(4);
        int i = 1;
        for (List<String> list : ans) {
            System.out.println("Solution no. : "+i++);
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}
