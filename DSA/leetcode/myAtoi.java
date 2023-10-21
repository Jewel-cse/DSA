import java.util.Arrays;

public class myAtoi {
    public static void main(String[] args) {
        String str = "  -42";
        
        System.out.println(_myAtoi(str));
       // System.out.println(Integer.parseInt(str));
    }

    public static int _myAtoi(String s) {
        char[] str = s.toCharArray();
        System.out.println();
        int i = 0;
        while(i<str.length && str[i] == ' ')
            i++;
        if (i >= str.length)
            return 0;

        int sign = 1;
        if (str[i] == '+' || str[i] == '-') {
            sign = str[i] == '+' ? 1 : -1;
            i++;
        }
        int num = 0;
        for (; i < str.length && str[i] >= '0' && str[i] <= '9'; i++) {
            if (num > Integer.MAX_VALUE / 10
                    || (num == Integer.MAX_VALUE / 10 && (str[i] - '0') < Integer.MAX_VALUE % 10))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            num = num * 10 + str[i]-'0';
            //System.out.println(str[i]);
        }
        return num * sign;
    }

}
