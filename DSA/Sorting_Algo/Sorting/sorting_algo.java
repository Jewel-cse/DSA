package Sorting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sorting_algo {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 5, 6, 100,0,0,0 };
        System.out.println(Arrays.toString(arr));
        //selectionsort(arr);
        //bubbleSort(arr);
        //insertionSort(arr);
        //mergeSort(arr, 0, arr.length-1);
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    




    //   ###########Some important sorting algorithm ########


    //selection sort implementation : n^2
    public static void selectionsort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int mini = i;
            for (int j = i + 1; j < arr.length; j++) {
                //find minimum index
                if (arr[j] < arr[mini])
                    mini = j;
            }
            //swap
            int temp = arr[i];
            arr[i] = arr[mini];
            arr[mini] = temp;
        }
    }
    
    //bubble sort implement n^2

    /*if the array is already sorted , the complexity is 
        minimum or best case O(n);
        it is possible to use swap checking
     * 
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean didSwap = false;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;

                    didSwap = true;
                }
            }
            if (!didSwap) {
                System.out.println("No swap");
                break;
            }
        }
    }
    
    //insertion sort
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;

                j--;
            }
        }
    }

    // Merge sort: recursion approach: divide and conquer approach,
    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }
    
    public static void merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        List<Integer> list = new ArrayList<>();

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                list.add(arr[left]);
                left++;
            } else {
                list.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            list.add(arr[left]);
            left++;
        }
        while (right <= high) {
            list.add(arr[right]);
            right++;
        }

        //array te push korbo
        for (int i = low; i <= high; i++) {
            arr[i] = list.get(i - low);
        }
    }




    // Quick sort: 
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p_index = partitionIndex(arr, low, high);
            quickSort(arr, low, p_index-1 );
            quickSort(arr, p_index+1,high );           
        }
    }
    
    public static int partitionIndex(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            //calculate i and j pointer
            while (arr[i] <= pivot && i < high) {
                i++;
            }
            while (arr[j] > pivot && j > low) {
                j--;
            }
            //check i,j cross korse kina,na korle swap
            if (i < j) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        //arr[low] and arr[j] swap , j is pivot position
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }
}
