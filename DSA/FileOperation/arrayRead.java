package FileOperation;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class arrayRead {
    public static void main(String[] args) {
        try {
            //file open
            Scanner sc = new Scanner(new File("DSA\\FileOperation\\inputAr.txt"));
            //read file and store into ls
            List<Integer> ls = new ArrayList<>();
            while (sc.hasNextInt()) {
                ls.add(sc.nextInt());
            }
            sc.close();
            //calculate sum
            int sum = 0;
            int mul = 1;
            for (Integer v : ls) {
                sum += v;
                mul *= v;
            }
            //now write ans to output file,,,,,
            PrintWriter w = new PrintWriter(new FileWriter("DSA\\FileOperation\\Output.txt"));
            w.println("sum of the array : " + sum);
            w.println("multiplication of the element  : "+mul);
            w.close();

            System.out.println("output write done !!!!!!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
