// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums == null || nums.length==0){//edge case
            return 0;
        }
        if(nums.length==1){//if only one value
            return nums[0];
        }
        if(nums.length==2){//if two return the max between them
            return Math.max(nums[0],nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){//you start from 2nd index
            //add current value with 2 values down adn compare with one value down
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[nums.length-1];
    }
}