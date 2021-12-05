// Time Complexity : n = rows = coins.length & m = coulm = amount O(nm)
// Space Complexity : O(nm)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0)
            return -1;

        int dp[][] = new int[coins.length+1][amount+1];

        // initialize infinity
        for(int i = 1 ; i < amount+1 ; i ++)
        {
            dp[0][1] = amount+1; // infinity
        }

        for(int i = 1 ; i < coins.length +1 ; i++)
        {
            for(int j = 1; j < amount+1 ; j ++)
            {
                if(j < coins[i-1]) // there is no 1 case as it will result -ve amount
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1] + 1); // min(case 0, case 1 + 1)
            }
        }

        if(dp[coins.length][amount] > amount)
            return -1;

        return dp[coins.length][amount];
    }
}
