public class ExelTitleToNum {
    
    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }
    // AA -> 27
    public static int titleToNumber(String columnTitle) {

        int ans = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            ans  *= 26;
            ans += (int) (columnTitle.charAt(i) - 'A' + 1);
        }
        return ans;
    }
}
