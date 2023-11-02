package LinkedList;
import java.util.Arrays;

public class mergeTwosortlist {
    public static void main(String[] args) {
        int[] ar1 = { 1, 4, 6, 8, 9 };
        int[] ar2 = { 2, 3, 4, 5 };

        sortArray(ar1, ar2);
        for (int i : ar1) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : ar2) {
            System.out.print(i + " ");
        }

    }

    public static void sortArray(int[] ar1, int[] ar2) {
        int n = ar1.length;
        int m = ar2.length;

        int left = n - 1;
    
        for (int right = 0; right < m; right++) {
            if (ar1[left] > ar2[right]) {
                int temp = ar1[left];
                ar1[left] = ar2[right];
                ar2[right] = temp;

                left--;

            } else {
                break;
            }
        }
        Arrays.sort(ar1);
        Arrays.sort(ar2);
    }
}
