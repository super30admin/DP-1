// Time Complexity : O(N) // M is number of coins, N is the target amount
// Space Complexity : O(N) -- if array used else O(1) if 3 variables used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to go through the pattern formation as discussed in the class

/* Approach -
 * build the initial row of matrix and according to tree form a pattern while filling the matrix
 * 
 */


// Your code here along with comments explaining your approach


class Solution {
    public int rob(int[] nums) {
        // return maxCoins(nums,0,0); // for recursive solution

        // int[] dp = new int[nums.length];
        // if (nums.length < 2) return nums[0];
        // dp[0] = nums[0];
        // dp[1] = Math.max(nums[0],nums[1]);
        // for(int i=2;i<nums.length;i++){
        //     dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
        // }
        // return dp[nums.length-1];

        if (nums.length < 2) return nums[0];
        int prev = nums[0];
        int curr = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            int temp = curr;
            curr = Math.max(curr,nums[i]+prev);
            prev = temp;
        }
        return curr;
        
}
    // Recursion helper function-- //
    // private int maxCoins(int[] nums, int idx, int amount){
    //     // base case
    //     if(idx >= nums.length){
    //         return amount;
    //     }

    //     // case1 - we take
    //     int case1 = maxCoins(nums,idx+2,amount+nums[idx]);

    //     // case2 - we don't take
    //     int case2 = maxCoins(nums,idx+1,amount);

    //     if(case1 > case2) return case1;
    //     return case2;
    // }

}