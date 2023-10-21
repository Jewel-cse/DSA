
import java.util.Arrays;

import Strivers.LinkedList.ListNode;

public class spiralMat4 {
    public static void main(String[] args) {
        ListNode lst = new ListNode();
        for (int i = 0; i < 5; i++) {
            //lst.insert(i + 1, i);
            lst.insert(i, i);
        }
        lst.display(lst.head);
        int[][] matrix = spiralMatrix(3, 5, lst.head);
        
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        //System.out.println(spiralMatrix(3, 5, lst.head).toString());

    }

    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        // for given dimension all fil -1 cz input na thakle oikhane -1 bosate hobe 
        int[][] matrix = new int[m][n];
        for (int[] row : matrix) {
            Arrays.fill(row, -1);
        }

        int left = 0, top = 0;
        int right = n -1;
        int bottom = m - 1;

        ListNode temp = head;
        while (left <= right && top <= bottom && temp!= null) {
            //left to right
            for (int i = left; i <= right; i++) {
                if (temp != null) {
                    matrix[top][i] = temp.value;
                    temp = temp.next;                    
                }
            }
            top++;
            //top to bottom
            for (int i = top; i <= bottom; i++) {
                if (temp != null) {
                    matrix[i][right] = temp.value;
                    temp = temp.next;
                    
                }
            }
            right--;
            //bottom right to bottom left

            if (top <= bottom) {

                for (int i = right; i >= left; i--) {
                    if (temp != null) {
                        matrix[bottom][i] = temp.value;
                        temp = temp.next;
                        
                    }
                }
                bottom--;
            }
            //bottom to top
            if (left <= right) {

                for (int i = bottom; i >= top; i--) {
                    if (temp != null) {
                        
                        matrix[i][left] = temp.value;
                        temp = temp.next;
                    }
                }
                left++;
            }
        }
       return matrix;
    }
}
