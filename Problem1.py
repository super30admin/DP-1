class Solution:
    # Time Complexity :O(m * n)
    # Space Complexity :O(m * n)
    def coinChange(self, coins: List[int], amount: int) -> int:
        m = len(coins)
        n = amount
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        for j in range(1, amount + 1):
            dp[0][j] = float("inf")
        for i in range(1, m + 1):
            for j in range(1, amount + 1):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])
        if dp[m][amount] > amount:
            return -1
        return dp[m][amount]
