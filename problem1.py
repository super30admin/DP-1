# Time Complexity : O(m*n) where m is the number of coins and n is the amount, because we are iterating through the dp array once
# Space Complexity : O(m*n) because we are using a 2D dp array of size m*n
# Did this code successfully run on Leetcode : yes 
# Any problem you faced while coding this : yes, first time solving dp probem, had a hard time understanding the approach, but after watching the video and dry running the code, I was able to understand it and implement it successfully.

class Solution(object):
    def coinChange(self, coins, amount):
        m, n = len(coins), amount
        dp = [[0] * (n+1) for _ in range(m+1)]

        for j in range(1, n+1):
            dp[0][j] = 99999

        for i in range(1, m + 1):
            for j in range(n + 1):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])

        return -1 if dp[m][n] == 99999 else dp[m][n]
        