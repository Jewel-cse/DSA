public class inout {
    public static void main(String[] args) {

        /*
         * 
         String og = "opengenus";    //new object
         String og2 = new String(og);   //new object  
         System.out.println((og==og2) + " "+ (og.equals(og2)));  //== >check reference  .equal> check content
         */

        /*
         * 
         double num = 2.718;
         double num = 2._718;  // _ is always between two digits
         double num = 2.7_1_8;
         */

        /*
         * 
         String str1 = new String("open");
        String str2 = new String("source");  
        String str3 = new String("opengenus");
        str3 = str1;  // str3---->open
        str2 = str3;  //str2 ---->open
        str1 = str2; //str1 --->open
        //all the reference point to the open , baki 2 ta without reference,garbage collector clear other two objecj 
         */

        /*
         * 
         short x = 12;
         double d1 = 'x'+4; //  ok
         double d2 = 5.0; //  ok
         float f1 = 5f; //  ok
         float f2 = 5.0; // not ok       compilation error.// big memory --> small memory @wrong
         */

        /*
         * 
         String car , bus = "petrol";
         car = car + bus;     //car may not initialized
         System.out.println(car);
         */

        /*
         * 
         for(int i=0; 0; i++) {       // can not convert int->boolean
             System.out.println("Hello World!");
         }
         */

        /*
         * 
        for(int i = 0; i < 1; i++) {
            System.out.println(i + ' ');     // whitespace char er int value 32 ....> 0+32=32 print
            System.out.println((char) i);
            System.out.println((int)' ');
        }
         */

        // int $_ = 5;     //in java its valid to start _/$/alphabet 

        //System.out.println('j' + 'a' + 'v' + 'a');// concatenetion korle java which is not a string
        //sobgula char er sum print korbe

        /*
         * 
         public static void main(String[] args) {
             method(null);
         }
         public static void method(Object o) {
             System.out.println("Object method");
         }
         public static void method(String s) {       // call korbe
             System.out.println("String method");
         }
         *
         * ***Null is not an object in Java.
        
            Java compiler prefer the method which has more specific parameters.
            String is object of the class java.lang.String. Hence, String is more specific than Object class. 
            Therefore, null is matched as a string object.
         */

        ///System.out.println(args.length);  //javac inout.java, java inout.java args list... er length debe
        
        
        /*
         * 
         * 
         * 
         public class Code {
            public static void main(String[] args) {
                method(null);
            }
            public static void method(Object o) {
                System.out.println("Object method");
            }
            public static void method(Integer i) {
                System.out.println("Integer method");
            }
            public static void method(String s) {
                System.out.println("String method");
            }
         * 
         *  Java compiler prefer the method which has more specific parameters.
            String is object of the class java.lang.String. Hence, String is more specific than Object class 
            but it is equally specific to Integer class. 
            Therefore, null is unable to match to any function as it is unable to choose between String and Integer.
         * 
         * 
         */

         
        /*
         * 
         StringBuffer str1 = new StringBuffer("open");
         StringBuffer str2 = str1;
         str1.append("genus");
         System.out.println(str1 + " " + str2 + " " + (str1 == str2));
         
         //opengenus opengenus true;
         * 
         */



        /*
         * 
         int y = 08; //
         y = y + 2;
         System.out.println(y);
         //Any number starting with 0 is considered an octal number which has digits from 0 to 7. 
         //So, 08 is invalid and hence, the code will fail to compile.
         * 
         */



    }
    /*
     * The problem is that in Java, we cannot have static local variables. The alternative is to use static class members.
    
        The fix will be to change "data" variable to be non-static or make "data" variable a static class member.
    
    
     * 
     static int value() {
         static int data = 0;   // remove static
         return data;
     }
     */
    


    //main function can be overloaded.......but String[] args is the entry point
    public static void main(String args) {
        
    }     

}
