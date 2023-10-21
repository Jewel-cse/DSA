import java.util.ArrayList;
import java.util.List;

public class pascalsTriangle {
    public static void main(String[] args) {
        System.out.println(generate(10));
        //System.out.println(ncr(10, 3));
    }

    public static List<List<Integer>> generate(int numRows) {
        //2D list creation.......
        List<List<Integer>> result = new ArrayList<List<Integer>>(numRows);
        for (int i = 0; i < numRows; i++) {
            result.add(new ArrayList<Integer>());
        }
        //calculation
        for(int i = 1;i<=numRows;i++) {// how many rows
            
            for(int k = 1;k<=i;k++){
                result.get(i-1).add(ncr(i-1,k-1));
            }
        }
        return result;
    }

    static int ncr(int n, int k) {
        int result = 1;
    
        for (int i = 0; i <k; i++) {
            result= result*(n-i);
            result = result/(i+1);

        }
        return result;
    }
}
