public class missingNumber{
    public static void main(String[] args) {
        int[] nums = { 0, 2, 3, 4, 6, 5 };
        System.out.println("missing nums : "+ missigNum(nums));
    }

    public static int missigNum(int[] num){
        int n = num.length;
        int totalSum = n*(n+1)/2;
        int sum =0;
        for (int i = 0; i < num.length; i++) {
           sum += num[i]; 
        }
        return totalSum - sum;
    }
}