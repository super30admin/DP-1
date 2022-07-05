// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int rob(int[] nums) {
        
        int dontRobb = 0;
        int robb = nums[0]; 
        for(int i=1;i<nums.length;i++){
            int prevDontRobb = dontRobb;
            dontRobb = Math.max(dontRobb,robb);
            robb = prevDontRobb + nums[i];
        }
        return Math.max(dontRobb,robb);
    }
}