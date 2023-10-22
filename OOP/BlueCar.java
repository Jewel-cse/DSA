public class BlueCar extends Car {
   
    {
        System.out.print("4");
    }

    public BlueCar() {
        super("blue");  //supar class constructor Car 2
        System.out.print("5");
    }

    public static void main(String[] gears) {
        new BlueCar(); //call constructor>1
    }
    
}
