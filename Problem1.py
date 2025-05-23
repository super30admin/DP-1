"""
I implemented using the technique taught in the session and homework solutions
Time Complexity: O(n * amount)
Space Complexity: O(n * amount)
"""
class Solution:
    def coinChange(self, coins, amount):
        dp = [[0 if j == 0 else 99999 for j in range(amount + 1)] for _ in range(len(coins) + 1)]

        for i in range(1, len(coins) + 1):
            for j in range(1, amount + 1):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])
        result = dp[len(coins)][amount]
        return -1 if result >= 99999 else result