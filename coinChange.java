/**
Problem: https://leetcode.com/problems/coin-change/
TC: O(C * amount) where C = number of coins
SC: O(amount)
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        
        if (coins.length == 0) {
            return -1;
        }
        
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        
        for (int coin : coins) {
            for (int a = coin; a <= amount; ++a) {
                dp[a] = Math.min(dp[a], 1 + dp[a - coin]);
            }
        }
        
        return (dp[amount] == amount + 1 ? -1 : dp[amount]);
     }
}