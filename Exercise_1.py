"""
Time Complexity : O(m*n)
Space Complexity : O(m*n)
Did this code successfully run on Leetcode : Yes
"""

from typing import List

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m = amount
        n = len(coins)
        INF = float('inf')
        
        # Initialize dp with INF
        dp = [[INF] * (m + 1) for _ in range(n + 1)]
        
        # Base case: 0 coins to make amount 0
        for i in range(n + 1):
            dp[i][0] = 0

        # Fill the dp table
        for i in range(1, n + 1):
            for j in range(1, m + 1):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])

        return -1 if dp[n][m] > m+1 else dp[n][m]
