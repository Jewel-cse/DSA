public class tripletSum {
    public static void main(String[] args) {
        int[] A = {1,4,45,6,10,8};
        System.out.println(find3Numbers(A,6,13));
    }
    public static boolean find3Numbers(int A[], int n, int X) { 
    
        // Your code Here
        for (int i = 0; i < n; i++) {
            for(int k= 0;k<n;k++){
                for (int j = 0; j < n; j++) {
                    if(i!=j && j!=k && i!= k){
                        if(A[i]+A[j]+A[k] == X)
                        return true;
                    }
                }
            }
        }
        return false;
     }
}
