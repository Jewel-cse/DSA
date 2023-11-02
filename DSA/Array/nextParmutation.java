
public class nextParmutation {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 5 };
        next_Permut(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    
    //find break point, swap, reverse...........
    public static  void next_Permut(int[] A) {
            int N = A.length;
            int i;
            int j;
            int ind = -1;
    
            for (i = N - 2; i >= 0; i--) {
                if (A[i] < A[i + 1]) {
                    ind = i;
                    break;
                }
            }
            if (ind == -1) {
                reverse(A, i + 1, N - 1);
            }
            for (j = N - 1; j > ind; j--) {
                if (A[ind] < A[j]) {
                    swap(A, ind, j);
                    break;
                }
            }
            reverse(A, i + 1, N - 1);
        }
    
        static void reverse(int[] A, int start, int end) {
            while (start < end) {
                swap(A, start++, end--);
            }
        }
    
        static  void swap(int[] A, int i, int j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
    }
        
}
