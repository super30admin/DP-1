// Time Complexity : O(m × n), where m = number of different coins and n = the target amount
// Space Complexity : O(n), for the dp array of size (amount + 1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Faced difficulty formulating the DP state and transition initially, but the logic became clear after breaking down subproblems.

// Your code here along with comments explaining your approach
/*
This is a classic DP problem where we compute the minimum number of coins needed for every amount from 1 to 'amount'.
We initialize dp[0] = 0 (0 coins needed to make amount 0). For each amount i from 1 to amount, we iterate through each coin.
If the coin is usable (coin <= i) and dp[i - coin] is not Integer.MAX_VALUE, we update dp[i] with the minimum of its current value or (1 + dp[i - coin]).
At the end, if dp[amount] is still Integer.MAX_VALUE, that means it's not possible to form that amount with given coins, so we return -1.
Otherwise, we return dp[amount].
*/


public class CoinChange {
    public int coinChange(int[] coins, int amount){
        if(amount < 1){
            return 0;
        }

        int[] dp = new int[amount + 1];

        for(int i = 1; i <= amount; i++){
            dp[i] = Integer.MAX_VALUE;

            for(int coin : coins){
                if(coin <= i && dp[i - coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        if(dp[amount] == Integer.MAX_VALUE){
            return -1;
        }

        return dp[amount];
    }
}
