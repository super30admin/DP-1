# Use bottom up DP to build a table of minimum coins needed for every amount up to the target.
# Initialize with inf, since we are minimizing base case: 0 coins for amount 0.
# For each coin update the DP table if using that coin reduces the coin count for a given amount.

# Time Complexity: O(amount * len(coins))
# Space Complexity: O(amount)


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0  # Base case: 0 coins needed for amount 0

        for coin in coins:
            for x in range(coin, amount + 1):
                dp[x] = min(dp[x], dp[x - coin] + 1)

        return dp[amount] if dp[amount] != float('inf') else -1
