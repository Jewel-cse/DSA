package Thread;

public class DaemonThread {
    public static void main(String[] args) throws InterruptedException{
        
        childDaemon d = new childDaemon();
        //System.out.println(d.isDaemon()); //false, bcz parent thread(main) is non daemon
        d.setDaemon(true);
        //System.out.println(d.isDaemon()); //false, bcz parent thread(main) is non daemon
        d.start();
        d.stop();
        Thread.sleep(4000); // 4 seconds background e run hobe , after main thread execute complete, child thread terminate
        // sleep na dile main thread execute er somoi joto tuku execute korte pare simultaneously...
        System.out.println("main ");
    }
}
