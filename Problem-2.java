// Time Complexity :O(1) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int C = 0;
        int DC = 0;
        
        for(int x : nums){
            int temp = DC;
            DC = Math.max(C,DC);
            C=x+temp;
        }
        return Math.max(C,DC);
    }
}