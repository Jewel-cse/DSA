package Strivers.LinkedList;

// Design linked list.................
class MyLinkedList {
    class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;
    public int size;

    public MyLinkedList() {
        
    }
    
    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        Node temp = head;

        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }
    
    public void addAtIndex(int index, int val) {
        Node newNode = new Node(val);

        if(index > size){
            return;
        }
        if(index <= 0){
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        size++;

        Node temp = head;

        for(int i = 0; i < index - 1; i++){
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }
    
    public void deleteAtIndex(int index) {
        Node temp = head;

        if(index < 0 || index >= size){
            return;
        }
        size--;
        if(index == 0){
            head = head.next;
            if(size == 0){
                head = tail = null;
            }
            return;
        }

        for(int i = 0; i < index - 1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;

        if(size == index){
            tail = temp;
        }
    }
}