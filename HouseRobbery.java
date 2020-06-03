// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : Yes, Had to check explanations on youtube before coding it myself.


// Your code here along with comments explaining your approach


class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length ==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<dp.length;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[dp.length-1];
    }
}