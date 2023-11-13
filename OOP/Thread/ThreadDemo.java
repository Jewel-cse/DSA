package Thread;
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        //System.out.println(Thread.currentThread().getName());
        //Thread.currentThread().setPriority(7); 
        //myThread t = new myThread(); // thread instantiation
        /* 
        System.out.println(t.getName());
        Thread.currentThread().setName("jewel");
        System.out.println(10/0);
        */
        //System.out.println(Thread.currentThread().getPriority());
        //Thread.currentThread().setPriority(15); // illegal arg exception : RE
        //t.start();
        //System.out.println(t.getPriority());
        //t.start(); //start of a thread
        //t.start(); // after call start() we cant call start  run time exception:: Illegal threadState exception
        
        

        /* 
        //using implemneting runnable
        myRunnable r = new myRunnable();
        Thread t = new Thread(r);
        t.start();
        
        for (int i = 0; i < 5; i++) {
            System.out.println("Main thread");
        } */
        
        /* 
        myThread t = new myThread();
        //t.setPriority(10);
        // some platform wont support thread prioritis................
        // we dont get expected output bcz of os 
        Thread.currentThread().setPriority(10);
        t.setPriority(1);
        t.start();

        for (int i = 0; i < 11; i++) {
            System.out.println("main " + i);
        }
        */
        
        /*
         * we can prevent the thread execution  
          : yeild() : pause the current executing thread to give a chance of waithing thread with some or high priority
          : join()  : if t1 is want to wait for t2, then t1 call korbe t2.join() : t2 complete hobe then , t1 continue korbe,, throws InterruptedException
          : sleep() :
         */

        // yeild method() : see mythread run()

        /* 
        // Case 1: @@@@  main thread wait korbe until mythread complete 
        myThread t = new myThread();
        t.start();
        //t.join();  // in main throws ie nahole CE, main thread wait korbe until t thread complete,,,,
        t.join(10000,10000); // 10 seconds wait korbe
        
        for (int i = 0; i < 5; i++) {
            System.out.println("main thread ");
        }
        
        
        // Casse2 : @@@@@@@   Child thread wait until main complete
        myThread.mt = Thread.currentThread();
        
        myThread t = new myThread();
        t.start();
        t.join();     //@@@@@@ deadlock situation ,cz child thread calls join on main thread 2 ta thred e 2 joner jonno wait korse 
        for (int i = 0; i < 5; i++) {
            System.out.println("main thread running");
        }
        
        
        
        //@@@@  : How a thread interrupt another thread
        
        myThread t = new myThread();
        t.start();
        t.interrupt(); // check child thread is in sleep state/ wait state, sleep na korle @@@@@@  interrupt korbe na@
        
        Thread.sleep(4000);  // after interrupt child sleep main 4 seconds.....
        for (int i = 0; i < 500; i++) {
            System.out.println("main thread");
        }
        
        */



    }
}
