# Problem1 (https://leetcode.com/problems/coin-change/)
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m = len(coins)
        n = amount
        dp = [[None]*(n+1)]*(m+1)
        for i in range(m+1):
            dp[i][0] = 0
        for i in range(1,n+1):
            dp[0][i] = 99999
        for i in range(1, m+1):
            for j in range(1, n+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i-1][j - coins[i-1]])
        if dp[-1][-1] >= 99999:
            return -1
        return dp[-1][-1]

#time and space complexity O(m*n)
#used dynamic programming which reuse the results