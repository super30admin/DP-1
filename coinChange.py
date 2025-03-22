# using DP to handle repeated sub problems from recursion
# TC: O(m * n) where is number of coins and n is amount
# SC: O(m * n) for dp table

from typing import List


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if not coins:
            return -1

        m = len(coins)
        n = amount
        dp = [[0] * (n + 1) for _ in range(m + 1)]

        # Initialize first row with amount + 1
        for j in range(1, n + 1):
            dp[0][j] = amount + 1

        # Fill DP table
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])

        return -1 if dp[m][n] == amount + 1 else dp[m][n]

    # Recursion:
    # def coinChange(self, coins: List[int], amount: int) -> int:
    #     if not coins:
    #         return -1
    #     return self.helper(coins, amount, 0, 0)

    # def helper(self, coins, amount, index, num_coins):
    #     # Base case
    #     if amount == 0:
    #         return num_coins
    #     if amount < 0 or index >= len(coins):
    #         return -1

    #     # Zero case (skip current coin)
    #     case1 = self.helper(coins, amount, index + 1, num_coins)

    #     # One case (choose current coin)
    #     case2 = self.helper(coins, amount - coins[index], index, num_coins + 1)

    #     if case1 == -1:
    #         return case2
    #     if case2 == -1:
    #         return case1

    #     return min(case1, case2)
