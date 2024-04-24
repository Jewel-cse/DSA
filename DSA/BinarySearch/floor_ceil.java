package BinarySearch;

/*
 * Floor(value): The floor of x is the @@@@ largest element in the array 
 * which is smaller than or equal to x( i.e. @@@largest element in the array <= x).
 * 
 * Ceil(value): The ceiling of x is the @@@smallest element in the array 
 * greater than or equal to x( i.e. @@@smallest element in the array >= x).
 * 
 */

public class floor_ceil {
    
    //floor.......
    private static int floor(int[]arr,int target){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int floor = -1;
        while (low<=high) {
            int mid = low + (high-low)/2 ;
            if(arr[mid]<=target){
                floor = arr[mid];
                low = mid+1;
               
            }    
            else     high = mid-1;
        }
        return floor;
    }

    //ceil.......
    private static int ceil(int[]arr,int target){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int ceil = -1;
        while (low<=high) {
            int mid = low + (high-low)/2 ;
            if(arr[mid] >= target){
                ceil = arr[mid];
                high = mid-1;

            }    
            else     low = mid+1;
        }
        return ceil;
    }

    public static void main(String[] args) {
        System.out.println(floor(new int[]{1,2,3,4,5,6}, 3));
        System.out.println(ceil(new int[]{1,2,3,4,5,6}, 3));
    }
}
