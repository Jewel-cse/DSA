public class swapTwoNibbles {
    public static void main(String[] args) {
        System.out.println(swapNibbles(100));
    }
    static int swapNibbles(int N) {
        //code here
        int result,left,right;
        right = N & 15;
        left = N & 240;
        right = right <<4;
        left = left >>4;

        result = right + left;
        return result;
    }
}
