// Time Complexity : O(n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : yes 

class Solution {
    public int rob(int[] nums) {
        
        
        int leave =0; 
        int take = nums[0];
        
        for(int i=1; i< nums.length; i++){
            
            int prevLeave = leave;
            
            leave = Math.max(prevLeave, take);
            take = nums[i] + prevLeave;
            
        }
        
        return Math.max(leave, take);
        
    }
}