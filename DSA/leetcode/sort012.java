
//that takes an array arr and N as input parameters and sorts the array in-place.


public class sort012 {
    public static void main(String[] args) {
        int[] arr = {0,1,1,1,2,1,2,1,0};
        sort_012(arr,arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static void sort_012(int[] arr,int n){
        int count0 = 0,count1 = 0,count2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0)
                count0++;
            else if(arr[i]==1)
                count1++;
            else if(arr[i]==2)
                count2++;
        }
        int index = 0;
        for (int i = 0; i < count0; i++) {
            arr[index++] = 0;
        }
        for (int i = 0; i < count1; i++) {
            arr[index++] = 1;
        }
        for (int i = 0; i < count2; i++) {
            arr[index++] = 2;
        }
    }
}
