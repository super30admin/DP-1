// Time Complexity : O(n), n = no of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Time to think through the logic.


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        
        // choose a house to rob
        // or don't choose
        int C = 0, DC = 0;
        
        // Either we choose a house or we don't
        // When we choose we try to store the 
        // value of robbery
        // When we don't choose we pick
        // the maximum possible value
        for(int i = 0; i < nums.length; i++) {
            
            int temp = DC;
            DC = Math.max(C, DC);
            C = temp + nums[i];
        }
        
        return Math.max(C, DC);
    }
}