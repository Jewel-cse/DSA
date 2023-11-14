package Thread;

/**
 * InterThreadCommunications
 */
public class InterThreadCommunications {

    /*
     * 1>>Two thread can communicate with wait(),notify(),notifiyAll() is present in @@@@ Object class
     * >> (t1)the thread which is expecting updation is responsible call @@@@ wait()
     *    then immediately enter into wait state
     * 
     * >> (t2)the thread which is responsible perform updation, afer perform updation it is responsible to call 
     *    @@@ notify(), the waiting thread get notification and continue its executions those updated item.
     * 
     * 
     * 2>>>
     *   @@@Class object
     *           : wait()
     *           : notify()
     *           : notifyAll()
     *              >>> this 3 method only use in multithreading ,@@@@but Object class e ase keno????
     *          ##Ans: thread can call this method on @@@ any java object
     * 3>>>
     *   @@@ if thread t1 call obj1.wait():: must sure that t1 is owner of obj1 , otherwise CE: IllegalMonitorStateException
     *                   :: t1--> lock(obj1) 
     *                  :: these 3 method should be called from synchoronized area.  @@@ otherwise  RE
     *                                          
     * 4>>>
     *  @@@@@ if a thread calls wait method of any object it @@immediately relese that particular object and 
     *      enter into waiting state,@@@@  this 3 method chara r kothoa thread @@lock release kore na
     * 
     * 5>>>
     * @@@@@if a thread calls wait method on any object > it releases  lock of particular object by the thread and  enter waiting state
     *                                                  > it releases lock of particular objects but may @@ not immmediately
     *                                                  
     *       @@@@ wait() @@@@@ thread running -> wait()--> waiting state > notify()--> @@@@@ another waiting state to get lock @@@@  -->ready state/runable
     * public final void wait() throws InterruptedException @@@ checked exception so must be handled by @@@@@@ try-catch, or throws
     * public final native void wait(long ms,int ns) throws InterruptedException{}
     * public final void wait(long ms,int ns) throws InterruptedException{}
     *       @@@@ notify() @@@@@
     * public final native void notify()
     * public final native void notifyAll()
     * 
     * @@@ see threadA, ThreadB example. 
     * @@ use of : sleep() vs join()  vs wait() and notify()
     * @@ sleep() and wait()
     * @@ sleep(long ms) and wait(long ms)
     * 
     * 
     * 
     * @@@@@@@@@ Loook producer and consumer problem @@@@@@@@@@@@@@@@@@
     *    @@  producer produce something and consumers consume this thing
     * 
     * @@ producer thread is responsible to produce some queue
     * @@ consumer thread is responsible to consume some queue
     * 
     * if queue is empy: consume method call wait()
     * after producing items to the queue producer thread is resiponsible to call notify()
     * then waiting consumer method get notification
     * and continue its execution with updated items
     * 
     * 
     * @@@@ notify() vs notifyAll()
     *   notify()  :: if multiple thread is wait for any updation, only one thread is notify, de
     *              :: decide by jvm,remaining thread wait for further notification
     *                 :: 10 thread waiting, 1 get notification,waiting 9 for ...
     *  notifyAll  :: all the waiting thread for perticular obj  will be notify 
     *              :: 60 thread get notification same time, execution one by one...@@@@bcz use lock.
     * 
     * 
     * @@@@@@@@@@@@@@@@ Deadlock @@@@@@@@@@@@@
     *     two thread are waiting for each other forever 
     *     :: @@@ synchronized keyword is the @@@ only reason for a program deadlock
     * 
     *     Deadlock example. Class A,B,Deadlock : if we remove atleast one synchronized from 4 synchoronized mehtod
     *                       tahole deadlock hobe na
     * 
     * 
     * @@@@@ Deadlock vs Starvation @@@@@@@
     *      : waiting never ends > @@@ deadlock
     *      : long waiting but waiting ends >  @@@ starvation 
     * 
     * @@@@@@@@ Daemon thread  : the thread which are executing background , 
     *        Ex: GC(garbage collector), Signal Dispatcher, Attach Listener.
     *         Purpose : provide support for non <<<daemon///main>>> thread, (produce cinema, director and others)
     *         usually run with low priority but based on requirement runs also high priority<<<Garbage colector>>>
     * 
     *  public void isDaemon():: check daemon method kina
     *  public void setDaemon(boolean b)   :: change daemon nature of a thread only before thread start
     *                                      ::                          after: Runtime exception
     *  by default <<<main>>> thread is <<Non daemon>>, other <<inherit>> from parent
     *  @@@main thread er daemon nature<<<@@ change korte parbo na>>>, cz already start by jvm
     *  @@ last non-daemon thread terminated, then all daemon thread terminated...
     * 
     */

}