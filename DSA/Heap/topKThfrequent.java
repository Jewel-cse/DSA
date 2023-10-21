package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class topKThfrequent {
    public static void main(String[] args) {
        int[] nums = { 1, 2,3,4,5,6,7,8,9,9,8};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
       
    }

    
    public static int[] topKFrequent(int[] nums, int k) {
        //map the frequency with element
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        //min heap e add 
        //System.out.println(map.toString());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(map.get(a), map.get(b))); // frequency er upor base kore heap create hobe

        for (Integer num : map.keySet()) { // less frequent gula age asbe from keyset
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // less frequent gula sob remove  hobe.....
            }
        }
        //top frequncy gula reverse order e ase
        int[] ans = new int[k];
        int i = 0;
        while (!minHeap.isEmpty())
            ans[i++] = minHeap.poll();

        return ans;
    }
        
       
      
}
