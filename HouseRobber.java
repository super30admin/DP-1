// Time Complexity : O(n) where n is the number of houses
// Space Complexity : O(1) constant space
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//Dynamic Programming using no additional space
//SC: O(1) TC: O(n) where n is the number of houses
class HouseRobber{
    public int rob(int[] nums){

        //null check
        if(nums == null || nums.length == 0)
            return 0;

        int n = nums.length;

        if(n == 1)
            return nums[0];

        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);

        for(int i = 2 ; i < n ; i++ ){
            int temp = curr;
            curr = Math.max(curr, nums[i] + prev);
            prev = temp;
        }
        return curr;
    }
}

/*
//Dynamic Programming Approach
//SC: O(n) using an additional 1-D array TC: O(n) where n is the number of houses
class Solution{
    public int rob(int[] nums){

        //null check
        if(nums == null || nums.length == 0)
            return 0;

        int n= nums.length;
        int[] dp = new int[n];

        if(n==1)
            return nums[0];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i=2 ; i < n ; i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }

        return dp[n-1];
    }
}
*/




/* This is recursive method TC: 2^n where n is number of possibilities in the diagram. This gives Time Limit Exceeded in LC, so we go with DP approach.

// Exhaustive Approach
class Solution {
    public int rob(int[] nums) {

        //null check
        if(nums == null || nums.length == 0)
            return 0;
        return helper(nums,0,0);
    }

    private int helper(int[] nums, int idx, int amount){

        //base case
        if(idx >= nums.length)
            return amount;

        //logic case
        //choose case idx+2 because we can't rob idx+1 if idx is robbed
        int case1 = helper(nums, idx+2 , amount + nums[idx]);

        //not-choose case
        int case0 = helper(nums, idx+1 , amount);

        return Math.max(case0,case1);
    }
}

*/