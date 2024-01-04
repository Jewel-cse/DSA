import java.util.Arrays;

/*
 * following operation can be done
 * : bild segment tree   : o(n)
 * : get sum of given range : o(logn)
 * : update the value of given index :o(logn)
 */
public class NumArray {
    static int[] nums;
    static int[] seg;

    public NumArray(int[] num) {
        nums = num;
        seg = new int[num.length * 4];
        buildseg(0, 0, num.length - 1);
        System.out.println(Arrays.toString(seg));

    }

    // ind = 0, left = 0, right = nums.length-1;
    private static void buildseg(int ind, int left, int right) {
        if (left == right) {
            seg[ind] = nums[left];
            return;
        }
        int mid = (left + right) / 2;
        buildseg(2 * ind + 1, left, mid);
        buildseg(2 * ind + 2, mid + 1, right);
        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
    }

    private static int getSum(int ind, int nql, int nqh, int left, int right) {
        if (nql >= left && nqh <= right)
            return seg[ind];
        else if (nql > right || nqh < left)
            return 0;

        int mid = (nql + nqh) / 2;
        int l = getSum(2 * ind + 1, nql, mid, left, right);
        int r = getSum(2 * ind + 2, mid + 1, nqh, left, right);

        return l + r;
    }

    private static void updateSeg(int ind, int l, int r, int index, int val) {
        if (l == r) {
            seg[ind] = val;
            return;
        } else {
            int mid = (l + r) / 2;
            if (index >= l && index <= mid)
                updateSeg(2 * ind + 1, l, mid, index, val);
            else
                updateSeg(2 * ind + 2, mid + 1, r, index, val);
            seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
        }
    }

    public void update(int index, int val) {
        updateSeg(0, 0, nums.length - 1, index, val);
    }

    public int sumRange(int left, int right) {
        return getSum(0, 0, nums.length - 1, left, right);
    }

    public static void main(String[] args) {
        NumArray obj = new NumArray(new int[]{1,2,3});
        int param_2 = obj.sumRange(0,2);
        obj.update(2,10);
        int param_3 = obj.sumRange(0, 2);
        
        System.out.println(param_2 + "  "+param_3);
    }
}
