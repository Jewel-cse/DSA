public class imp_Q_LL {
    //node design
    
    
    private class Node {
        int val;
        Node next;
        
        Node(int val) {
            this.val = val;
            next = null;
        }
    }
    Node front;
    Node rear;
    int size;

    public imp_Q_LL() {
        front = null;
        rear = null;
        size = 0;
    }

    //Enqueue operation
    public void enqueue(int val) {
        Node node = new Node(val);
        if (front == null) {
            front = node;
            rear = front;
        }
        rear.next = node;
        rear = rear.next;
        size++;
    }

    //deque operation
    public int deque() {
        if (front == null)
            return -1;
        int x = front.val;
        front = front.next;

        return x;
    }
    //top element
    public int top() {
        if (front == null)
            return -1;

        return front.val;

    }
    
    // display queue
    public void display() {
        if (front == null) {
            return;
        }
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}
