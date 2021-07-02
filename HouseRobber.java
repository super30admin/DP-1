// Problem 2: House Robber

// Time Complexity: O(n)
// Space Complxity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach used: Dynamic programming
class Solution {
    public int rob(int[] nums) {
    //Check if the nums array is empty, if so return 0
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n=nums.length;
        int cost[]=new int[n+1];
        cost[0]=0;
        cost[1]=nums[0];
        for(int i=1;i<n;i++)
        {
            cost[i+1]=Math.max(cost[i],cost[i-1]+nums[i]);
        }
        return cost[n];
    }
}