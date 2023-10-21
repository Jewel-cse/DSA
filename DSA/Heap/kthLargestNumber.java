package Heap;
import java.util.Collections;
import java.util.PriorityQueue;

public class kthLargestNumber {
    public static void main(String[] args) {
        int[] nums = { 2, 4, 567, 2, 54, 67, 657, 5, 6575, 90 };
        //System.out.println(findKthLargest(nums, 3));
        int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        System.out.println(kthSmallest(mat, 2));
    }
    
    //find kth largest element in an array
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> mx = new PriorityQueue<>(Collections.reverseOrder()); //for max heap

        //build 
        for (int i = 0; i < nums.length; i++) {
            mx.add(nums[i]);
        }
        for (int i = 1; i < k; i++) {
            mx.poll();
        }
        return mx.poll();
    }
    
    //find kth smallest element in a sorted matrix
    public static int kthSmallest(int[][] matrix, int k) {
        if (k < 1 || k > matrix.length * matrix[0].length) {
            return -1;
        }

        PriorityQueue<Integer> minheap = new PriorityQueue<>(); //min heap...
        int counter = 0 ;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                minheap.offer(matrix[i][j]);
                if (++counter == k) {
                    break;
                }
            }
        }
        for (int i = 1; i < k; i++) {
            minheap.poll();
        }
        return minheap.peek();
    }
}
