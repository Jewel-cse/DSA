import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] arr = { 3, 5, 0, 0, 4 };
        bubblesort(arr);
       System.out.println(Arrays.toString(arr));
    }

    static void bubblesort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n -i ; j++) {
                if (arr[j] < arr[j - 1]) {
                    int tem = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tem;
                }
            }
        }
    }
}
