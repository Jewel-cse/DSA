package Contest;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class rigged {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] a = new int[100];
        int[] b = new int[100];

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        while (t > 0) {
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                
            }
            for (int i = 0; i < n; i++) {

                b[i] = in.nextInt();
            }
            if (Arrays.equals(a, b)) {
                System.out.println(-1);
                continue;
            }
            //calculate max of b
        
            
            for (int i = 1; i < b.length; i++) {
                if (b[i] > a[0]) {
                    map.put(a[i], b[i]);
                }
            }
            //
            int max = Collections.max(map.keySet());
           
            
            if (a[0] >= max+1) {
                System.out.println(max+1);
            }
            else {
                System.out.println(-1);
            }
            //System.out.println(a[index]);

            t--;
        }
    }

