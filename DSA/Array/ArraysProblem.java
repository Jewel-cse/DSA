

import java.util.Arrays;

public class ArraysProblem {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 8, 5, 6, 7 };
        int[] nums = { 1, 4,4, 5 };
        //System.out.println(largestElement(arr));
        //System.out.println(secondLargest(arr));
        //System.out.println(removeDuplicates(arr));
        //int[] nums = leftrotatebyOne(arr);
        
        /* 
        int[] nums = leftRotateBy_D_Place(arr, 9);
        for (int i : nums) {
            System.out.print(i + " ");
        }
        
        
        //reverse(arr, 0, arr.length - 1);
        
        leftRotateBy_D_Place_optimal(arr, 9);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        */
        moveZeroes(nums);
        for (int i : nums) {
            System.out.print(i+" ");
        }
    }

    //              ---------problems functions  ------------

    


    // find largest element of the array
    //sort korle: O(nlogn), traverse korle : O(n)
    public static int largestElement(int[] arr) {
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }
    
    
    // find 2nd largest number of the array
    //sorting : (nlogn + n )last index e largest thkbe, last er theke samne asbe jotokhon less nahoi...
    //traverse : o(n)
    public static int secondLargest(int[] arr) {
        int largest = arr[0];
        int secondLarge = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLarge = largest;
                largest = arr[i];
            } else if (arr[i] > secondLarge && arr[i] < largest) {
                secondLarge = arr[i];
            }
        }
        return secondLarge;
    }
    // remove duplicate in place in a sorted array_ distict value gula suru te thkbe
    // Brute force:  insert set , then number of element in the set. (Nlogn + n)
    //optimal : two-pointer approach
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    // left rotate by one place   
    public static int[] leftrotatebyOne(int[] nums) {
        int temp = nums[0]; //first value store korbo temp e
        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i]; // index one theke left shift hobe
        }
        nums[nums.length - 1] = temp; // last index e first value store korbo
        return nums;
    }
    
    //left rotate by d-place 
    //idea: 1st d index porjonto temp arra te save korbe.
    //d-place left shift korbo, last er index gulai temp er element gula add korbo

    public static int[] leftRotateBy_D_Place(int[] nums, int d) {
        d = d % nums.length; //rotation always ( 1-length ) porjonto hoi
        int[] temp = new int[d];

        //store temp
        for (int i = 0; i < d; i++) { //temp arr te store korlam
            temp[i] = nums[i];
        }

        //shift 
        for (int i = d; i < nums.length; i++) {
            nums[i - d] = nums[i];
        }
        // add temp into last indics....
        for (int i = nums.length - d; i < nums.length; i++) {
            nums[i] = temp[i - (nums.length - d)];
        }
        return nums;
    }
    // optimal solution for d-place left rotation
    // just 3 reverse.....
    public static void leftRotateBy_D_Place_optimal(int[] arr, int d) {
        d = d % arr.length;
        reverse(arr, 0, d - 1);
        reverse(arr, d, arr.length - 1);
        reverse(arr, 0, arr.length - 1);   // left rotate == last, right rotate = fast

    }
    //array reverse with start and end index
    public static void reverse(int[] arr, int start, int end) {
        if (arr == null || start < 0 || start >= end || end >= arr.length) {
            System.out.println("Invalid parameter");
            return;
        }
        while (start < end) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;

            start++;
            end--;
        }
    }
    //Move zeros to end of the array...
    //Brute force: non-zero gula ekta onno array/list e nebo. then copy original array in first length of temp, last e 0 add korbo
    //optimal    : 2 pointer , ekta always 0-value k point korbe , arek ta traverse korbe
    public static void moveZeroes(int[] nums) {
        int j = -1;
        //first zero er index find kora holo
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }
        if (j == -1) {
            System.out.println("'No zeros here'");
            return;
        }
        //now travers from j+1 
        for (int i = j+1; i < nums.length; i++) {
            if (nums[i] != 0) {
                //swap i j values
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    } 

}
