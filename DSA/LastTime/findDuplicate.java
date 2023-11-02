package LastTime;

public class findDuplicate {

    /*
     * Problem Statement: 
     * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
        There is only one repeated number in nums, return this repeated number.
    
        @@@@@@@ the way of solve this problem............
        0: use two loop  : TC O(n^2)
        1: sort then compare adjacent : complexity: nlogn+n, space O(1), but array is modified(X)
        2: take a boolean array of size n, then make true of nums[i] index of boolean array if not true of this array,
             if already true then return bool index ,TC O(n),SC: O(n)
        3: use hashset  : if not contains then put into hashset, else return  tc(n),sc(n)
        4:floyds tortoise and hare algorithm, Two pointer,,,,,,,(slow and fast)
                slow and first : start from nums[0], 
                    slow = nums[slow], fast = nums[fast],fast = nums[fast]   > when slow == fast
                    then fast  start from begining 
                    then start 1 step
     */

    //no extra space , not modify array

    
    public int findDuplicate_brute(int[] nums) {

        //time limit exceed
        int n = nums.length;        
        for(int i = 0;i<n;i++){
            for( int j = i+1;j<n;j++){
                if(nums[i] == nums[j])
                    return nums[i];
            }
        }
        return -1;
    }
    
    
    //using boolean array
    public int findDuplicate_bool(int[] nums) {
        
        boolean[] a = new boolean[nums.length];
    
            for(int i=0; i<nums.length; i++) {
                if(a[nums[i] - 1]) 
                    return nums[i];
                a[nums[i] - 1] = true;
            }
            return 0;
    }
    



    
    //making visited values within array
    public int findDuplicate_visited(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index] < 0)
                return index;
            nums[index] = -nums[index];
        }
        return n; // this line is not execute ,cz duplicate thakbei 
    }
    
    //The most optimal solution : Tc(n),sc(1)
    //floyd's tortoise and hare method
    //two pointer............
    public int findDuplicate_2Pointer(int[] nums){
        
        int slow  = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[fast]; // fast 2 step
            fast = nums[fast];
        }while(slow!=fast);    

        fast = nums[0];
        while(fast!=slow){
            slow = nums[slow];  //both 1 step
            fast = nums[fast];
        }
        return slow;      //slow and first same this point
    }

}
