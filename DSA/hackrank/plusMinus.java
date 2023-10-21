package hackrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class plusMinus {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        List<Integer> arr = new ArrayList<>(n);
        //input
        for (int i = 0; i < n; i++) {
            arr.add(in.nextInt());
        }
        ratio(arr);
        in.close();
    }
    static void ratio(List<Integer> arr){
        int N = arr.size();
        
        //count +,-,0
        int pos=0,neg=0,zero=0;
        for (int i =0 ;i< N;i++) {
            if (arr.get(i)>0) {
                pos++;
            }
            else if(arr.get(i)<0){
                neg++;
            }
            else
                zero++;
        }
        
        System.out.println(String.format("%.6f", (float)pos/N)); 
        System.out.println(String.format("%.6f", (float)neg/N));
        System.out.println(String.format("%.6f", (float)zero/N));
        
        
    }

}
