public class medianOfToSortedArr {
    public static void main(String[] args) {
        int[] ar1 = { 1, 2 };
        int[] ar2 = { 3,4};
        System.out.println(findMedianSortedArrays(ar1, ar2));
    }
    
    
    
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int m = nums2.length;
        int[] temp = new int[n + m];

        int left = 0;
        int right = 0;
        int index = 0;
        while (left < n && right < m) {
            if (nums1[left] <= nums2[right]) {
                temp[index++] = nums1[left];
                left++;
            } else {
                temp[index++] = nums2[right];
                right++;
            }
        }
        while (left < n) {
            temp[index++] = nums1[left];
            left++;
        }

        while (right < m) {
            temp[index++] = nums2[right];
            right++;
        }

        //calculate median
        int pos = (n + m) / 2;
        if ((n + m) % 2 == 0) {
            return (double)(temp[pos-1] + temp[pos])/2;
        } else {
            return (double)temp[pos];
        }

    }
}
