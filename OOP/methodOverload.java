public class methodOverload {
   
        public void print(Integer i) {
            System.out.println("Integer");
        }
    
        public void print(int i) {
            System.out.println("int");
        }
    
        public void print(long i) {
            System.out.println("long");
        }
        public void print(float i) {
            System.out.println("float");
        }
        public void print(double i) {
            System.out.println("double");
        }
    
        public static void main(String args[]) {
            methodOverload m = new methodOverload();
            m.print(10);   //JVM matches in the following order: int, long, Integer, int....
        }
    
}
