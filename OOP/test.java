public class test implements interfaceVsAbsClass {
    
    public void doYour() {

        System.out.println(s+" "+number++);
    }
    public static void main(String[] args) {
        test a = new test();
        a.doYour();
        interfaceVsAbsClass i = new interfaceVsAbsClass() {
            int number = 30000;
            @Override
            public void doYour() {
                System.out.println(number);
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'doYour'");
            }
            
        };
    }
}


