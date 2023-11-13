package Thread;


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
    //@@ a  thread inpterrupt another thread
    public void run() {
        try{
            for (int i = 0; i < 500; i++) {
                System.out.println("child thread");
            }
            Thread.sleep(2000);
        }catch(Exception e){System.out.println("thread got interrupt");}
    }
    
    // Class level lock : used by static synchronized
    DisplayWish d;
    String name;
    
    myThread(DisplayWish d, String name) {
        this.name = name;
        this.d = d;
    }
    
    public void run() {
        d.wish(name);
    }
    
    
    DisplayWish d ;
    
    myThread(DisplayWish d) {
        this.d = d;
    }
    
    public void run() {
        d.display();
    }
    
    */

    //@@@@@ Synchronized block: instead of method declare synchronized , block synchronized block  best : if 
    /*
     * @@@TO GET LOCK OF CURRENT OBJECT:
     * synchronized(this){
     *         ...........only current object
     * }
     * 
     * @@@ TO GET LOCK OF PARTICULAR OBJECT b
     * synchronized(b){
     *      ............ only allow object b
     * }
     * 
     * @@@ TO GET CLASS LEVEL LOCK
     * synchronized(DisplayWish.class){
     *        ............ display class er ekta class e at a time execute korbe
     *  }
     * 
     * 
     * 
     * @@@@@@@@@@@@@@@@@@@@@@ dangerous error @@@@@@@@@@@@@ Dont do it..
     * int x = 10;
     * synchronized(x){
     *          this provide compile time error: CE @@@@@@@
     * }
     * 
     * 
     * //Conclusion: block level synchronize is only applicable for object level or class leve
     *              we can not pass primitive variable
     */
}