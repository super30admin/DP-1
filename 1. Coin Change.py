"""
Time Complexity : O(amount * n) -> two for loops to fill the dp matrix
Space Complexity : O(amount * n) for the dp matrix
"""
import math
class Solution:
    def coinChange(self, coins, amount: int) -> int:
        n = len(coins)

        # Creating a dp matrix of size (n+1) x (amount+1)
        dp = [[math.inf] * (amount + 1) for _ in range(n + 1)]
        for i in range(n + 1):
            dp[i][0] = 0

        for i in range(1, n + 1):
            for amnt in range(1, amount + 1):
                # Not choosing ith coin
                dp[i][amnt] = dp[i - 1][amnt]

                if amnt >= coins[i - 1]:
                    # Choosing the ith coin
                    dp[i][amnt] = min(dp[i][amnt], dp[i][amnt - coins[i - 1]] + 1)

        return dp[n][amount] if dp[n][amount] != math.inf else -1