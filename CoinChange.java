// Time Complexity : O(coins*amount)
// Space Complexity : O(coins*amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We form a DP Matrix, which is index vs amount.
    It is formed by forming sub-problems by varying the available coins and the amount.
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int [][] dp = new int[coins.length+1][amount+1];
        
        for (int i=0; i<=amount; i++)
            dp[0][i] = amount+1;
        
        for (int i=0; i<=coins.length; i++)
            dp[i][0] = 0;
        
        for (int i=1; i<=coins.length; i++){
            for (int j=1; j<=amount; j++){
                if (j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else 
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]]+1);
            }
        }
        
        int r = dp[coins.length][amount];
        if (r>=amount+1)
            return -1;
        return r;
    }
}