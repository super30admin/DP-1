                       // Coin Change

// Time Complexity : O(mn)   .. m = number of denominations, n = amount
// Space Complexity : O(mn)  .. 2D array required to store denominations and all posible amounts.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        
        // base case.
        for(int i=0;i<dp[0].length;i++){
            dp[0][i] = amount + 1; // can't put infinty, since adding it with 1 will give integer overflow.
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j >= coins[i-1]) 
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                else dp[i][j] = dp[i-1][j];
            }
        }

        return dp[coins.length][amount] > amount ? -1 : dp[coins.length][amount];
    }
}

                       // House Robber

// Time Complexity : O(n)   .. m = number of housees
// Space Complexity : O(1)  .. only used 2 variables.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int notRob = 0;
        int rob = nums[0];

        for(int i=1;i<n;i++){
            int temp = notRob;
            notRob = Math.max(rob, notRob);
            rob = nums[i] + temp;
        }
        return Math.max(rob, notRob);
    }
}
