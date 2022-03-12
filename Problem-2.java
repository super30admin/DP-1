// Time Complexity : O(N) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    
    public int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        
        
        int pastPrev = nums[0];
        int prev = Math.max(nums[0],nums[1]);
        
        for(int i=2;i<nums.length;i++){
            int curr = Math.max(nums[i]+pastPrev,prev);
            pastPrev=prev;
            prev=curr;
        }
        
        return prev;
    }
}

