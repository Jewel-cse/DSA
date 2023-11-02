package Another;

public class reference {

    /*
     *  (==)check both referencs and values(generally each time create new object but if value range -128 and 127 
        which fall under  jvm chached range it doesnot create new object just copy reference )
        .equal() > check just value of object..
     */
    public static void main(String[] args) {
        Integer one = 100;
        Integer two = 100;
        System.out.println(one == two);
        System.out.println(one.equals(two));
        
        Integer third = 200;
        Integer fourth = 200;
        System.out.println(third == fourth);
        System.out.println(third.equals(fourth));
    }
}
