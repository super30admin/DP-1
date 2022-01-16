//Time complexity: O(n)
//Space complexity: O(1) -- using skip and take
//single constraint problem i.e house
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        
        if(nums == null) return 0; //null check
        
        int skip = 0;
        int take =  nums[0];
        for(int i=1; i< nums.length; i++){
            int temp = skip; //temp variable to store previous skip 
            
            //skip (0)
            skip = Math.max(skip, take);
            
            //take (1)
            take = nums[i] + temp;
        }
        
        return Math.max(skip, take); //max value from last index
        
    }
}