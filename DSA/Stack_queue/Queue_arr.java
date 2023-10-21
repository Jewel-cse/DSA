package Stack_queue;
public class Queue_arr {
    int front;
    int rear;
    int size;
    int[] arr = new int[5];
    Queue_arr(int size) {
        front = -1;
        rear = -1;
        this.size = size;
        arr = new int[size];

    }

    

    // enqueue : insert into rear
    public void enqueue(int val) {
        if (isFull()) {
            System.out.println("queue overflow");
            return;
        } else if (front == -1) {
            front++;
        } 
        rear++;
        arr[rear] = val;
    

    }
    
    //dequeue  : delete from front
    public int dequeue() {
        if (isEmpty()) {
            return -1;
        }
        else if (front >= rear) {
            int val = arr[front];
            front = -1;
            rear = -1;
            return val;
        }
        else {
            return arr[front++];
        }
    }
    
    //queue is full or not
    public boolean isFull() {
        if (front == 0 && rear == size - 1) {
            return true;
        }
        return false;
    }
    // queue is empty or not
    public boolean isEmpty() {
        if (front == -1 && rear == -1) {
            return true;
        }
        return false;
    }
    
    // display queue
    public void displayQueue() {
        //System.out.println(arr.length);
        if (isEmpty()) {
            System.out.println("empty queue");
        } else {
            System.out.println("front index: " + front + " rear index: " + rear);
            for (int i = front; i <= rear; i++) {
                System.out.print(arr[i] + "  ");
            }
            System.out.println();
        }
    }


}
