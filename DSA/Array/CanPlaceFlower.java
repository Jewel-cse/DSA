import java.util.Arrays;

public class CanPlaceFlower {

    //Apprach 1: TC> O(n)+o(n)   SP: O(n)
    //is flower can be place 0 1 0  format of each flower 1: 
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        //add 0 at front and  back of new array
        boolean[] arr = new boolean[len + 2];
        for (int i = 1; i < arr.length - 1; i++) {
            if (flowerbed[i - 1] == 1)
                arr[i] = true;
        }
        //System.out.println(Arrays.toString(arr));
        for (int i = 1; i < arr.length - 1; i++) {
            if (!arr[i - 1] && !arr[i] && !arr[i + 1]) {
                arr[i] = true;
                n -= 1;
            }
        }
        return n <= 0;
    }
    //aproach 2: 
    public static boolean canPlaceFlowers_optimal(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean isEmptyLeftBed = (i == 0) || (flowerbed[i - 1] == 0);
                boolean isEmptyRightBed = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);

                if (isEmptyLeftBed && isEmptyRightBed) {
                    flowerbed[i] = 1;
                    count++;
                }
                if (count >= n)
                    return true;
            }
        }
        return count>=n;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,0,1};
        System.out.println(canPlaceFlowers(flowerbed, 2));
        System.out.println(canPlaceFlowers_optimal(flowerbed, 2));
    }
    
}
