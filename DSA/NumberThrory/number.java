package NumberThrory;


public class number {
    
    //find sum of each digit using reursion @@@@ 
    private static int sumDigit(int n) {
        if (n == 0)
            return n;

        return n % 10 + sumDigit(n / 10);
    }
    
    //@@@@@@ Armstrong :  sum of (digit) ^number of total digit 
    private static boolean Armstrong(int n) {
        //find number of digit
        int cnt = (int) Math.log10(n) + 1;

        //sum of digit ^cnt
        int num = n;
        int temp = 0;
        while (n > 0) {
            temp += Math.pow(n % 10, cnt);
            n /= 10;
        }
        //check 
        return temp == num;
    }

    //@@@@@@@ Happy number @@@@@@@@@@@@
    public static boolean isHappy(int n) {
        int slow = n, fast = n;
        do{
            slow = getSqSum(slow);
            fast = getSqSum(getSqSum(fast));
            System.out.println(slow);
        }while(slow != fast);
        
        return slow == 1;
    }
    private static int getSqSum(int n){
        int sum = 0;
        while(n>0){
            int d = n%10;
            sum +=d*d;
            n /=10;
        }
        return sum;
    }
    
    ////@@@@@@@@ Binary to decimal
    private static int binaryToDecimal(int b) {
        if (b == 0 || b == 1)
            return b;
        int decimal = 0;
        int base = 2;
        int p = 0;
        while (b > 0) {
            int digit = b % 10;
            if (digit == 1)
                decimal += Math.pow(base, p);
            p++;
            b /= 10;
        }
        return decimal;
    }

    //Bubble sort : o(n^2)
    private static void bubble(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    //swap
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
    
    //insertion sort: o(n^2)
    private static void insertionSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            int value  = nums[i];
            while (j >= 0 && nums[j] > value) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] ans = { -121,1,121,23132,1,31,31,3,13,-11111111};
        //System.out.println(sumDigit(7667677));
        //System.out.println(Armstrong(443));
        //System.out.println(binaryToDecimal(00000));
        //bubble(ans);
        //insertionSort(ans);
        //System.out.println(Arrays.toString(ans));
        //System.out.println(isHappy(19));
        System.out.println(getSqSum(19));
    }
}
