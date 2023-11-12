package Polymorphism;

public class overloading {
    /*   ****************   type promotion ***************
     * byte -> short -  int - long- float - double
     *             char^
     * 
     * 
     * @@@@@@ choto jinis boro container e rakha jabe but - implicit
     * @@@@@@ choto container e boro jinis  > explicit
     * Method hiding: static(parent) - static(child) :  compile time polymorphism/ @@@@@@ not override
     */
/* 
     
      //case 1:  
      public void methodOne(int i){
          System.out.println("int-arg method");
      }
  
      public void methodOne(float f) { //overloaded methods{
          System.out.println("float-arg method");
      }
         overloading t=new overloading();
        t.methodOne('a');//int-arg method
        t.methodOne(10l);//float-arg method
        //t.methodOne(10.5);//C.E:cannot find symbol  #############
        t.methodOne('a');  // atomatic promotion
      
 */


    /*
    * 
    //case 2
    public void methodOne(String s) {
        System.out.println("String version");
    }

    public void methodOne(StringBuffer s) {
        System.out.println("StringBuffer version");
    }

    
    t.methodOne("arun");//String version
    t.methodOne(new StringBuffer("sai"));//StringBuffer version
    //t.methodOne(null);//CE : reference to m1() is ambiquous  ##########
    //string and stringbuilder both are child of object class
    */

    /*
     * 
     //case 3: public void methodOne(int i) {
     public void methodOneX(int i){
     System.out.println("general method");
     }
 
     public void methodOneX(int... i) {
         System.out.println("var-arg method");
     }
      
     t.methodOneX();//var-arg method
     t.methodOneX(10,20);//var-arg method
     t.methodOneX(10);//general method
     */
    
    //case 4: 
    /*
     * 
     class Animal {
     }
     
     class Monkey extends Animal {
     }
     
     class Test{
         public void methodOne(Animal a) {
             System.out.println("Animal version");
         }
         public void methodOne(Monkey m) {
             System.out.println("Monkey version");
         }
         public static void main(String[] args){
             Test t=new Test();
 
             Animal a=new Animal();
             t.methodOne(a);//Animal version
 
             Monkey m=new Monkey();
             t.methodOne(m);//Monkey version
 
             Animal a1=new Monkey(); // @@@@@@@@@@@@@@@in overloading Method resulation is alway reference type
             t.methodOne(a1);//Animal version
     }
     */
    
    
   /*  
   void m1(String s) {
      System.out.println("String");
   }
   
   void m1(StringBuffer s) {
      System.out.println("StringBuffer ");
   }
   void m1(Object s) {
      System.out.println("Object ");
   }
   
   public static void main(String[] args){
      overloading o = new overloading();
      o.m1("jewel");
      o.m1(new StringBuffer("rana"));
      o.m1(null);          //ambiguous for string and stringBuffer both are child class of object
   
   } */
    
   /* 
   
   
   void m1(int i) {  // for only one int arguments its @@@@ high priority.
   System.out.println("integer");
   }
   void m1(int ... i) {     //accept 0/1/2/3....infinite argument . list priority pabe.....
   System.out.println("integer argument...");
   }
   void m1(String i) {
   System.out.println("String");
   }
   */

    
}
