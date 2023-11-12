public class MainCasting {
    public static void main(String[] args) {

        /*               Object
                        /     \
                    Base1      Base2
                    /   \       /  \
                der1   der2  der3   der4
                /
             der11
         
         */
        /* 
        Base2 b = new der4();
        Base1 b1 = (Base1) b; //[CE]compile time check 1 : Base2 and Base1 does not hold parent child reletionship
        der4 d = (der4) b;
        Base2 b2 = (Base2) b;
        Object o = (der3) b; //[RE] r1: der3 and der4 are not parent child releation//run time error......
        Bas2 b3 = (Base1) b; //[CE]  c1: base1 and base2 are not int parent child relationship 
        
        */
        
        //Override > decide JVM> runtime object> (((der1)))
        //if al method are static > decide Compiler> reference type .... 
        der11 d = new der11();
        d.m1(); //der1

        der1 d1 = (der1) d;
        d1.m1();  //der1

        Base1 b = (Base1) d1;
        b.m1(); //der1

        //true bcz all reference point same object
        System.out.println(d == d1);
        System.out.println(d1==b);
    }   
}
