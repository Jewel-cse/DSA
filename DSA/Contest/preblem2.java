package Contest;
import java.util.Scanner;

public class preblem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            int aa = Math.abs(b - c) % 2 == 0 ? 1 : 0;
            int bb = Math.abs(a - c) % 2 == 0 ? 1 : 0;
            int cc = Math.abs(b - a) % 2 == 0 ? 1 : 0;

            System.out.println(aa + " " + bb + " " + cc);
        }
        scanner.close();
    }
}
