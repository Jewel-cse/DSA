package Thread;

public class B {
    public synchronized void d2(A a) {
        System.out.println("Thread starts executing of d2 method");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        System.out.println("Thread trying to call A's last method");
        a.last();

    }

    public synchronized void last() {
        System.out.println("inside B  last method!");
    }
}
