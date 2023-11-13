package OOP.Thread;


public class myThread extends Thread {
    static Thread mt;
    /*
     * 
     public void run() {
         for (int i = 0; i < 5; i++) {
             System.out.println("child Thread");
         }
     }
     */
    /* 
    // overloading of run method is possible, but start() is call always no arg method
    //other method call by normal calls
    public void run() {
        System.out.println("no arg");
    }

    public void run(int i) {
        System.out.println("int arg");
    }
     */
    // run method override na korle thread class er run call hobe

    /* 
    //override start()
    public void start() {
        super.start();                     //ekhon child thread create hobe 
        System.out.println("hellow");
    }
    
    public void run() { 
    
    // System.out.println(Thread.currentThread().getPriority());
    //System.out.println("child");
    for (int i = 0; i < 10; i++) {
    System.out.println("child " + i);
      
    Thread.yield(); // main thread k sujog kore dibe , so main thread get chance more number of times 
            //some platform wont support for yeild method
    
    
    try {
    Thread.sleep(2000);
    } catch (Exception e) {
    System.out.println(e);
    }
    } 
    
    //case2: child wait for main thread
    try {
        mt.join();
    } catch (InterruptedException e) { e.printStackTrace();}
    
    for (int i = 0; i < 5; i++) {
        System.out.println("child was wait until main thread complete");
    }
    }
    */
    //@@ a  thread inpterrupt another thread
    public void run() {
        try{
            for (int i = 0; i < 500; i++) {
                System.out.println("child thread");
            }
            Thread.sleep(2000);
        }catch(Exception e){System.out.println("thread got interrupt");}
    }
}