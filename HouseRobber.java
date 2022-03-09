//This problem was asked at Amazon
//        You are a robber planning to rob houses along a street. Each house has a given amount of money, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//        Determine the maximum amount of money you can rob tonight without alerting the police.
//
//        Example 1:
//        Input: [1,2,3,1]        Output: 4
//        Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).

//LeetCode: 198
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
//A bit in logical thinking or understanding Dynamic Programming
// Your code here along with comments explaining your approach
//Used Dynamic Programming. Took a dp array of nums length + 1. Stored data in first two places in dp array and wrote the logic

class Solution {
    public int rob(int[] nums) {

        //edge
        if(nums==null||nums.length==0)
            return 0;

        if(nums.length==1)
            return nums[0];

        if(nums.length==2)
            return Math.max(nums[0],nums[1]);

        int dp[] = new int[nums.length+1];
        dp[0]= 0;
        dp[1]= nums[0];

        for(int i=1; i<nums.length;i++){
            dp[i+1]= Math.max(dp[i], dp[i-1]+nums[i]);
        }

        return dp[nums.length];
    }
}
