// Time Complexity : O(2^N) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public int rob(int[] nums) {
        
        return helper(nums,0,0);
    }
    private int helper(int[] nums, int index, int sum){
        if(index >= nums.length) return sum;
        int case1 = helper(nums,index+2,sum+nums[index]);
        int case2 = helper(nums, index+1,sum);
        return Math.max(case1, case2);
    }
}