package hackrank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class reversArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int n = 5;
        for (int i = 0; i < n; i++) {
            arr.add(in.nextInt());
        }
        System.out.println(reverseArray(arr));
        in.close();
    }
    public static List<Integer> reverseArray(List<Integer> a) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        for (int index = a.size()-1; index >=0; index--) {
            arr.add(a.get(index));
        }
        return arr;
    }
}
