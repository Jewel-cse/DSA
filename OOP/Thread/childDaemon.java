package Thread;

public class childDaemon extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("child : " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }
}
