package Heap;

import java.util.Arrays;

public class mainHeap {
    public static void main(String[] args) {
        //main code for minheap
        Minheap mh = new Minheap(10);
        /*
         
        for (int i = 0; i < 10; i++) {
            mh.insertIntoHeap((i+200));
        }
        
        System.out.println(mh.removeMin());
        System.out.println(mh.removeMin());
        
        //main code for maxheap
        MaxHeap mx = new MaxHeap(10);
        for (int i = 0; i < 10; i++) {
            mx.insertIntoHeap((i+200));
        }
        System.out.println(mx.removeMax());
        System.out.println(mx.removeMax());
         */

        //check heapsort
        int[] arr = { 32, 3, 4, 65, 77, 90 };
        for (int i = 0; i < arr.length; i++) {
            mh.insertIntoHeap(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = mh.removeMin();
        }
        System.out.println(Arrays.toString(arr));
        
    }
}
