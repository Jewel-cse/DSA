package String;

public class largeString {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("we make devs");

        String str = sb.toString();
        System.out.println(str);
    }
}
