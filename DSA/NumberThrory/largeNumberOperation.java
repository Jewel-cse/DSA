package NumberThrory;

import java.util.Arrays;

/*
 * This class is defined how to handle large number.....
 * Addition and multiplication
 * 
 */
public class largeNumberOperation {
    private static final int mx = 500;
    private static int[] res;


    // @@@@@@@@@@@@  adddition of large number
    private static int[] add(int[] arr1, int[] arr2) {
        reverse(arr2);
        reverse(arr1);
        res = new int[mx];
        int carry = 0;
        int sum = 0;
        int size = 0;
        //make sure that arr1 is less size
        if (arr2.length < arr1.length) {
            int[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        //calculate common length of array
        for (size = 0; size < arr1.length; size++) {
            sum = arr1[size] + arr2[size];
            res[size] = (carry + sum) % 10;
            carry = (carry + sum) / 10;
        }
        // non visited elemnt of big array
        for (; size < arr2.length; size++) {
            sum = arr2[size];
            res[size] = (carry + sum) % 10;
            carry = (carry + sum) / 10;
        }
        //handle carry 
        while (carry > 0 ) {
            res[size++] = carry % 10;
            carry = carry / 10;
        }

        //print sum with reverse side
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(res[i] + ", ");
        }

        return res;
    }
    
    //for@@@@@@@@@@@@  reverse an array.
    private static void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    

    public static void main(String[] args) {
        int[] x = new int[5];
        int[] y = new int[5];

        for (int i = 0; i < x.length; i++) {
            x[i] = 9;
            y[i] = 9;
        }
        /* y[10] = 7;
        y[11] = 5; */
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
        add(x, y);
        multiply(x, y);
    }
}
