import java.util.Arrays;

/**
 * segmentTree
 */
public class segmentTree {
    private static int[] seg;
    
    
    private static void buildSegmentTree(int ind, int left, int right, int[] arr) {
        if (left == right) {
            seg[ind] = arr[left];
            return;
        }
        int mid = (left + right) / 2;
        buildSegmentTree(2 * ind + 1, left, mid, arr);
        buildSegmentTree(2 * ind + 2, mid + 1, right, arr);
        seg[ind] = Math.max(seg[2 * ind + 1], seg[2 * ind + 2]);
    }
    //start from root ind 0, new querylow 0,new query high n-1 for initial and given query
    //each time update ind and new querylow and high
    private static int query(int ind,int newQueryLow,int newQueryHigh, int QueyLow,int QueyHigh){
        //completly lies
        if(newQueryLow>=QueyLow && newQueryHigh <= QueyHigh)    return seg[ind];
        //not lies
        else if(newQueryLow>QueyHigh|| newQueryHigh <QueyLow)   return Integer.MIN_VALUE;
        
        //overlaps
        int mid = (newQueryLow + newQueryHigh)/2;
        int left = query(2*ind+1,newQueryLow,mid,QueyLow,QueyHigh);
        int right = query(2 * ind + 2, mid + 1, newQueryHigh, QueyLow, QueyHigh);
        
        return Math.max(left, right);
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4,5 };
        int n = arr.length;
        seg = new int[4 * n];
        //build segment tree
        buildSegmentTree(0, 0, n - 1, arr);
        System.out.println(Arrays.toString(seg));
        //query 
        //System.out.println(query(0, 0, n-1, 2, 7));
    }
}