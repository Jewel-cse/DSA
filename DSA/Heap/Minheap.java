package Heap;

public class Minheap {
    private int[] arr;
    private int size;
    private int maxSize;

    Minheap(int maxSize) {
        this.size = 0;
        this.maxSize = maxSize;
        arr = new int[maxSize + 1];
        arr[0] = Integer.MIN_VALUE;
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

    //min heapify
    public void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            int left = left(pos);
            int right = right(pos);
            int smallest = pos;

            if (left <= size && arr[left] < arr[smallest]) {
                smallest = left;
            }
            if (right <= size && arr[right] < arr[smallest]) {
                smallest = right;
            }
            if (smallest != pos) {
                swap(smallest, pos);
                minHeapify(smallest);
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

        while (arr[curent] < arr[parent(curent)]) { //0 index int.min ase so otodur jabai na
            swap(curent, parent(curent));
            curent = parent(curent);
        }
    }
    //remove min
    public int removeMin() {
        if (size == 0) {
            return Integer.MIN_VALUE;
        }
        if (size == 1) {
            size--;
            return arr[1];
        }
        int min = arr[1];
        arr[1] = arr[size--];
        minHeapify(1);
        return min;
    }
    //print heap
    public void display() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.println("parent: " + arr[i] + " left : " + arr[left(i)] + " right : " + arr[right(i)]);
        }
    }
    

    //############   main function start      ..............
    public static void main(String[] args) {
        Minheap mh = new Minheap(10);

        mh.insertIntoHeap(12);
        mh.insertIntoHeap(4);
        mh.insertIntoHeap(66);
        mh.insertIntoHeap(86);
        mh.insertIntoHeap(4);
        mh.insertIntoHeap(234);

        mh.display();
        System.out.println();
        mh.removeMin();
        mh.display();
    }


}
