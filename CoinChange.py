# Time Complexity : O(m*n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : dp[i] is the min coins to make amount i.
# For each coin, update the array by either using coin or skipping it.
# At the end, if dp[n] is still inf, it means amount can’t be formed.

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0

        for coin in coins:
            for a in range(coin, amount + 1):
                dp[a] = min(dp[a], dp[a-coin] + 1)

        if dp[amount] == float('inf'):
            return -1

        return dp[amount]