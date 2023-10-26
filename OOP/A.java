public class A {
    //A B Main  there are three class. see main
    static int i = 1000;
    static {
        i = i-- - --i;
        System.out.println("first: "+i);
    }
    {

        i = i++ + ++i;
        System.out.println("Second: "+i);
    }
}
