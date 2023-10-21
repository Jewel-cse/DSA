package Stack_queue;

import java.util.Stack;

public class maximalRactangle {
    public static int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int maxArea = 0;
        int[][] heights = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                heights[i][j] = (int) (matrix[i][j] - '0');
                if (i > 0 && i < row && matrix[i][j] == '1')
                    heights[i][j] += heights[i - 1][j];
                //System.out.print(heights[i][j] +" ");
            }
            //System.out.println();
            int area = largestREctangleArea(heights[i]);
            maxArea = Math.max(maxArea, area);

        }
        return maxArea;
    }

    public static int largestREctangleArea(int[] heights) {
        int n = heights.length;
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];

        Stack<Integer> st = new Stack<>();

        //calculate leftsmaller array
        for (int i = 0; i < n; i++) {
            while (!st.empty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.empty())
                leftSmaller[i] = 0;
            else
                leftSmaller[i] = st.peek() + 1;
            st.push(i);
        }
        //stack clear 
        while (!st.empty())
            st.pop();
        //st.clear();
        //calculate rightsmaller array
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.empty())
                rightSmaller[i] = n - 1;
            else
                rightSmaller[i] = st.peek() - 1;
            st.push(i);
        }
        int maxA = 0;
        for (int i = 0; i < n; i++) {

            maxA = Math.max(maxA, (rightSmaller[i] - leftSmaller[i] + 1) * heights[i]);
        }

        return maxA;
    }

    public static void main(String[] args) {
        char[][] mat = { { '1', '0', '1', '0', '0' },
                         { '1', '0', '1', '1', '1' },
                         { '1', '1', '1', '1', '1' },
                         { '1', '0', '0', '1', '0' }
        };
        System.out.println(maximalRectangle(mat));
    }

}
