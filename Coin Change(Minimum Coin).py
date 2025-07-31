# We use bottom-up DP to build the solution for all amounts from 1 to target.
# dp[i] represents the minimum number of coins needed to make amount i.
# For each coin, we update dp[i] if using the coin results in a smaller count.

class Solution(object):
    def coinChange(self, coins, amount):
        max_val = amount + 1
        dp = [max_val] * (amount + 1)
        dp[0] = 0  # Base case: 0 coins to make amount 0

        for coin in coins:
            for i in range(coin, amount + 1):
                dp[i] = min(dp[i], dp[i - coin] + 1)

        return dp[amount] if dp[amount] != max_val else -1

