public class ExelColumnTitle {
    public static void main(String[] args) {
        System.out.println(convertToTitle(28));
    }
    // Number to Title  1 - > A
    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            char c = (char) (columnNumber % 26 + 'A'); ////// 1 theke start korar jonno...
            sb.append(c);
            columnNumber /= 26;
        }
        sb.reverse();
        return sb.toString();
    }
}
