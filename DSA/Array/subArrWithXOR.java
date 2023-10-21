import java.util.HashMap;

public class subArrWithXOR {
    public static void main(String[] args) {
        System.out.println(subArrayWithGivenXOR(new int[] { 4, 2, 2, 6, 4 }, 6));
    }

    //brute force : n^2, 
    public static int subArrayWithGivenXOR(int[] nums, int B) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            int xor = 0;
            for (int j = i; j < len; j++) {
                xor ^= nums[j]; //xor same element always 0.
                if (xor == B) {
                    count++;
                }
            }
        }
        return count;
    }
    
    //the most optimal solution: prefix xor,count
    public static int subarraysWithSumK(int[] nums, int k) {
        // map with xrvalue, count
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int xr = 0;
        map.put(xr,1);

        for (int i = 0; i < nums.length; i++) {
            xr ^= nums[i];       //front 
            //k
            int x = xr^k;         //check back  
            if(map.containsKey(x))
                count +=  map.get(x);     // back thakle count
            
            if(map.containsKey(xr))        // front thakle front freq++
                map.put(xr,map.getOrDefault(xr,0)+1);
            else                           // konotai na thakle add to map with count 1
                map.put(xr,1);
            
        }
        return count;
    }
}
