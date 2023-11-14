package Thread;

public class DeadLock extends Thread {
    A a = new A();
    B b = new B();

    public  void go() {
        this.start();  // now two thread
        a.d1(b);     /// execute by main
    }

    public void run() {
        b.d2(a);  // execute by child
    }

    public static void main(String[] args) {
        DeadLock d = new DeadLock();
        d.go();
    }
}
