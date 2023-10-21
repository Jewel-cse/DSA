/**
 * perfectnumber : for low run time ,2 index niyechi left and right
 */
public class perfectnumber {
    public static void main(String[] args) {
        System.out.println(isPerfectNumber(33550336));
        //isPerfectNumber(10);
    }
    static int isPerfectNumber(long N) {
        // code here
        long sum = 1;
        long i = 2,j = N;
        while(i<j){
            if(N%i == 0){
                j = N/i;
                sum = sum+i+j;
            }
            i = i+1;
        }
        if (N>1 && sum == N) {
            //System.out.println("perfect");
            return (int)1;
        }
        else{
            //System.out.println("not");
            return (int) 0;
        }     
    }
    
}