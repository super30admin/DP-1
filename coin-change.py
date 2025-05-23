# We use dynamic programming to find the minimum number of coins needed to make up the amount.
# We initialize a dp array where dp[i] represents the minimum number of coins needed to make amount i, starting with dp[0] = 0.
# For each coin, we update the dp array by taking the minimum of the current value and the value of the amount minus the coin value plus one.

# Time Complexity : O(m * n)
# Space Complexity : O(m)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0
        for coin in coins:
            for x in range(coin, amount + 1):
                if dp[x - coin] != float('inf'):
                    dp[x] = min(dp[x], dp[x - coin] + 1)
        return dp[amount] if dp[amount] != float('inf') else -1
        