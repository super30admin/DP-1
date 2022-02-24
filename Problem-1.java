// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[][] dp = new int[coins.length + 1][amount + 1];
        
        for(int i = 0; i < dp[0].length; i++) {
            
            dp[0][i] = amount + 1;
        }
        
        for(int i = 0; i < dp.length; i++) {
            
            dp[i][0] = 0;
        }
        
        for(int i = 1; i < dp.length; i++) {
            
            for(int j = 1; j < dp[0].length; j++) {
                
                if(j < coins[i-1]) {
                    
                    dp[i][j] = dp[i-1][j];
                } else {
                    
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]] + 1);
                }
            }
        }
        
        if(dp[coins.length][amount] == amount + 1) {
            
            return -1;
        }
        
        return dp[coins.length][amount];
    }
}