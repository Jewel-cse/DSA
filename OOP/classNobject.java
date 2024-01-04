public class classNobject {
    static class inner{
        int x =10;

        private void greetings() {
            System.out.println("hello from inner class");
        }

        private  void propose() {
            System.out.println("i love you"+x);
        }
    }
    
    int x = 34;

    private void greetings() {
        System.out.println("hellow from outer"+x);
    }

    public static void main(String[] args) {
        classNobject ob = new classNobject();
        inner in = new inner();
        ob.greetings();
        in.propose();
    }
}
