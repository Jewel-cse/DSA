package Polymorphism;

public class overriding {


    /*in Runtime polymorphism : method resulation is dicide by jvm based on @@@@@@@@ runtime object
    //@@@@@@@@@@@@@@  Override kokhon hoy na?
     * > private property/method
     * but allow in child in same
     * >static  > non static (not) child and parent 2 tai dite hobe @CE
     * >non static > static (Not)  @CE
     * > static(parent) > static(child) : @@@@  not overriding ,its @@@@@@ Method Hiding , method resulation: reference type..
     * >final  > compile time error
     * >variable argument  override by only var-arg method : other wise method overload, reference type @@@@@@
     * >variable overrride hoi na: just reference type onujaii call hoi...
     * 
     */



    /*
     * 
     class Parent {
         public void property() {
             System.out.println("cash+land+gold");
         }
         public void marry() {
             System.out.println("subbalakshmi"); //overridden method
         }
     }
     class Child extends Parent{ //overriding
         public void marry() { 
             System.out.println("3sha/4me/9tara/anushka"); //overriding method
         }
     }
     class Test {
         public static void main(String[] args){
         Parent p=new Parent();
         p.marry();//subbalakshmi(parent method)
         Child c=new Child();
         c.marry();//Trisha/nayanatara/anushka(child method)
    
         //@@@@@@@@@@@ case 1 @@@@@@@@@@@@@@@@
         Parent p1=new Child();  //override occur ?child method: parent method
         p1.marry();//Trisha/nayanatara/anushka(child metho }
     }
     */
    
    /*
     * 
     class Parent {
         public static void methodOne() {
             System.out.println("parent class");
         }
     }
     
     class Child extends Parent {
         public static void methodOne() {
             System.out.println("child class");
         }
     }
     
     class Test{
        public static void main(String[] args) {
        Parent p=new Parent();
        p.methodOne();//parent class
 
        Child c=new Child();
        c.methodOne();//child class
 
        Parent p1=new Child();
        p1.methodOne();//parent class // both parent and child method are static: so override hoi ni ,method hiding hoyese
        //method override na hole reference type onujaiiii function call hobe.
 
        // if both are @@@@@@@@ non static : then ouput
        Parent p1=new Child();
        p1.methodOne();  // child class hoto 
         
    }
}
*/




}
