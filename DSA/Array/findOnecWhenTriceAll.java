/* 
 * an array with all element apears with 3 times except only one element
 * find the element@@@@
 * 
 * approach: 
 * 1: sort and check continuous element
 * 2: hashing and check frequency
 * 3: sum of set bit  and mod with 3 , decide that position set or not
 * 4: Using XOR: hold the value which apear ones, and hold the value which apears twice
 *   then remove common element
 * 
 * 
 */
public class findOnecWhenTriceAll {


    
    //Time : o(32 * n), space: o(1), n = number of elemlent of arary
    private static int findSingle(int[] arr) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                if ((arr[j] & (1 << i)) != 0)
                    sum++;
            }
            if (sum % 3 != 0)
                res |= (1 << i);
        }
        return res;
    }


    //Main driver code
    public static void main(String[] args) {
        int[] arr = { 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 8, 8,8, 9, 9, 9, 12, 12, 12, 7 };
        System.out.println(findSingle(arr));    
    }
    
}
