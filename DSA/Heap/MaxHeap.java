package Heap;

public class MaxHeap {
    private int[] arr;
    private int size;
    private int maxSize;

    MaxHeap(int maxSize) {
        this.size = 0;
        this.maxSize = maxSize;
        arr = new int[maxSize + 1];
        arr[0] = Integer.MAX_VALUE;
    }

    //parent
    public int parent(int index) {
        return index / 2;
    }
    //left
    public int left(int index) {
        return 2 * index;
    }
    //right
    public int right(int index) {
        return 2 * index + 1;
    }
    //check leaf
    public boolean isLeaf(int index) {
        return index > (size/2) && index <= size;
    }

    //swap
    public void swap(int fpos, int spos) {
        int temp = arr[spos];
        arr[spos] = arr[fpos];
        arr[fpos] = temp;
    }

    //max heapify
    public void maxHeapify(int pos) {
        if (!isLeaf(pos)) {
            int left = left(pos);
            int right = right(pos);
            int largest = pos;

            if (left <= size && arr[left] > arr[largest]) {
                largest = left;
            }
            if (right <= size && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest != pos) {
                swap(largest, pos);
                maxHeapify(largest);
            }
        }
    }

    //insert into heap
    public void insertIntoHeap(int value) {
        if (size >= maxSize) {
            System.out.println("heap is already full");
            return;
        }
        size++;
        int curent = size;
        arr[curent] = value;

        while (arr[curent] > arr[parent(curent)]) { //0 index int.min ase so otodur jabai na
            swap(curent, parent(curent));
            curent = parent(curent);
        }
    }
    //remove max
    public int removeMax() {
        if (size == 0) {
            return Integer.MAX_VALUE;
        }
        if (size == 1) {
            size--;
            return arr[1];
        }
        int max = arr[1];
        arr[1] = arr[size--];
        maxHeapify(1);
        return max;
    }
    //print heap
    public void display() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.println("parent: " + arr[i] + " left : " + arr[left(i)] + " right : " + arr[right(i)]);
        }
    }
    

    //############   main function start      ..............
    public static void main(String[] args) {
        MaxHeap mh = new MaxHeap(10);

        mh.insertIntoHeap(12);
        mh.insertIntoHeap(4);
        mh.insertIntoHeap(66);
        mh.insertIntoHeap(86);
        mh.insertIntoHeap(4);
        mh.insertIntoHeap(234);

        mh.display();
        System.out.println();
        mh.removeMax();
        mh.display();
    }


}
