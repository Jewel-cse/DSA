package inheritance;

public class Employee {
    double salary = 123.9;
    static String name = "jewel";

    static {
        System.out.println("static from employee");
    }
    Employee() {
        System.out.println(salary);
    }

    void display() {
        System.out.println("hello this is ronaldo");
    }
    
    static {
        System.out.println("static last line ");
    }
}
