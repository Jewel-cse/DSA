public class InfiniteMath extends ComplexMath {
        public final double secret = 8;
    
        public static void main(String[] numbers) {
            Math math = new InfiniteMath();    //Java allows methods to be overridden, but not variables-(Type Math)
            System.out.print(math.secret);
        }
}
