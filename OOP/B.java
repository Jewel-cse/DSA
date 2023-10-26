public class B extends A {
    static {
        i = i-- - --i;
        System.out.println("third: " + i);
    }
    
    {
        i = i++ + ++i;
        System.out.println("fourth: "+i);
    }
}
