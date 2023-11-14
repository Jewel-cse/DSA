package Thread;

public class A {
    public synchronized  void d1(B b) {
        System.out.println("Thread starts executing of d1 method");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        System.out.println("Thread trying to call B's last method");
        b.last();

    }

    public synchronized  void last() {
        System.out.println("inside A   last method!");
    }
}
