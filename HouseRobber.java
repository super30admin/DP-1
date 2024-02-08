// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int rob(int[] nums) {

        // if length is less than 2, there is only one house in the array and return the money in the house.
        if(nums.length<2){
            return nums[0];
        }

        // create a new dp array to memoize. store the values at each step.
        int [] dp = new int[nums.length];
        // initialize the first with the value in first house
        dp[0] = nums[0];
        //second will be the the max of first two numbers, which ever is has the highest loot. 
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i=2; i<nums.length;i++){
            // core logic
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        //return the last element in the array which has the max loot amount. 
        return dp[nums.length -1];
    }
}