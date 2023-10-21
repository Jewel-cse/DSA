public class moveAllzerolast {
        public static void main(String[] args) {
            int[] arr = {3,5,0,0,4};
            pushZerosToEnd(arr, 5);
    
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+" ");
            }
        }
        static void pushZerosToEnd(int[] arr, int n) {
            int[] temp = new int[n];
            int index = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i] != 0){
                    temp[index++] = arr[i];
                    
                }
            }
            for (int i = 0; i < n; i++) {
                arr[i] = temp[i];
            }
    }
    
}
    
