/*
 * basic introduction of array and arraylist
 * implelment swap , max  and revers method using swap
 * 
 * 
 */

import java.util.Arrays;

class arr_list{
    public static void main(String args[]){
        int[] arr= {2,4,3,5,7};
        //swap(arr, 0, 3);

        System.out.println(Arrays.toString(arr));
        
        System.out.println(max(arr));  // max..

        reverse(arr);          // reverse the list
        System.out.println(Arrays.toString(arr));


    }

    //swap element
    static void swap(int[] arr, int index1,int index2){
        int temp;
        temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    // max
    static int max(int[] arr){
        int max_num = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max_num){
                max_num = arr[i];
            }
        }
        return max_num;
    }

    // reverse using swap
    static void reverse(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while (start<end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}