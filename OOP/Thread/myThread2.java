package Thread;

public class myThread2 extends Thread {
    DisplayWish d ;

    myThread2(DisplayWish d) {
        this.d = d;
    }

    public void run() {
        d.displayC();
    }
}
