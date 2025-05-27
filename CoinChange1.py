# Time Complexity: O(N * M), N = number of coins in coins list, M = amount
# Space Complexity: O(M) 
# Did this code successfully run on Leetcode: Yes

# Your code here along with comments explaining your approach
# I have used bottom up tabulation method with 1D dp matrix

from typing import List

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        rows = len(coins) + 1
        columns = amount + 1

        dp = [None] * columns
        dp[0] = 0

        for col in range(1, columns):
            dp[col] = float("inf")

        for row in range(1, rows):
            for col in range(columns):
                if coins[row - 1] > col:
                    dp[col] = dp[col]
                else:
                    dp[col] = min(dp[col], 1 + dp[col - coins[row - 1]])
        
        if dp[columns - 1] == float("inf"):
            return -1
        
        return dp[columns - 1]