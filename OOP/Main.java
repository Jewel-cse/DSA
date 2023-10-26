public class Main {
    //associate with Class A,B
    public static void main(String[] args) {
        B b = new B(); // execution sequenc > class B >{load classA static},{b static},{a non static}, {b non static}
        System.out.println(b.i);      //last  keep mind i static variable    
    }
}
