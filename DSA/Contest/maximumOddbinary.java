package Contest;

class maximumOddbinary {
    public static void main(String[] args) {
        String s = "010";
        System.out.println(maximumOddBinaryNumber(s));
    }
    public static String maximumOddBinaryNumber(String s) {
       
        int countOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                countOnes++;

            }
        }
        if (countOnes == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.length());
        sb.append(s);
        sb.setCharAt(s.length() - 1, '1');
        
        
         for (int i = 0; i < countOnes - 1; i++) {
             sb.setCharAt(i, '1');
         }
         for (int i = countOnes - 1; i < s.length() - 1; i++) {
             sb.setCharAt(i, '0');
         }
         
        return sb.toString();
    }
}