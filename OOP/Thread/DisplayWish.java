package Thread;

public class DisplayWish {
    /*
    //@@@ synchronized : this method execute by only one thread at a time..........
     
     public static synchronized void wish(String name)  {
         for (int i = 0; i < 5; i++) {
             System.out.print("Happy BirthDay : ");
             try {
                 Thread.sleep(1000);
                 System.out.print(name+"\n");
             } catch (Exception e){} 
         }
     }
     */
    public synchronized void display()  {
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
            try {
                Thread.sleep(1000);
            } catch (Exception e){} 
        }
    }
    public synchronized void displayC()  {
        for (int i = 65; i < 75; i++) {
            System.out.print((char)i);
            try {
                Thread.sleep(1000);
            } catch (Exception e){} 
        }
    }
}
