# Time Complexity : O(m*n) where m is number of coins and n is amount+1
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

'''
Builds a 2D DP grid to find the minimum coins needed for each amount by comparing with previously computed amounts. 
Not memory-efficient — can be optimized to O(n) space with a 1D DP array.
'''
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m = len(coins) + 1  # rows
        n = amount + 1      # cols

        # Initialize dp table with 0s
        dp = [[0] * n for _ in range(m)]

        # Initialize first row: can't make any amount with 0 coins
        for j in range(1, n):
            dp[0][j] = 99999  # represents "infinity"

        # Fill the DP table
        for i in range(1, m):
            for j in range(1, n):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])

        ans = dp[m - 1][amount]
        return -1 if ans >= 99999 else ans