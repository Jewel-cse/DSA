import java.util.Arrays;

public class find_median {
    public static void main(String[] args) {
        int[] arr = {90,100,78,89,67};
        System.out.println(median(arr));

    }
    static int median(int[] arr){
        Arrays.sort(arr);
        int len = arr.length;
        int mid = len/2;
        if(len%2==0){
            //even
            return ((arr[mid] + arr[mid-1])/2);
        }
        else{
            return arr[mid];
        }
    }
}
