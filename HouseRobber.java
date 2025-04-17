// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach:
// Dynamic Programming using two variables, considering cases of choosing or not choosing current house,
// for maximum amount of money. Adding current house amount to prev maximum amount and returning it.


class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int prev=nums[0];
        if(n==1) return prev;
        int curr=Math.max(prev,nums[1]+0);
        for(int i=2;i<n;i++){
            int temp=curr;
            curr=Math.max(curr,prev+nums[i]);
            prev=temp;
        }
        return curr;
    }
}