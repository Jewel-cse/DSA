package BitManipulation;


public class twoNumberappearOdd {
    public static void main(String[] args) {
        

        int[] num = { 1,1, 2, 2,3, 3, 123,5,7,7,8,8,9,9,11,12,11,12,22,22,122,122 };
        //System.out.println(twoOddNum(num));
        twoOddNum(num);
    }

    public static void twoOddNum(int[] arr) {
        int xor = 0;

        //all xor
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        //find index of right most set bit
        int index = 0;
        int temp = xor;
        while (temp > 0) {
            if ((temp & (1<<0)) == 1)
                break;
            temp = temp >> 1;
            index++;
        }
        //System.out.println(xor + "  " + index);
        //create two array and group by ith index o an 1;
        int[] num1 = new int[arr.length];
        int m = 0;
        int[] num2 = new int[arr.length];
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & (1 << index)) == 0) {
                num1[m++] = arr[i];
            }
            else {
                num2[n++] = arr[i];
            }
        }
        //System.out.println(Arrays.toString(num1) );
        //System.out.println(Arrays.toString(num2) );

        //now find individaul  sigle
        int xr1 = 0;
        int xr2 = 0;
        for (int i = 0; i < num2.length; i++) {
            xr1 ^= num1[i];
            xr2 ^= num2[i]; 
        }
        System.out.println(xr1+"  "+xr2);
    }
}
