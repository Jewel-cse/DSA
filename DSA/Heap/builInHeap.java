package Heap;

import java.util.PriorityQueue;

public class builInHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> mh = new PriorityQueue<>();

        for (int i = 0; i < 10; i++) {
            mh.add(i * 2 + 6);
        }
        while (!mh.isEmpty()) {
            System.out.println(mh.poll());
        }
    }
    
}
