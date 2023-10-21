public class reversInteger {
    public static void main(String[] args) {
        int x = -2147483647;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        sb.append(Math.abs(x));
        sb.reverse();

        if (sb.length() >= 10) {
            int p1 = Integer.parseInt(sb.substring(0, 5));
            int p2 = Integer.parseInt(sb.substring(5, 10));

            if (p1 > 21474 || p2 > 83647)
                return 0;
        }
        int ans = Integer.parseInt(sb.toString());

        return (x < 0) ? -ans : ans;
    
    
    }
}
