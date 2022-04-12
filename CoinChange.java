// Time Complexity : O(m x n)
// Explaination : m is the amount, n is length of coins. We go through all available coins for each X amount till amount
// Space Complexity : O(m)
// Explaination : cache will contain 1 entry for each element till max amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : yes, found it difficult to follow Raj's example of 2D array
// Time taken : 50+ mins

import java.util.Arrays;

public class CoinChange {
    /*
    based on Raj's solution with 2D array

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
            return 0;

        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=1; i<amount+1; i++)
            dp[0][i] = amount+1;

        for(int i=1; i<coins.length+1; i++){
            for(int j=1; j<amount+1; j++){
                if(j<coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
            }
        }
        if(dp[coins.length][amount] == amount+1) return -1;
        return dp[coins.length][amount];
    }*/

    /*
    Input: coins = [1,2,5], amount = 11
    Output: 3
    starting cache [12  12  12  12  12  12  12  12  12  12  12  12]
    * amount 0  1   2   3   4   5   6   7   8   9   10  11
    * coins
        1   0   1   2   2   3   5   3   3   3   4   4   3
        2   0   -   1   2   2   4   3   2   3   3   4   4
        5   0   -   -   -   -   1   2   2   3   3   2   3
    final = min of column
            0   1   1   2   2   1   2   2   3   3   2   3 --> final element is return val
    * */


    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
            return 0;

        // Cache for making till X amount
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);

        // 0 coins to make 0 amount
        dp[0] = 0;

        // dp[0] already filled so starting with dp[1]
        for (int currAmt = 1; currAmt<=amount; currAmt++){
            // for each amount value till amount, check each coin
            for (int coin : coins) {
                if (currAmt-coin >= 0){
                    // 1+... to consider current coin
                    dp[currAmt] = Math.min(dp[currAmt], 1+dp[currAmt-coin]);
                }
            }
        }
        // if last val in array is still max, means we didnt find the solution
        return (dp[amount] == amount+1) ? -1 : dp[amount];
    }
}
