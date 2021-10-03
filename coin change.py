# TC- O(m*n)
# SC- O(m*n)
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m = amount + 1
        n = len(coins) + 1
        dp = [[0 for i in range(m)] for j in range(n)]
        for i in range(1, m):
            dp[0][i] = float('inf')
        for j in range(n):
            dp[j][0] = 0
        for i in range(1, n):
            for j in range(1, m):
                if (j < coins[i - 1]):
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j])
        if (dp[n - 1][m - 1] == float('inf')):
            return -1
        else:
            return dp[n - 1][m - 1]

