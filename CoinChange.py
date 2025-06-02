# Implementation Thought: Build a 1D DP array where dp[x] is the minimum coins needed to make amount x.
# Time Complexity: O(n * m), where n = len(coins) and m = amount, since we iterate over each coin and each sub‐amount.
# Space Complexity: O(m), due to the dp array of size amount + 1.

from typing import List

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0
        
        for coin in coins:
            for x in range(coin, amount + 1):
                dp[x] = min(dp[x], dp[x - coin] + 1)
        
        return dp[amount] if dp[amount] != float('inf') else -1