
public class CountInversionOfarray {
    public static void main(String[] args) {
        int[] arr = { 5,4,3,2,1};
        System.out.println(inversionOfArray(arr));

    }

    public static int inversionOfArray(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (i < j && arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
