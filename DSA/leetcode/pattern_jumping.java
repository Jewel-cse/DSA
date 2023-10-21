/*
 * To Say in Simple- Problem is to find whether given input(n) is power of 2 or not. 
 * pattern for the given problem is 2^0,2^1,2^2,2^3,2^4,....

Problem Statement in simple words: frog has to jump to nth leaf where n is distance from start.
for example, if frog is at 2nd leaf from start it can jump only 2 units forward. which is indirectly 2power.
 */

public class pattern_jumping {
    public static void main(String[] args) {
        long n = 32;
        System.out.println(canJump(n));
    }
    static String canJump(Long N) {
        // code here
        long temp = N+(N-1);
        long temp2 = N | (N-1);
        if(temp==temp2)
            return "True";
        else
            return "False";
        }
}
