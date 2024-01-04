import java.util.Arrays;

public class rangeSumQuery {
    private static int[] nums;
    private static int[] seg;

    public rangeSumQuery(int[] num) {
        nums = num;
        seg = new int[4 * num.length];
        //nums = new int[num.length];
        //System.arraycopy(num, 0, nums, 0, num.length);
    }

    //build segment tree for sum range
    private static void buildSegTree(int ind, int left, int right) {
        if (left == right) {
            seg[ind] = nums[left];
            return;
        }
        int mid = (left + right) / 2;
        buildSegTree(2 * ind + 1, left, mid);
        buildSegTree(2 * ind + 2, mid + 1, right);

        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
    }
    //query for the sum of given sum
    private static int query(int ind, int nql, int nqh, int ql, int qh) {
        //completely lies
        //not lies
        if (nql >= ql && nqh <= qh)
            return seg[ind];
        else if (nql > qh || nqh < ql)
            return 0;
        int mid = (nql + nqh) / 2;
        int left = query(2 * ind + 1, nql, mid, ql, qh);
        int right = query(2 * ind + 2, mid + 1, nqh, ql, qh);
        
        return left + right;
    }
    
    public int sumRange(int left, int right) {
        //System.out.println(Arrays.toString(nums));
        buildSegTree(0, 0, nums.length-1);
        return query(0,0,nums.length-1,left,right);
    }
    public static void main(String[] args) {
        rangeSumQuery r = new rangeSumQuery(new int[] { 1, 2, 3,4,5,6});
        System.out.println(r.sumRange(3, 4));
    }
}
