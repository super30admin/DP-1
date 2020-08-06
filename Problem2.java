/* House Robber- Find the maximum money you can rob */

/* 3. DP solution with O(1) constant space complexity */
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Np


// Your code here along with comments explaining your approach
//here we will consider DP only but to reduce from O(N) space complexity to constant O(1) space complexity
//here, we can just consider only previous values index [0] and [1] and can find sum every time
//this will reduce the space usage

class Solution {
    public int rob(int[] nums) {
        //edge case 
        if(nums == null || nums.length == 0) return 0;
        //initialise choose and not chosen index
        int chosen = 0;
        int notChosen = 0;
        for(int i = 0; i < nums.length; i++){
            //as not chosen at first index will be 0
            int temp = chosen;
            chosen = notChosen + nums[i];
            notChosen = Math.max(temp, notChosen);
        }
        return Math.max(chosen, notChosen);
    }
}

/* 2. DP Solution 
//Time: O(N) Space: O(N)
//so here we will observe that in recursive, we were having overlapping subproblems
//so to optimise the solution, we will consider memoization solution
//we will have [0,1] with [NotChosen, Chosen] and by creating matrix[][]
//we will initialise sum at each iteration.

class Solution {
    public int rob(int[] nums) {
        //edge case
        if(nums == null || nums.length == 0) return 0;
        //initialise dp matrix with [coins length][2]
        //2 is for [0,1][not chosen, chosen]
        int[][] dp = new int[nums.length][2];
        //for index 0 i.e. when first house is encountered
        //initialise 0(not chosen) and house amount(not chosen)
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        //iterate over next index
        for(int i = 1; i < nums.length; i++){
            //iterate over index from 0 for not chosen
            for(int j = 0; j < 2; j++){
                if(j == 0){
                    //finding max of previous values for both chosen and not chosen
                    dp[i][j] = Math.max(dp[i-1][0], dp[i-1][1]);
                } else {
                    dp[i][j] = dp[i-1][0] + nums[i];
                }
            }
        }
        //finding max of previous [0][1] values
        return Math.max(dp[dp.length - 1][0], dp[dp.length-1][1]);
    }
}

*/

/* 1. Recursive solution 
//Time: O(2^n) exponential, Space: O(n)
//so it will solve the problem but it will result in time limit exceeded
//approach-create a helper function-create two index: choosen and not chossen

class Solution {
    public int rob(int[] nums) {
        return helper(nums, 0, 0);
    }
    //create helper function-need nums array, index and calculated sum
    private int helper(int[] nums, int i, int sum){
        //base case
        if(i >= nums.length) return sum;
        //logic
        //1.choose index-increment by 2 as adjacent indexes not allowed
        int case1 = helper(nums, i+2, sum + nums[i]);
        //2.not choose index-iterate over next index and sum will remain same
        int case2 = helper(nums, i+1, sum);
        return Math.max(case1, case2);
    }
}

*/