// Time Complexity :O(n) n is length of nums 
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


//Using Dynamic Programming without array

class Solution {
    public int rob(int[] nums) {
        int prev=0,res=0;
        for(int i=0;i<nums.length;i++){
            int temp=res;
            res=Math.max(res, prev+nums[i]);
            prev=temp;
        }
        return res;
    }
} 
