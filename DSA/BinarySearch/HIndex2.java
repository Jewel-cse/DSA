package BinarySearch;

public class HIndex2 {
    // TC : O(n)
    public static int hIndex(int[] citations) {
        //hIndex = max(i : f(i)>=i)
        int max = 0;
        int backIndex = 1;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] >= backIndex) {
                max = backIndex;
                backIndex++;
            }
        }
        return max;
    }
    
    ///@@@@@@@ Log(n)
    public static int hIndex_binarySearch(int[] citations) {
        int lo = 0, hi = citations.length-1;
        int hIndex = 0;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int greaterOrEqual = citations.length - mid;
            int citationCount = citations[mid];
            hIndex = Math.max(hIndex, Math.min(greaterOrEqual, citationCount));
            if(citationCount > greaterOrEqual) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return hIndex;
    }

    public static void main(String[] args) {
        int[] citations = { 0 };
        System.out.println(hIndex(citations));
    }
    
}
