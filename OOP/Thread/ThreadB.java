package Thread;

public class ThreadB extends Thread{
    int total = 0;

    public void run() {
        synchronized (this) {  //2
            System.out.println("child thread try to calculation");
            for (int i = 0; i < 101; i++) {
                total += i;
            }
            this.notify();   //3
        }
    }
}
