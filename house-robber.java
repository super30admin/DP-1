// Time Complexity : O(n) (DP) where, n=number of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :  Yes
// Any problem you faced while coding this : No 

// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        
        if(nums.length == 0){
            return 0;
        }
        // Using two variables
        int skip = 0;
        int take = nums[0];
        int skip_copy=0;
        
        //Logic 
        for(int i=1; i<nums.length;i++){
            skip_copy = skip;
            skip = Math.max(skip_copy, take);
            take = skip_copy + nums[i];
            
        }
        int max_num = Math.max(skip,take);
        return max_num;
    }
}