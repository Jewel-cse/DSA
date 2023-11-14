package Thread;

public class Producer extends Thread {
    public static ProductQue q;
    public void produce() {
        synchronized (q) {
            System.out.println("produce item to the queue");
            q.notify();
        }
    }
}
