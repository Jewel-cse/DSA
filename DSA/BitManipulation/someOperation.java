package BitManipulation;

public class someOperation {
    
    //$$$$$$$$$$$$$            check ith bit is set or not
    static boolean isKthBitSet(int n, int k) {
        if ((n & (1 << k)) != 0) {
            return true;
        }
        return false;

    }
    
    // #################check number is odd or even
    public static String oddEven(int N) {
        if ((N & (1 << 0)) == 1) { //0th bit is set or not
            return "odd";
        }
        return "even";
    }
    // ########  Set The Rightmost Unset Bit ,it all 1s then return it
    public static int setBits(int N) {
        int x = N;
        int cnt = 0;

        while (N != 0) {
            if ((x & (1 << cnt)) == 0) {
                x = x | (1 << cnt);
                return x;
            }
            cnt++;
            N = N >> 1;
        }
        return x;
    }
    //some simple operation
    public static int[] bitManipulation(int num, int i){
        int x = 0; //return 0 or non zero
        if((num & (1 << (i - 1))) != 0){
            x = 1;
        }
        int y = num|(1<<(i-1));       //set
        int z = num &(~(1<<(i-1)));
        System.out.println(x+" "+y+" "+z);
        return new int[]{x,y,z};
    }

    public static void main(String[] args) {
        //System.out.println(isKthBitSet(3, 2));
        //System.out.println(setBits(15));
        bitManipulation(11, 2);
    }
}
