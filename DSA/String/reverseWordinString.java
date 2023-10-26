package String;
import java.util.Scanner;

public class reverseWordinString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(reverseWords(s));

        in.close();
    }

    //idea: stack use kore
    /*
     aproach: 1
    public static String reverseWords(String s) {
 
        String[] str = s.trim().split("\\s+");
        String out = "";
        for (int i = str.length - 1; i > 0; i--) {
            out += str[i] + " ";
        }
        out += str[0];
        return out;
    }
    */
    // aproach 2 : more faster.... + memory saver.
   public static String reverseWords(String s) {
    String[] arr=s.trim().split("\\s+");

    StringBuilder sb=new StringBuilder();
    for(int i=arr.length-1;i>0;i--){
        sb.append(arr[i]);
        sb.append(" ");
    }
    sb.append(arr[0]);
    return sb.toString();
}
    
}
