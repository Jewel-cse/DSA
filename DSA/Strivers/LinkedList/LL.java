package Strivers.LinkedList;

public class LL {

    //##########################    LL from kunal and main LL   ####################
    /*................Singly linked list......................
     * this is basic operation of linkedlist 
     * insert first, last and given index
     * delete first, last and given index
     * find node with given value
     * get index
     */
    protected Node head;
    protected Node tail;
    protected int size;

    public LL() {
        size += 0;
    }
    // head and tail both point NULL , and linkedlist size is 0
    
    //          --------------insert first, last and given index-------------------

    //now insert element in 1st position
    public void insertFirst(int value) { // head  ---> 1 -> 2 -> 3 <---tail  // 1 2 3 insert korle emon hobe...
        Node node = new Node(value);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size += 1;
    }
    
    // insert at last 
    public void insertLast(int value) {
        if (tail == null) {
            insertFirst(value);
        }
        else {
            Node node = new Node(value);
            tail.next = node;
            tail = node;
            size++;
        }
    }
    //insert at index...............
    public void insert(int value, int index) {
        if (index == 0) {
            insertFirst(value);
            return;
        } else if (index == size) {
            insertLast(value);
            return;
        } else {
            Node temp = head; // itself 0 position
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            Node node = new Node(value, temp.next);
            //node.next = temp.next;
            temp.next = node;
            size++;
        }
    }

    //                  -------------Delete first, last and given index ------------------

    public int deleteFirst() {
        int value = head.value;

        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }


    public int deleteLast() { // using get method
        if (size <= 1) {
            deleteFirst();
        }
        Node senocdlast = get(size - 2);
        int value = tail.value;
        tail = senocdlast;
        tail.next = null;
        size--;

        return value;
    }

    //delete at given index.............
    public int delete_(int index) {
        if (index == 0) {
            deleteFirst();
        }
        if (index == size - 1) {
            deleteLast();
        }
        Node prev = get(index - 1);

        int value = prev.next.value;
        prev.next = prev.next.next;
        size--;

        return value;
    }

    //get the node at given index
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    //find the node that given the value
    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    /// display
    public void display() {
        System.out.println("List size : " + size);
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    
    // ----------------------list reverse -------------------
    public Node reverse_list(Node head) {
        Node p = null;
        Node next;
        while (head != null) {
            next = head.next;
            head.next = p;
            p = head;
            head = next;
        }
        return p;
    }


    //Node design..........................

    public class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
        public Node(int value,Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
