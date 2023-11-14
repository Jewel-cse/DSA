package Thread;

public class ThreadA  {
    public static void main(String[] args) throws InterruptedException{
        ThreadB b = new ThreadB();
        b.start(); //there are two thread : main and child
        // i am expect total calculate done then print . so i call wait()
        // is sleep() recomendation   : NO
        // is join() recomentdation   : No @total calculation er por jodi aro huge instruction thake tahole time waste
        
        Thread.sleep(1000);  // ei time er moddhe child threadb calculation done

        synchronized (b) {  //1
            System.out.println("main thead try to call wait() method");
            b.wait(10000); // synchronized block e rakhte hobe
            System.out.println("main thread got notification");//4
            System.out.println(b.total);

            //wait use korle uporer sleep use kora jabe ,
            // sleep use korle : oi time e child thread complete kore exucute done hoye jabe
            // ->wait()  infinte time wait;(no output /running)
            // ->wait(10000) : wait only 10 sec then 
        }
    }
}
