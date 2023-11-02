public class threadExample implements Runnable {
    public void run() {
        for (int j = 0; j < 5; j++)
            System.out.println("hello" + j);
    }
    public static void main(String[] args) {
        Thread th = new Thread(new threadExample());
        th.start();
        
        for (int i = 0; i < 10; i++) {
            System.out.println("jewel");
        }
    }
}
