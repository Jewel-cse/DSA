public class setBits {
    public static void main(String[] args) {
        System.out.println(countsetBits(8));
        
    }
    static int countsetBits(int N) {
        // code here
        int count = 0;
        while(N>0){
            if(N%2 == 1){
                count += 1;
            }
            N = N/2;
        }
        return count;
    }
}
