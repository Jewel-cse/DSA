package BinarySearch;
public class countOccurance {
    public static void main(String[] args) {
        int[] arr = { 1, 2,2,2,2,4,4, 4, 4, 5 };
        System.out.println(count(arr, arr.length, 3));
        //System.out.println(firstOccr(arr, 4));
        //System.out.println(lastOccr(arr, 4));
        System.out.println(totalOccurance(arr, 3));

    }
    //            ***********Approach one***************
    // BS e jekono ekta x pailei tar age and pore loop calabo jotokhon x pawa jai and count korbo
    public static int count(int arr[], int n, int x) { //length,target
        int low = 0;
        int high = n - 1;
        int count = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) { //ureca.....
                count++;
                int forward = mid + 1;
                int backward = mid - 1;

                while (forward <= high && arr[forward] == x) {
                    count++;
                    forward++;
                }
                while (backward >= low && arr[backward] == x) {
                    count++;
                    backward--;
                }
                break;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return count;
    }

    // ############## using lower bound and upper bound ####################
    //lower bound gives the last occurance 
    //upper bound gives the first occurance

    public static int upperbound(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int firstOccrance = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                firstOccrance = mid;
                high = mid - 1; //find <--next lessOrequal target
            } else {
                low = mid + 1;

            }
        }
        return firstOccrance;
    }
    
    //its provide last posible location which it is
    public static int lowerbound(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int lastOccrance = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= target) {       // equal dileo hoto  na thkle -1 return korbe
                lastOccrance = mid;
                low = mid + 1; //find next--> lessOrequal target
            } else {
                high = mid - 1;

            }
        }
        return lastOccrance;
    }
    //lets calcualte the occurance
    public static int totalOccurance(int[] nums, int target) {
        int first = upperbound(nums, target);
       // System.out.println(first);
        if (first == -1) {
            return 1;
        }
        int last = lowerbound(nums, target);
        return last - first + 1;
    }
    
}
