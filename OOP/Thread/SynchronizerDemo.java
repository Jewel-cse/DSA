package Thread;

public class SynchronizerDemo {
    public static void main(String[] args) {
    
        /* if we do not use synchronized in wish method : output will iregular,
         * synchronized: regular
         DisplayWish d = new DisplayWish();
         myThread t = new myThread(d, "Dhoni");
         myThread t2 = new myThread(d, "kohli");
         myThread t3 = new myThread(d, "SRK");
         myThread t4 = new myThread(d, "HANIYA");
         t.start();
         t2.start();
         t3.start();
         t4.start();
         */

        /*
         * 2 ta alada object er upor wish method alada vabe simultaneously run hobe, so output @@@irregular
         // if muliple thread operate with same object ,then need @@@synchronized
         // class level synchronized : static synchronized
         DisplayWish d1 = new DisplayWish();
         DisplayWish d2 = new DisplayWish();
         myThread t1 = new myThread(d1, "Jewel");
         myThread t2 = new myThread(d2, "rana");
         
         t1.start();
         t2.start();
         */
        /* 
        DisplayWish d = new DisplayWish();
        myThread t =new myThread(d);
        myThread2 t2 =new myThread2(d);
        t.start();
        t2.start();
        
         */
        /*
                    @@@@Question: 
        
         *   synchronized keyword, where we can use: 
         *  Adv: solve data inconsistency
         *  dis: increases waiting time
         *  race condition: multiple thread operating same java object , then: data inconsisteny : this is called 
         *                  : we can overcome this problem by synchronized keyword
         *  object level lock & when required: synchronized method use korle object level lock
         *  Class level lock :  when a thread use static synchronized method then its class level lock
         * 
         * obj level vs class level: 
         */
   }
}
