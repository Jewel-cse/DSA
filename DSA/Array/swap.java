import java.util.ArrayList;
import java.util.List;

public class swap {
    public static void main(String[] args) {
    
        //get(1,2);
        System.out.println(get(2, 7));
    }

    // implementatin of get method
    static List<Integer> get(int a,int b){
        //code
        List<Integer> list = new ArrayList<>();
        list.add(b);
        list.add(a);

        return list;
    }
}
