# TC = O(mn)
# SC = O(mn)
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m = len(coins) + 1
        n = amount + 1
        dp = [[0 for _ in range(n)] for _ in range(m)]
        dp[0][:] = [amount + 1] * n
        dp[:][0] = 0
        dp[0][0] = 0
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1)

        return dp[m - 1][n - 1] if dp[m - 1][n - 1] <= amount else -1
