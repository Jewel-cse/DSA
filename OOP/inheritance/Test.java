package inheritance;

public class Test {
    public static void main(String[] args) {
        Parent p = new Parent();
        p.methodOne();
        //p.methodTwo(); //undefined for parent // CE > compilation error
        
        Child c = new Child();
        c.methodOne();
        c.methodTwo();

        Parent p1 = new Child();
        p1.methodOne();
        //p1.methodTwo();   //Parent type er jonno method two undefined//CE

    }
}
