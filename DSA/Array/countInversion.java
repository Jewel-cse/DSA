import java.util.ArrayList;

public class countInversion {
    //static int count = 0;             ////////////// global variable  use discourage ...
    public static void main(String[] args) {
        int[] ar = { 1, 20, 6, 4, 5 };

        System.out.println(counTInversion(ar));
    }
    //inversion count........##############
    public static int counTInversion(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }


    /* Use concept of merge sort: left index < right index when we divide
     *                          :  we ar[left] > ar[right]  then count
     *                          : just 2 line change
     */                        
    public static int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if(low>=high)
            return count;
        int mid = (low + high) / 2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);

        return count;
    }
    
    public static int merge(int[] arr, int low, int mid, int high) {
        int count = 0;
        int left = low;
        int right = mid+1;
        ArrayList<Integer> ls = new ArrayList<>();
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                ls.add(arr[left]);
                left++;
            } 
            else {// left is greater
                count += mid-left+1;             ///******** */right side of left all are greater.
                ls.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            ls.add(arr[left]);
            left++;
        }
        while (right <= high) {
            ls.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = ls.get(i - low);
        }
        return count;
    }
}
