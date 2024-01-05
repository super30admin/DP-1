// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        
        
        int prev = 0, prevprev = 0;
        
        for(int i = 0; i < nums.length; i++){
            
            int max = Math.max(nums[i]+prevprev, prev);
            prevprev = prev;
            prev = max;
            
        }
        
        return prev;
    }
}
