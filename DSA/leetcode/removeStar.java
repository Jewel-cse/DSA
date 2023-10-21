public class removeStar {
    public static void main(String[] args) {
        String str = "leet**cod*e";
        System.out.println(remove_Stars(str));
    }

    public static String remove_Stars(String s) {
        
        StringBuilder sb = new StringBuilder();

        int len = s.length();
        int counter = 0;
        for (int i = len-1; i >=0; i--) {
            if (s.charAt(i) == '*') {
                counter++;
            }
            else if (counter == 0) {
                sb.append(s.charAt(i));
            }
            else {
                counter--;
            }
        }
        sb.reverse();
        return sb.toString();
    }
}
