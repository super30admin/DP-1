// https://leetcode.com/problems/house-robber/
// Time Complexity : DP - O(N), where N is the number of houses
// Space Complexity : DP - O(N), where N is the number of houses
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



class Solution {

    // 1. Recursive exhaustive solution
    private int helper(int[] nums, int idx, int amountRobbed){
        //Base
        if(idx>=nums.length)    return amountRobbed;

        // At each house, two choices, skip or rob the current house
        // Rob the current house, then skip two houses
        int case1 = helper(nums, idx+2, amountRobbed+nums[idx]);

        // Skip current house
        int case2 = helper(nums, idx+1, amountRobbed);

        // Return the max amount robbed
        return Math.max(case1, case2);
    }

    // 2. DP solution of the above exhaustive solution
    private int dp(int[] nums){
        int m=nums.length;

        int[] storage=new int[m+1];

        // Base case, given no house, max amount stolen can be 0
        storage[0]=0;

        // When only one house, we rob that
        storage[1]=nums[0];

        // Filling up dp
        for(int i=2;i<=m;i++){
            // Include current house, must have skipped prev house
            int case1=storage[i-2]+nums[i-1];

            // Cannot include current house because prev included
            int case2=storage[i-1];

            storage[i]=Math.max(case1, case2);
        }

        return storage[m];
    }

    public int rob(int[] nums) {
        //1. Exhaustive recursive solution
        //return helper(nums, 0, 0);

        // 2. DP solution of the above exhaustive solution
        return dp(nums);
    }
}
