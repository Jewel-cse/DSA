import java.util.HashMap;

public class LRUCache {
    int capacity;
    Node head = new Node(0, 0), tail = new Node(0, 0);

    HashMap<Integer, Node> map = new HashMap<>();
    //constructor of LRUCache class with inistantiate capacity of cache
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    //get operatin
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        else {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }

    }
    //put operation 
    //capacity size er soman hoye gele last used node delete korte hobe
    //head er por new node insert korte hobe
    public void put(int key, int value) {
        // map e jodi age thekei thake tahole delete korte hobe
        if (map.containsKey(key)) {      // first check 
            remove(map.get(key));
        }
        //
        if (map.size() == capacity) {   // 2nd check please order maintain  test case fail: otherwise error
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }

    private  void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private  void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }



    //Node design
    class Node{    //doubly Linked list
        Node next;
        Node prev;
        int key,value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
