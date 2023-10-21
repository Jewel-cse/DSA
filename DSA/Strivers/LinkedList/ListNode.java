package Strivers.LinkedList;

//main class leetcodeLL.java
public class ListNode {

    //basic structure......... which helps to solve leetcode problem...............
    public ListNode head;
    public static ListNode tail;
    public static int size = 0 ;

    public int value;
    public ListNode next;

    public ListNode() {
    }

    ListNode(int value) {
        this.value = value;
    }

    ListNode(int val, ListNode next) {
        this.value = val;
        this.next = next;
    }


    //insert.................
    public void insertFirst(int value) { // head  ---> 1 -> 2 -> 3 <---tail  // 1 2 3 insert korle emon hobe...
        ListNode node = new ListNode(value);
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
            ListNode node = new ListNode(value);
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
            ListNode temp = head; // itself 0 position
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            ListNode node = new ListNode(value, temp.next);
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
        ListNode senocdlast = get(size - 2);
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
        ListNode prev = get(index - 1);

        int value = prev.next.value;
        prev.next = prev.next.next;
        size--;

        return value;
    }

    //get the node at given index
    public ListNode get(int index) {
        ListNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    //find the node that given the value
    public ListNode find(int value) {
        ListNode node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    /// display
    public void display(ListNode head) {
        System.out.println("List size : " + size);
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    
   
    
    
}
