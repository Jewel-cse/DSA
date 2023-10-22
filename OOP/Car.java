public abstract class Car {
    
        static {
            System.out.print("1");
        }
    
        public Car(String name) {     // first initialization  block executed then constructor
            //super();
            System.out.print("2");
        }
    
        {
            System.out.print("3");
        }
    
}
