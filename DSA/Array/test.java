import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] arr = new int[(int)1e8+1];
        arr[(int)1e8] = 12312323;
        System.out.println(arr.length);
        System.out.println(arr[(int)1e8]);
        System.out.println("hello world");
    }
}
