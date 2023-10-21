public class countDivisible {
    public static void main(String[] args) {
        System.out.println(countDivisibles(25, 100, 30));
    }
    static int countDivisibles(int A, int B, int M){
        // code here
        int count = 0;
        for (int i = A; i <= B; i++) {
            if(i%M==0)
                count++;
        }
        return count;
    }
}
