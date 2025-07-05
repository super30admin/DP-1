# Time Complexity:
# O(n * amt)

# Space Complexity:
# O(n * amt)
class Solution(object):
    def coinChange(self, coins, amount):
        n = len(coins)
        dp = [[float('inf')] * (amount + 1) for _ in range(n + 1)]

        # Base case: zero coins needed to make amount 0
        for i in range(n + 1):
            dp[i][0] = 0

        for i in range(1, n + 1):  # Loop through coins
            for j in range(1, amount + 1):  # Loop through amounts
                if coins[i - 1] > j:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])

        return -1 if dp[n][amount] == float('inf') else dp[n][amount]
