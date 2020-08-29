//Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        
        int choose=0;
        int dontChoose=0;
        
        for(int i=0;i<nums.length;i++){
            int temp=dontChoose;
            dontChoose=Math.max(choose,dontChoose);
            choose= temp+ nums[i];
        }
        
        return Math.max(choose,dontChoose);
        
    }
}