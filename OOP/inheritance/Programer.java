package inheritance;

public class Programer extends Employee {
     String versityName = "RU";

     void showName() {

         System.out.println(salary);
     }

    Programer() {
        super();
    }

    public static void main(String[] args) {
        //static block ase employee te 1
        System.out.println(name);   //2
        new Programer();            //3 super run
        System.out.println(name);  //4
    }

    /*
     * extends jake kora hobe tar kono static block thkale 
     * fist exeucute hobe > class load korar somoi
     * then 
     */
}
