// Time Complexity : O(n)
// Space Complexity : O(m*n)   (m - coins.length, n- dp.length)
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        
        for(int i=1; i< dp.length; i++){
            dp[i] = amount+1;
        }
        
        for(int j=1; j<= coins.length; j++) {
            for(int i=1; i< dp.length; i++) {
                if(coins[j-1] <= i)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j-1]]);
            }
        }
        int result = dp[dp.length -1];
        if(result > amount) return -1;
        return result;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : was hard to find logic for the dp array


// Your code here along with comments explaining your approach
class Solution2 {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        
        dp[0] = nums[0];
        
        if(dp.length == 1)
            return dp[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        if(dp.length == 2)
            return dp[1];
        
        for(int i=2; i<nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[dp.length - 1];
    }
}